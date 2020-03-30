package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMenu implements GraphicalMenu {

    final String TITLE = "Create Menu";



    JFrame f;
    JFrame previousFrame;

    JButton placeholderOne;
    JButton placeholderTwo;
    JButton placeholderThree;
    JButton placeholderFour;
    JButton placeholderFive;

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

        this.placeholderOne = addButton("Tilføj Barn", 10, 10, 100, 40);

        this.cpr_nummer = addTextField(120, 10, 100, 40);


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

    public JTextField addTextField(int bPosX, int bPosY, int width, int height){

        JTextField t = new JTextField();

        t.setBounds(bPosX, bPosY, width, height);
        f.add(t);

        t.addActionListener(this);

        return t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == placeholderOne){
            System.out.println(cpr_nummer.getText());

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


