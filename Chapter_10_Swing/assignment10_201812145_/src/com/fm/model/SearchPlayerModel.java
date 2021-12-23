package com.fm.model;

import com.fm.repository.PlayerRepository;

import javax.swing.table.DefaultTableModel;

public class SearchPlayerModel extends DefaultTableModel {
    //Object[] columnNames
    public static final Object[] TABLE_HEADER = { "ID", "Player Name", "Height", "Nationality", "Club", "Overall", "positions" };

    static {
        PlayerRepository.getInstance().load();
    }

    // JTable(Object[][] rowdata, Object[] columnNames)
    // Object[][] data: Repository에서 load ==> toArray() ==> String[][]
    // Object[] columnNames : TABLE_HEADER
    public SearchPlayerModel() {
        super(PlayerRepository.getInstance().toArray(), TABLE_HEADER);
    }
}
