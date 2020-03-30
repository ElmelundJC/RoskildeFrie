package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

        private TextPanel textPanel;



            public MainFrame() {
                super("Velkommen Sandra Madsen");

                setLayout(new BorderLayout());

                /*formPanel = new FormPanel();
                add(formPanel, BorderLayout.WEST);*/

                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setSize(400, 300);
                setLocation(627, 200);
                setMinimumSize( new Dimension(300, 200));
                setVisible(true);




                setJMenuBar(createMenuBar());
            }

            public JMenuBar createMenuBar() {
                JMenuBar menuBar = new JMenuBar();

                JMenu fileMenu = new JMenu("Vælg fra menu");
                JMenuItem indskrivData = new JMenuItem("Indskrivning af barn...");
                JMenuItem redigerData = new JMenuItem("Redigering af data...");
                JMenuItem sletData = new JMenuItem("Sletning af data...");
                JMenuItem exitItem = new JMenuItem("Exit");

                fileMenu.add(indskrivData);
                fileMenu.add(redigerData);
                fileMenu.add(sletData);
                fileMenu.addSeparator();
                fileMenu.add(exitItem);

                fileMenu.setMnemonic(KeyEvent.VK_V);
                indskrivData.setMnemonic(KeyEvent.VK_I);
                redigerData.setMnemonic(KeyEvent.VK_R);
                sletData.setMnemonic(KeyEvent.VK_S);
                exitItem.setMnemonic(KeyEvent.VK_X);
                exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

                exitItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // confirmdialog box
                        int action = JOptionPane.showConfirmDialog(MainFrame.this, "Er du sikker på du er færdig?",
                                "Bekræft luk", JOptionPane.OK_CANCEL_OPTION);
                        // only exit if ok is clicked
                        if (action == JOptionPane.OK_OPTION) {
                            System.exit(0);
                        }
                    }
                });

                indskrivData.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource() == indskrivData) {
                            new FormPanel().setVisible(true);
                            System.out.println("Indskriv data");
                            MainFrame.this.dispose();
                        }
                    }
                });

                redigerData.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource() == redigerData) {

                            System.out.println("Rediger data");
                            MainFrame.this.dispose();
                        }
                    }
                });

                sletData.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource() == sletData) {
                            System.out.println("Slet data");
                            MainFrame.this.dispose();
                        }
                    }
                });


                menuBar.add(fileMenu);
                setVisible(true);



                return menuBar;
            }
    }
