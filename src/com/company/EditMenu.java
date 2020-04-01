package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditMenu extends Crud implements GraphicalMenu {

    final String TITLE = "Read Menu";
//Rediger Vindue knapper + text fields
    JFrame f;
    JFrame previousFrame;

    JButton searchButton;
    JButton editButton;
    JButton returnButton;

    JTextField searchFieldText;
    JTextField idText;
    JTextField dropDownSearchText;
    JTextArea searchResultsArea;

    //Popup menu knapper + text fields
    JFrame popupMenu;

    JButton accept;
    JButton delete;
    JButton returnToSearch;

    JTextField navn;
    JTextField cprNummer;
    JTextField adresse;
    JTextField stue;


    public EditMenu(JFrame previousFrame){

        addFrame(TITLE, 400, 500);
        this.previousFrame = previousFrame;

    }

    @Override
    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);


        searchFieldText = addTextField("Indtast søgning", 140 , 10, 100, 20, f);
        searchButton = addButton("Søg", 250, 35, 100, 20, f);

        searchFieldText = addTextField("Indtast ID", 140 , 170, 100, 20, f);
        editButton = addButton("Rediger", 250, 170, 100, 20, f);

        searchResultsArea = addTextArea(reader("Børn"), f);

        this.returnButton = addButton("Return", 10, 410, 100, 40, f);

        f.setLayout(null);
        f.setVisible(false);

    }

    public void popUpFrame(String windowName, int sizeX, int sizeY, int id){

        this.popupMenu = new JFrame(windowName);
        popupMenu.setSize(sizeX, sizeY);

        accept = addButton("Accepter", 0, 240, 90, 20, popupMenu);
        delete = addButton("Delete", 95 , 240, 90, 20,popupMenu);
        returnToSearch = addButton("Annuller", 190, 240, 90, 20,popupMenu);

        navn = addTextField("Navn", 100, 10, 180, 20, popupMenu);
        cprNummer = addTextField("Cpr Nummer", 100, 40, 180, 20, popupMenu);
        adresse = addTextField("Adresse", 100, 70, 180, 20, popupMenu);
        stue = addTextField("Stue", 100, 100, 180, 20, popupMenu);






        popupMenu.setLayout(null);
        popupMenu.setVisible(true);


    }

    public JTextArea addTextArea(String populateData, JFrame frame){

        JTextArea a = new JTextArea();

        a.setText(populateData);
        JScrollPane scrollPane = new JScrollPane(a);
        a.setBounds(10, 200, 370, 200);

        frame.add(a);

        return a;
    }

    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height, JFrame frame) {
        JButton b = new JButton(textField);
        b.setBounds(bPosX, bPosY, width, height);
        frame.add(b);

        b.addActionListener(this);

        return b;

    }

    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height) {
        return null;
    }

    public JTextField addTextField(String text, int bPosX, int bPosY, int width, int height, JFrame frame){

        JLabel label = new JLabel(text);
        label.setBounds(bPosX-100, bPosY, width, height);
        frame.add(label);

        JTextField t = new JTextField();
        t.setBounds(bPosX, bPosY, width, height);
        frame.add(t);

        t.addActionListener(this);

        return t;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==searchButton){
            searchResultsArea.setText(reader("Forældre"));

        }

        if(e.getSource()==editButton){

            popUpFrame("Rediger Info", 300, 300, Integer.parseInt(searchFieldText.getText()));


        }
        if(e.getSource()==accept){

        }

        if(e.getSource()==delete){}

        if(e.getSource()==returnToSearch){

            popupMenu.dispose();
        }


        if(e.getSource()==returnButton){

            previousFrame.setVisible(true);
            f.dispose();
            popupMenu.dispose();
        }


    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }
}
