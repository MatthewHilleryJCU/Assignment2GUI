package com.codebind;

import javax.swing.*;

public class appGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new mainFrame("Matthew Hillery Assignment 2 CP2406");
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}