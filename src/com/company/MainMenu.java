package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Crud implements GraphicalMenu {

    final String TITLE = "Main Menu";

    JFrame f;
    JButton create;
    JButton editMenuButton;
    JButton quit;

    EditMenu editMenu;
    CreateMenu createMenu;


    public MainMenu() {

        createMainMenu();


    }
    public void createMainMenu(){
        addFrame(TITLE, 400, 500);

    }


    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        this.create = addButton("Tilføj Barn", 95, 10, 200, 40);
        this.editMenuButton = addButton("Rediger/Søg Børn", 95, 60, 200, 40);


        this.quit = addButton("Quit", 10, 410, 100, 40);

        f.setLayout(null);
        f.setVisible(true);
    }

    @Override
    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height, JFrame frame) {
        return null;
    }


    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height) {
        JButton b = new JButton(textField);
        b.setBounds(bPosX, bPosY, width, height);
        f.add(b);

        b.addActionListener(this);

        return b;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit) {
            f.dispose();
        }
        if (e.getSource() == create){
            this.createMenu = new CreateMenu(f);
            createMenu.setVisibility(true);



            this.setVisibility(false);
        }
        if (e.getSource() == editMenuButton){
            this.editMenu = new EditMenu(f);
            editMenu.setVisibility(true);
            this.setVisibility(false);
        }


    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }

}
