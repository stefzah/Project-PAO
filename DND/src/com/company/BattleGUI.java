package com.company;

import com.company.Events.Battle;
import com.company.Events.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleGUI extends JFrame{
    private JTextArea campaignInfo;
    private JTextArea enemyInfo;
    private JButton surrenderButton;
    private JButton buttonFight;
    private JPanel panelMain;
    static public JFrame instance;

    public BattleGUI() {
        instance = this;
        setContentPane(panelMain);
        String[] str = Battle.showInfo();
        campaignInfo.setText(str[0]);
        enemyInfo.setText(str[1]);
        MapGUI.instance.setEnabled(false);


        pack();
        buttonFight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Battle.fight();
                MapGUI.instance.setEnabled(true);
                dispose();
            }
        });

        surrenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Battle.surrender();
                MapGUI.instance.setEnabled(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        BattleGUI app = new BattleGUI();
        app.setVisible(true);
    }

}
