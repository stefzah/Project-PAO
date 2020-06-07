package com.company;

import com.company.Events.DataExtractor;
import com.company.Events.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends JFrame{
    private JButton newGameButton;
    private JButton continueButton;
    public JPanel panelMain;
    static public JFrame instance;
    static public boolean closed;
    public App() {
        closed = false;
        instance = this;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(panelMain);
        pack();
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.newGame();
                //setEnabled(false);
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game.continueGame();
                //setEnabled(false);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closed = true;
            }
        });

    }


    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }
}
