package com.company;

import com.company.Events.DataExtractor;
import com.company.Events.Logger;
import com.company.Events.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MapGUI extends JFrame {
    private JPanel panelMain;
    private JButton downButton;
    private JButton upButton;
    private JButton leftButton;
    private JButton restButton;
    private JButton rightButton;
    private JButton saveButton;
    private JTextArea infoText;
    private JTable mapTable;
    private JPanel mapPanel;
    static public JFrame instance;

    public MapGUI() {
        instance = this;
        App.instance.setEnabled(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelMain);
        pack();

        infoText.setText(Map.campaign.showInfo());
        updateGUIMap();

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map.goNorth();
                updateGUIMap();
            }
        });

        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map.goSouth();
                updateGUIMap();
            }
        });

        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map.goWest();
                updateGUIMap();
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Map.goEast();
                updateGUIMap();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataExtractor csvScanner = DataExtractor.getInstance();
                csvScanner.loadMapData(Map.place);
                Logger.log("MapGUI::Save");
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                App.instance.setEnabled(true);
            }
        });


    }

    public static void main(String[] args) {
        MapGUI app = new MapGUI();
        app.setVisible(true);
    }

    private void createUIComponents() {
        int numCols = Map.getWidth()+2;
        int numRows = Map.getLength()+2;
        DefaultTableModel model = new DefaultTableModel(numRows, numCols);
        mapTable = new JTable(model);
    }
    private void updateGUIMap(){
        int numCols = Map.getWidth()+2;
        int numRows = Map.getLength()+2;
        String str = Map.show();
        int ct=0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                mapTable.setValueAt(str.charAt(ct),i,j);
                ct++;
            }
        }
        infoText.setText(Map.campaign.showInfo());

    }

}
