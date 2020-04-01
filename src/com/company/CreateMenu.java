package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMenu extends Crud implements GraphicalMenu {

    final String TITLE = "Create Menu";

    JFrame f;
    JFrame previousFrame;

    JButton addChildButton;
    JButton placeholderTwo;
    JButton placeholderThree;
    JButton placeholderFour;
    JButton returnButton;

    JTextField cpr_nummer;
    JTextField navn;
    JTextField adresse;
    JTextField stue; //drop down menu?

    String stringCprNummer;
    String stringNavn;
    String stringAdresse;
    String stringStue;

    public CreateMenu(JFrame previousFrame){
        addFrame(TITLE, 400, 500);

        this.previousFrame = previousFrame;
    }


    @Override
    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        this.addChildButton = addButton("Tilføj Barn", 140, 300, 100, 40);

        this.cpr_nummer = addTextField("Cpr Nummer:", 140, 10, 100, 20);
        this.navn = addTextField("Navn:", 140, 35, 100, 20);
        this.adresse = addTextField("Adresse:",140, 60, 100, 20);
        this.stue = addTextField("Stue:", 140, 85, 100, 20);

        this.returnButton = addButton("Return", 10, 410, 100, 40);

        f.setLayout(null);
        f.setVisible(false);
    }

    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height, JFrame frame) {
        return null;
    }


    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height) {
        JButton b = new JButton(textField);
        b.setBounds(bPosX, bPosY, width, height);
        f.add(b);

        b.addActionListener(this);

        return b;
    }

    public JTextField addTextField(int bPosX, int bPosY, int width, int height){

        JTextField t = new JTextField();

        t.setBounds(bPosX, bPosY, width, height);
        f.add(t);

        t.addActionListener(this);

        return t;
    }

    public JTextField addTextField(String text, int bPosX, int bPosY, int width, int height){

        JLabel label = new JLabel(text);
        label.setBounds(bPosX-100, bPosY, width, height);
        f.add(label);

        JTextField t = new JTextField();
        t.setBounds(bPosX, bPosY, width, height);
        f.add(t);

        t.addActionListener(this);

        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addChildButton){
            insertChild(cpr_nummer.getText(), navn.getText(), adresse.getText(), Integer.parseInt(stue.getText()));


        }
        if(e.getSource()==returnButton){

            previousFrame.setVisible(true);
            f.dispose();
        }

    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }


}
