package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReadMenu implements GraphicalMenu {

    final String TITLE = "Read Menu";

    JFrame f;
    JFrame previousFrame;

    JButton placeholderOne;
    JButton placeholderTwo;
    JButton placeholderThree;
    JButton placeholderFour;
    JButton placeholderFive;

    public ReadMenu(JFrame previousFrame){

        addFrame(TITLE, 400, 500);
        this.previousFrame = previousFrame;

    }

    @Override
    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        this.placeholderOne = addButton("TBA1", 10, 10, 100, 40);
        this.placeholderTwo = addButton("TBA2", 10, 60, 100, 40);
        this.placeholderThree = addButton("TBA3", 10, 110, 100, 40);
        this.placeholderFour = addButton("TBA4", 10, 160, 100, 40);

        this.placeholderFive = addButton("Return", 10, 410, 100, 40);

        f.setLayout(null);
        f.setVisible(false);

    }

    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height) {
        JButton b = new JButton(textField);
        b.setBounds(bPosX, bPosY, width, height);
        f.add(b);

        b.addActionListener(this);

        return b;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==placeholderFive){

            previousFrame.setVisible(true);
            f.dispose();
        }

    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }
}
