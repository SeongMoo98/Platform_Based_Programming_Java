package com.fm.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;


public class DatabaseTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pnu.cse");
    private static EntityManager em = emf.createEntityManager();
    private static PlayerRepository playerRepository = new PlayerRepository(Player.class, em);

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("JPA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new PlayerView();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    private static class PlayerView extends JPanel implements ActionListener {
        private JTextArea textArea;
        private JButton[] buttons = new JButton[3];
        private JTextField[] fields = new JTextField[6];
        private JLabel[] labels = new JLabel[6];
        private JPanel[] panels = new JPanel[6];

        public PlayerView() {
            super(new BorderLayout());
            for (int i = 0; i < 6; i++) {
                fields[i] = new JTextField(40);
                labels[i] = new JLabel();
                panels[i] = new JPanel();
            }
            fields[0].setName("NAME");labels[0].setText("Name");
            fields[1].setName("HEIGHT");labels[1].setText("Height");
            fields[2].setName("CLUB");labels[2].setText("Club");
            fields[3].setName("COUNTRY");labels[3].setText("Country");
            fields[4].setName("OVERALL");labels[4].setText("Overall");
            fields[5].setName("POSITIONS");labels[5].setText("Positions");

            //Register Button
            buttons[0] = new JButton("Register"); buttons[0].setActionCommand("register"); buttons[0].addActionListener(this);
            //Search Button
            buttons[1] = new JButton("Search"); buttons[1].setActionCommand("search"); buttons[1].addActionListener(this);
            //Delete Button
            buttons[2] = new JButton("Delete"); buttons[2].setActionCommand("delete"); buttons[2].addActionListener(this);

            textArea = new JTextArea(30, 100);
            textArea.setMargin(new Insets(5, 5, 5, 5));
            textArea.setEditable(false);

            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for (int i = 0; i < 6; i++) {
                panels[i].add(labels[i], "West");
                panels[i].add(fields[i], "East");
                add(panels[i]);
            }

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(buttons[0]); buttonPanel.add(buttons[1]); buttonPanel.add(buttons[2]);
            add(buttonPanel);
            add(textArea);
            add(new JScrollPane(textArea));
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "register": {
                    Player newPlayer = newPlayer(fields);
                    playerRepository.save(newPlayer);
                    textArea.setText(newPlayer.toString()+" is registered!");
                    break;
                }
                case "search": {
                    textArea.setText("");
                    for (int i = 0; i < 6; i++)
                        fields[i].setEnabled(false);
                    List<Player> searchList = searchFields(fields);
                    for (Player p : searchList) {
                        textArea.append(p.toString() + "\n");
                    }
                    break;
                }
                case "delete": {
                    textArea.setText("");
                    for (int i = 0; i < 6; i++)
                        fields[i].setEnabled(false);
                    List<Player> deleteList = searchFields(fields);
                    for (Player p : deleteList) {
                        playerRepository.deleteById(p.getId());
                        textArea.append(p.toString()+" is Deleted\n");
                    }
                    break;
                }
            }
            for (int i = 0; i < 6; i++)
                fields[i].setEnabled(true);
            for (int i = 0; i < 6; i++)
                fields[i].setText("");
        }
    }
    //Textfield의 Text로 Player생성
    public static Player newPlayer(JTextField[] fields){
        Club club =new Club();
        Country country = new Country();
        club.setName(fields[2].getText());
        country.setName(fields[3].getText());

        Player returnPlayer = new Player();

        returnPlayer.setName(fields[0].getText());
        returnPlayer.setHeight(Integer.parseInt(fields[1].getText()));
        returnPlayer.setClub(club);
        returnPlayer.setCountry(country);
        returnPlayer.setOverall(Integer.parseInt(fields[4].getText()));
        returnPlayer.setPositions(fields[5].getText());
        return returnPlayer;
    }

    //Textfield의 Text로 Search
    public static List<Player> searchFields(JTextField[] fields){
        List<Player> list = playerRepository.findAll();
        for(int i=0; i<6; i++) {
            String searchName = fields[i].getName(); String searchCondition = fields[i].getText();
            if(searchCondition.equals(""))
                continue;
            switch (searchName) {
                case "NAME":
                    list = list.stream().filter(p -> p.getName().contains(searchCondition)).collect(Collectors.toList());
                    break;
                case "HEIGHT":
                    list = list.stream().filter(p -> p.getHeight() == (Integer.parseInt(searchCondition))).collect(Collectors.toList());
                    break;
                case "CLUB":
                    list = list.stream().filter(p -> p.getClub().getName().contains(searchCondition)).collect(Collectors.toList());
                    break;
                case "COUNTRY":
                    list = list.stream().filter(p -> p.getCountry().getName().contains(searchCondition)).collect(Collectors.toList());
                    break;
                case "OVERALL":
                    list = list.stream().filter(p -> p.getOverall() == (Integer.parseInt(searchCondition))).collect(Collectors.toList());
                    break;
                case "POSITIONS":
                    list = list.stream().filter(p -> p.getPositions().contains(searchCondition)).collect(Collectors.toList());
                    break;
            }
        }
        return list;
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
