package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consoles extends JFrame {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");

    private JButton buttonCancel = new JButton ("Cancel");
    private JButton buttonNext = new JButton("Next");
    private JRadioButton pm5d = new JRadioButton("PM5D");
    private JRadioButton cl = new JRadioButton("CL");
    private JRadioButton iLive = new JRadioButton("iLive");
    private JRadioButton pm5dCl = new JRadioButton("PM5D+CL");
    private JRadioButton pm5diLive = new JRadioButton("PM5D+iLive");
    private JRadioButton pm5dRivage = new JRadioButton("PM5D+Rivage");
    private JRadioButton clX2 = new JRadioButton("CL+CL");
    private JRadioButton x32 = new JRadioButton("X32");
    private JRadioButton rivage = new JRadioButton("Rivage");
    private JRadioButton rivageCL = new JRadioButton("Rivage+CL");
    private JRadioButton rivageiLive = new JRadioButton("Rivage+iLive");
    private JRadioButton digico = new JRadioButton("Digico");
    private JRadioButton digicoRivage = new JRadioButton("Digico+Rivage");
    private JRadioButton digicoCL = new JRadioButton("Digico+CL");
    private JRadioButton digicoiLive = new JRadioButton("Digico+iLive");
    private JLabel selCons = new JLabel("   Select Console");

    public Consoles() throws HeadlessException {
        super("Sound Engineer");
        this.setBounds(854, 480, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 2, 3, 3));
        jMenuBar.add(m1);
        jMenuBar.add(m2);

        Container menuArea = new Container();
        menuArea.setLayout(new GridLayout(1, 2, 3, 3));
        menuArea.add(jMenuBar);
        container.add(menuArea);

        //container.add(new GridLayout(1, 2, 3, 3));
       // container.add(jMenuBar);
        container.add(selCons);

        ButtonGroup group = new ButtonGroup();
        pm5d.setActionCommand("1");
        group.add(pm5d);
        cl.setActionCommand("2");
        group.add(cl);
        iLive.setActionCommand("3");
        group.add(iLive);
        rivage.setActionCommand("4");
        group.add(rivage);
        x32.setActionCommand("5");
        group.add(x32);
        digico.setActionCommand("6");
        group.add(digico);
        pm5dCl.setActionCommand("7");
        group.add(pm5dCl);
        pm5diLive.setActionCommand("8");
        group.add(pm5diLive);
        pm5dRivage.setActionCommand("8");
        group.add(pm5dRivage);
        clX2.setActionCommand("9");
        group.add(clX2);
        rivageCL.setActionCommand("10");
        group.add(rivageCL);
        digicoRivage.setActionCommand("11");
        group.add(digicoRivage);
        digicoiLive.setActionCommand("12");
        group.add(digicoiLive);
        digicoCL.setActionCommand("13");
        group.add(digicoCL);
        rivageiLive.setActionCommand("14");
        group.add(rivageiLive);

        container.add(pm5d);
        pm5d.setSelected(true);
        container.add(cl);
        container.add(iLive);
        container.add(rivage);
        container.add(x32);
        container.add(digico);
        container.add(pm5dCl);
        container.add(pm5diLive);
        container.add(pm5dRivage);
        container.add(clX2);
        container.add(rivageCL);
        container.add(digicoRivage);
        container.add(digicoiLive);
        container.add(digicoCL);
        container.add(rivageiLive);

        container.add(buttonCancel);
        container.add(buttonNext);
        //pack();

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String selectedConsole = group.getSelection().getActionCommand();
            switch (selectedConsole){
                case "1":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D) is not available yet");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (CL) is not available yet");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (iLive) is not available yet");
                    break;
                case "4":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage) is not available yet");
                    break;
                case "5":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (X32) is not available yet");
                    break;
                case "6":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico) is not available yet");
                    break;
                case "7":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D or CL) is not available yet");
                    break;
                case "8":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D or Rivage) is not available yet");
                    break;
                case "9":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (CL series) is not available yet");
                    break;
                case "10":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage or CL) is not available yet");
                    break;
                case "11":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or Rivage) is not available yet");
                    break;
                case "12":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or iLive) is not available yet");
                    break;
                case "13":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or CL) is not available yet");
                    break;
                case "14":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage or iLive) is not available yet");
                    break;
            }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


   }

}
