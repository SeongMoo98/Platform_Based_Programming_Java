package com.fm.view;

import com.fm.CreatePlayerDialog;
import com.fm.DeletePlayerActionListener;
import com.fm.controller.SearchPlayerController;
import com.fm.model.SearchPlayerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class SearchPlayerView extends JFrame {
    private JTextField st1, st2, st3, st4;
    private JLabel l1, l2, l3, l4;
    private JPanel p1, p2, p3, p4, p5;
    private JButton Search, Create, Delete;
    private JTable table;
//    private JTextField[] str = new JTextField[4];
//    for(int i=0;i<4;i++){
//        str[i]=new JTextField(40);
//    }


    public SearchPlayerView(SearchPlayerController controller, SearchPlayerModel model){
        st1 = new JTextField(40); l1 = new JLabel("name");
        st2 = new JTextField(40); l2 = new JLabel("club");
        st3 = new JTextField(40); l3 = new JLabel("position");
        st4 = new JTextField(40); l4 = new JLabel("nationality");
        st1.setName("name"); st2.setName("club"); st3.setName("position"); st4.setName("nationality");
        JTextField[] searchText = {st1, st2, st3, st4};




        //Table - model을 view
        table = new JTable();
        table.setModel(model);
        table.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(table);

        //Search Button
        //Search 버튼을 SearchPlayerActionListener에 등록
        //==>Event가 있으면 SearchPlayerActionListener의 ActionPerformed 호출
        Search = new JButton("Search");
        Search.addActionListener(new SearchPlayerActionListener(searchText, controller));

        //Create Button
        //Event가 있으면 Dialog 띄우기
        Create = new JButton("Create");
        Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatePlayerDialog createPlayerDialog = new CreatePlayerDialog(controller);
                createPlayerDialog.setVisible(true);
            }
        });

        //Delete Button
        //Event가 있으면 Dialog 띄우기
        Delete = new JButton("Delete");
        Delete.addActionListener(new DeletePlayerActionListener(table, controller));

        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(l1,"West"); //서쪽으로 Layout
        p1.add(st1,"East"); //동쪽으로 Layout


        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(l2,"West");
        p2.add(st2,"East");

        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(l3,"West");
        p3.add(st3,"East");

        p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        p4.add(l4,"West");
        p4.add(st4,"East");

        p5 = new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.RIGHT)); //버튼을 a row로 add, 오른쪽정렬
        p5.add(Search);
        p5.add(Create);
        p5.add(Delete);

        setLayout(new BoxLayout(getContentPane(), Y_AXIS)); //BoxLayout - Y방향으로 내려감
        add(p1); add(p2); add(p3); add(p4); add(p5);
        add(scrollPane);
    }

}

