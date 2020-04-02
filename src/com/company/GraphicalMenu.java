package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface GraphicalMenu extends ActionListener {

    public void addFrame(String windowName, int sizeX, int sizeY);

    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height, JFrame frame);

    public JButton addButton(String textField, int bPosX, int bPosY, int width, int height);

    public void setVisibility(Boolean visibility);


}
