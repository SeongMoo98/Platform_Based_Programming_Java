package com.fm;

import com.fm.controller.SearchPlayerController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DeletePlayerActionListener implements ActionListener {
    private JTable foundPlayer;
    private SearchPlayerController controller;

    public DeletePlayerActionListener(JTable foundPlayer, SearchPlayerController controller) {
        super();
        this.foundPlayer = foundPlayer;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel)foundPlayer.getModel();
        Object selectedRow = model.getDataVector().get(foundPlayer.getSelectedRow());
        int playerID = ((Integer) ((Vector) selectedRow).get(0)).intValue();
        //your code here
        controller.deletePlayer(playerID);
    }
}

