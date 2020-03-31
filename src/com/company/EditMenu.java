package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditMenu extends Crud implements GraphicalMenu {

    final String TITLE = "Read Menu";

    JFrame f;
    JFrame previousFrame;

    JButton searchButton;
    JButton editButton;
    JButton returnButton;

    JTextField searchFieldText;
    JTextField idText;
    JTextField dropDownSearchText;

    JTextArea searchResultsArea;


    public EditMenu(JFrame previousFrame){

        addFrame(TITLE, 400, 500);
        this.previousFrame = previousFrame;

    }

    @Override
    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        //f.getContentPane().setLayout(new FlowLayout());

        searchFieldText = addTextField("Indtast søgning", 140 , 10, 100, 20);
        searchButton = addButton("Søg", 250, 35, 100, 20);


        searchFieldText = addTextField("Indtast ID", 140 , 170, 100, 20);
        editButton = addButton("Rediger", 250, 170, 100, 20);


        searchResultsArea = addTextArea(reader("Børn"));



        this.returnButton = addButton("Return", 10, 410, 100, 40);





        f.setLayout(null);
        f.setVisible(false);

    }

    public JTextArea addTextArea(String populateData){

        JTextArea a = new JTextArea();

        a.setText(populateData);
        JScrollPane scrollPane = new JScrollPane(a);
        a.setBounds(10, 200, 370, 200);

        f.add(a);




        return a;
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

        if(e.getSource()==searchButton){
            searchResultsArea.setText(reader("Forældre"));



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
