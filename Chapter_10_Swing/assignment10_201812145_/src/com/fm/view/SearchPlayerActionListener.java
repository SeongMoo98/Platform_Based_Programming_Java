package com.fm.view;

import com.fm.controller.SearchPlayerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//controller에게 검색정보를 전달해주는 ActionListener
public class SearchPlayerActionListener implements ActionListener {
    //SearchPlayerView에 입력한 JTextFields(Search)
    //getName() : name, club, position, nationality 중 하나
    //getText() : L.Messi...
    private JTextField[] searchTermTextFields;
    private SearchPlayerController controller;

    public SearchPlayerActionListener(JTextField[] searchTermTextFields, SearchPlayerController controller) {
        super();
        this.searchTermTextFields = searchTermTextFields;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<SearchCondition> searchConditions = new ArrayList<>();
        for(int i=0; i<searchTermTextFields.length; i++){
            if(searchTermTextFields[i].getText().equals("")) continue;
            searchConditions.add(new SearchCondition(searchTermTextFields[i].getName(),searchTermTextFields[i].getText()));
        }
        controller.searchPlayer(searchConditions);

    }
}
