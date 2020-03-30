package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    FormPanel formPanel = null;

    private JLabel cpr_nummerLabel;
    private JLabel nameLabel;
    private JLabel adresseLabel;
    private JLabel stueLabel;

    private JTextField nameField;
    private JTextField cpr_nummerField;
    private JTextField adresseField;
    private JTextField stueField;

    public FormPanel() {


        //FormPanel formPanel = new FormPanel();

        Dimension dim = getPreferredSize();
        dim.width = 200;
        setPreferredSize(dim);

        //add(formPanel, BorderLayout.CENTER);
        setVisible(true);


        nameLabel = new JLabel("Navn: ");
        cpr_nummerLabel = new JLabel("Cpr nummer: ");
        adresseLabel = new JLabel("Adresse: ");
        stueLabel = new JLabel("Stue");

        nameField = new JTextField(20);
        cpr_nummerField = new JTextField(20);
        adresseField = new JTextField(20);
        stueField = new JTextField(5);

        Border innerBorder = BorderFactory.createTitledBorder("Tilføj information");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();




    }

    public void layoutComponents() {

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();


    }

    }


