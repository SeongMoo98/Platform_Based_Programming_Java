package com.fm.client;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fm.unit.Player;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpServer;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.ExecutionException;

public class PlayerClient {
    private static final String baseURL = "http://localhost:9000/players?";
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("SearchPlayers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new SearchPlayerView();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    private static class SearchPlayerView extends JPanel implements ActionListener, PropertyChangeListener {
        private JButton searchButton;
        private JTextArea taskOutput;
        private Task task;
        private JTextField[] searchConditions = new JTextField[4];
        private JLabel[] labels = new JLabel[4];
        private JPanel[] searchPanel = new JPanel[4];

        public SearchPlayerView(){
            super(new BorderLayout());
            for(int i=0;i<4;i++){
                searchConditions[i] = new JTextField(40);
                labels[i] = new JLabel();
                labels[i].setBorder(BorderFactory.createEmptyBorder());
                searchPanel[i] = new JPanel();
            }
            searchConditions[0].setName("name"); labels[0].setText("name");
            searchConditions[1].setName("club"); labels[1].setText("club");
            searchConditions[2].setName("position"); labels[2].setText("position");
            searchConditions[3].setName("nationality"); labels[3].setText("nationality");

            //Search Button
            searchButton = new JButton("Search");
            searchButton.setActionCommand("start");
            searchButton.setAlignmentX(CENTER_ALIGNMENT);
            searchButton.addActionListener(this);

            taskOutput = new JTextArea(30,100);
            taskOutput.setMargin(new Insets(5,5,5,5));
            taskOutput.setEditable(false);

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for(int i=0; i<4; i++) {
                searchPanel[i].add(labels[i],"West");
                searchPanel[i].add(searchConditions[i],"East");
                add(searchPanel[i]);
            }

            add(searchButton);
            add(taskOutput);
            add(new JScrollPane(taskOutput));
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            searchButton.setEnabled(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            task = new Task();
            task.addPropertyChangeListener(this);
            task.execute();
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                try {
                    List<Player> players = task.get();
                    taskOutput.setText(players.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }

        class Task extends SwingWorker<List<Player>, Void>{
            List<Player> players;
            @Override
            protected List<Player> doInBackground() {
                setProgress(0);
                String str = makeQuery();
                try {
                    HttpClient client = HttpClient.newBuilder()
                            .version(HttpClient.Version.HTTP_1_1)
                            .followRedirects(HttpClient.Redirect.NORMAL)
                            .build();

                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(baseURL+str))
                            .timeout(Duration.ofMinutes(1))
                            .header("Content-Type","applicaion/json")
                            .GET()
                            .build();

                    HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
                    String result = response.body();

                    ObjectMapper mapper = new ObjectMapper();
                    CollectionType playerListType = mapper.getTypeFactory().constructCollectionType(List.class, Player.class);
                    players=mapper.readValue(result, playerListType);
                    setProgress(100);

                } catch (JsonMappingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //PropertyChange에서 get으로 받음
                return players;
            }

            @Override
            public void done(){
                searchButton.setEnabled(true);
                setCursor(null); // turn off the wait cursor
                for(int i=0; i<4; i++){
                    searchConditions[i].setText("");
                }
            }


            //Search의 ActionPerformed에서 받은 String
            public String makeQuery(){
                List<String> fields=new ArrayList<>();
                List<String> conditions=new ArrayList<>();
                String str ="";
                for(int i=0; i<4; i++){
                    String field = searchConditions[i].getName();
                    String condition = searchConditions[i].getText();
                    if(condition.equals(""))
                        continue;
                    else {
                        if(i!=0)
                            str+="&";
                        str += field+"="+condition;
                    }
                }
                return str;
            }


        }
    }



}






