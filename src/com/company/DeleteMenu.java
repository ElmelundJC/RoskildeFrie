package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMenu extends Crud implements GraphicalMenu {

    final String TITLE = "Delete Menu";

    JFrame f;
    JFrame previousFrame;

    JButton placeholderOne;
    JButton placeholderTwo;
    JButton placeholderThree;
    JButton placeholderFour;
    JButton placeholderFive;

    JTextField placeholderTextOne;

    public DeleteMenu(JFrame previousFrame){

        addFrame(TITLE, 400, 500);
        this.previousFrame = previousFrame;

    }

    @Override
    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        this.placeholderOne = addButton("Delete", 10, 10, 100, 40);
        this.placeholderTextOne = addTextField("Insert Child ID", 120, 10, 100, 40);

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

    public JTextField addTextField(String text, int bPosX, int bPosY, int width, int height){

        JLabel label = new JLabel(text);
        label.setBounds(bPosX+100, bPosY, width, height);
        f.add(label);

        JTextField t = new JTextField();
        t.setBounds(bPosX, bPosY, width, height);
        f.add(t);

        t.addActionListener(this);

        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==placeholderOne){

            deleteRow(Integer.parseInt(placeholderTextOne.getText()));
        }

        if(e.getSource()==placeholderFive){

            previousFrame.setVisible(true);
            f.dispose();
        }

    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }
}
