package com.fm.controller;

import com.fm.model.SearchPlayerModel;
import com.fm.repository.PlayerRepository;
import com.fm.repository.PlayerSearchPredicateFactory;
import com.fm.view.SearchCondition;

import javax.swing.table.DefaultTableModel;
import java.util.Collections;
import java.util.List;

import com.fm.repository.PlayerRepository;

public class SearchPlayerController {
    DefaultTableModel model; //SearchPlayerModel(extends DefaultTableModel)의 Constructor로 넘겨줌

    public SearchPlayerController(DefaultTableModel model){
        this.model = model;
    }

    public void searchPlayer(List<SearchCondition> conditions){
        //SearchConditions ㅇ로 찾은 데이터를 Object[][]에 저장
        Object[][] newData = PlayerRepository.toArray(
                PlayerRepository.getInstance().query(PlayerSearchPredicateFactory.makeConditions(conditions)));

        //Object[][] newData를 model로 set
        //setDateVector(Vertor<> dataVector, Vector<> columnIdentifier)
        ////setDateVector(Object[][] dataVector, Object[] columnIdentifier)
        model.setDataVector(newData, SearchPlayerModel.TABLE_HEADER);
    }

    //Dialog에서 받은 List<String>으로 Object[] data만들고 Model에 추가
   public void createPlayer(List<String> fields){
        int MaxID = 0;
        for(int i=0; i<model.getDataVector().size(); i++){
            int temp = Integer.parseInt(String.valueOf(model.getDataVector().get(0).get(0)));
            if(temp >=Integer.parseInt(String.valueOf(model.getDataVector().get(i).get(0))))
                MaxID = temp;
        }
        Object[] data = {Integer.toString(MaxID+1),
                fields.get(0),
                Integer.parseInt(fields.get(1)),
                fields.get(2),
                fields.get(3),
                Integer.parseInt(fields.get(4)),
                Collections.singletonList(fields.get(5))
        };
       model.addRow(data);
    }


    public void deletePlayer(int playerID){
        for(int i=0; i < model.getRowCount(); i++){
            String ID = String.valueOf(model.getDataVector().get(i).get(0));
            if(ID.equals(String.valueOf(playerID))){
                model.removeRow(i);
                return;
            }
        }
    }

}

