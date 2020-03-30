package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame implements GraphicalMenu {

    final String TITLE = "Main Menu";

    JFrame f;
    JButton create;
    JButton read;
    JButton update;
    JButton delete;
    JButton quit;

    ReadMenu readMenu;
    CreateMenu createMenu;
    UpdateMenu updateMenu;
    DeleteMenu deleteMenu;


    public MainMenu() {

        createMainMenu();


    }
    public void createMainMenu(){
        addFrame(TITLE, 400, 500);

        this.readMenu = new ReadMenu(f);
        this.createMenu = new CreateMenu(f);
        this.updateMenu = new UpdateMenu(f);
        this.deleteMenu = new DeleteMenu(f);
    }


    public void addFrame(String windowName, int sizeX, int sizeY) {

        this.f = new JFrame(windowName);
        f.setSize(sizeX, sizeY);

        this.create = addButton("Create", 10, 10, 100, 40);
        this.read = addButton("Read", 10, 60, 100, 40);
        this.update = addButton("Update", 10, 110, 100, 40);
        this.delete = addButton("Delete", 10, 160, 100, 40);

        this.quit = addButton("Quit", 10, 410, 100, 40);

        f.setLayout(null);
        f.setVisible(true);
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

            createMenu.setVisibility(true);
            this.setVisibility(false);
        }
        if (e.getSource() == read){

            readMenu.setVisibility(true);
            this.setVisibility(false);
        }
        if (e.getSource() == update){

            updateMenu.setVisibility(true);
            this.setVisibility(false);
        }
        if (e.getSource() == delete){

            deleteMenu.setVisibility(true);
            this.setVisibility(false);
        }


    }

    public void setVisibility(Boolean visibility){

        f.setVisible(visibility);
    }

}
