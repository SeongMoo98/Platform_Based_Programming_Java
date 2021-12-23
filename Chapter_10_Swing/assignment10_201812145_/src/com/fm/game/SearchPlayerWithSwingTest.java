package com.fm.game;

import com.fm.controller.SearchPlayerController;
import com.fm.model.SearchPlayerModel;
import com.fm.view.SearchPlayerView;

import javax.swing.*;

public class SearchPlayerWithSwingTest extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void createAndShowGUI() throws Exception {

        // Create table com.fm.model
        SearchPlayerModel model = new SearchPlayerModel();
        // Create com.fm.controller
        SearchPlayerController controller = new SearchPlayerController(model);
        // Create com.fm.view
        SearchPlayerView view = new SearchPlayerView(controller, model);
        // Make the window appear
        view.setTitle("FM - Find Player");
        view.setSize(800, 800);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack();
        view.setVisible(true);
    }
}

/*JTable
* JTable에 data를 저장하는게 아니라
* Object[][] data라는 data를 TableModel로 바꿈
* JTable(Object[][] rowdata, Object[] columnNames)
* JTable(Vector rowData, Vector columnNames)
* JTable(TableModel dm)
*
* Object[][] data <--> JTableModel -Controller를 통해서
*/