package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Vocals extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOutputsLabel = new JLabel("Choose among vocals:");
    private JLabel leadVocLabel = new JLabel("Lead vocal");
    private JLabel backVocLabel = new JLabel("Back vocal");

    private JComboBox<String> leadVocNumber = new JComboBox();
    private JComboBox<String> backVocNumber = new JComboBox();
    private JLabel leadCannels = new JLabel("");
    private JLabel backCannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }



    public Vocals() throws HeadlessException {
        super("Sound Engineer  " + SystemLogic.sceneName);
        Font font = new Font("",Font.BOLD,20);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setResizable(false);

        m1.add(new JMenuItem("Open", 'O'));
        m1.add(new JMenuItem("Save", 'S'));
        m1.add(new JMenuItem("Recent"));
        m1.addSeparator();
        JMenuItem exit =  m1.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));

        m2.add(new JMenuItem("About"));
        jMenuBar.add(m1);
        jMenuBar.add(m2);
        jMenuBar.setBackground(Color.green);
        this.setJMenuBar(jMenuBar);
        this.revalidate();

//background image start
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/vocs.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end

//elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        chooseOutputsLabel.setFont(font);
        chooseOutputsLabel.setForeground(Color.orange);
        chooseOutputsLabel.setBounds(245, 5, 300, 50);
        container.add(chooseOutputsLabel);
        backVocLabel.setFont(font);
        backVocLabel.setBounds(185, 55, 200, 50);
        backVocLabel.setForeground(Color.orange);
        container.add(backVocLabel);
        leadVocLabel.setFont(font);
        leadVocLabel.setForeground(Color.orange);
        leadVocLabel.setBounds(505, 55, 200, 50);
        container.add(leadVocLabel);

        leadVocNumber.addItem("0");
        leadVocNumber.addItem("1");
        leadVocNumber.addItem("2");
        leadVocNumber.addItem("3");
        leadVocNumber.addItem("4");
        leadVocNumber.addItem("5");
        leadVocNumber.addItem("6");
        leadVocNumber.addItem("7");
        leadVocNumber.addItem("8");
        leadVocNumber.addItem("9");
        leadVocNumber.addItem("10");
        leadVocNumber.addItemListener(this);
        if (SystemLogic.leadVocStrips.contains("MV")){
            leadVocNumber.setSelectedItem("1");
        }else if (!SystemLogic.leadVocStrips.contains("MV3") && SystemLogic.leadVocStrips.contains("MV2")){
            leadVocNumber.setSelectedItem("2");
        }else if (!SystemLogic.leadVocStrips.contains("MV4") && SystemLogic.leadVocStrips.contains("MV3")){
            leadVocNumber.setSelectedItem("3");
        }else if (!SystemLogic.leadVocStrips.contains("MV5") && SystemLogic.leadVocStrips.contains("MV4")){
            leadVocNumber.setSelectedItem("4");
        }else if (!SystemLogic.leadVocStrips.contains("MV6") && SystemLogic.leadVocStrips.contains("MV5")){
            leadVocNumber.setSelectedItem("5");
        }else if (!SystemLogic.leadVocStrips.contains("MV7") && SystemLogic.leadVocStrips.contains("MV6")){
            leadVocNumber.setSelectedItem("6");
        }else if (!SystemLogic.leadVocStrips.contains("MV8") && SystemLogic.leadVocStrips.contains("MV7")){
            leadVocNumber.setSelectedItem("7");
        }else if (!SystemLogic.leadVocStrips.contains("MV9") && SystemLogic.leadVocStrips.contains("MV8")){
            leadVocNumber.setSelectedItem("8");
        }else if (!SystemLogic.leadVocStrips.contains("MV10") && SystemLogic.leadVocStrips.contains("MV9")){
            leadVocNumber.setSelectedItem("9");
        }else if (SystemLogic.leadVocStrips.contains("MV10")){
            leadVocNumber.setSelectedItem("10");
        }
        leadVocNumber.setBounds(535, 100, 40, 20);
        container.add(leadVocNumber);
        backVocNumber.addItem("0");
        backVocNumber.addItem("1");
        backVocNumber.addItem("2");
        backVocNumber.addItem("3");
        backVocNumber.addItem("4");
        backVocNumber.addItem("5");
        backVocNumber.addItem("6");
        backVocNumber.addItem("7");
        backVocNumber.addItem("8");
        backVocNumber.addItem("9");
        backVocNumber.addItem("10");
        if (SystemLogic.backVocStrips.contains("BV")){
            backVocNumber.setSelectedItem("1");
        }else if (!SystemLogic.backVocStrips.contains("BV3") && SystemLogic.backVocStrips.contains("BV2")){
            backVocNumber.setSelectedItem("2");
        }else if (!SystemLogic.backVocStrips.contains("BV4") && SystemLogic.backVocStrips.contains("BV3")){
            backVocNumber.setSelectedItem("3");
        }else if (!SystemLogic.backVocStrips.contains("BV5") && SystemLogic.backVocStrips.contains("BV4")){
            backVocNumber.setSelectedItem("4");
        }else if (!SystemLogic.backVocStrips.contains("BV6") && SystemLogic.backVocStrips.contains("BV5")){
            backVocNumber.setSelectedItem("5");
        }else if (!SystemLogic.backVocStrips.contains("BV7") && SystemLogic.backVocStrips.contains("BV6")){
            backVocNumber.setSelectedItem("6");
        }else if (!SystemLogic.backVocStrips.contains("BV8") && SystemLogic.backVocStrips.contains("BV7")){
            backVocNumber.setSelectedItem("7");
        }else if (!SystemLogic.backVocStrips.contains("BV9") && SystemLogic.backVocStrips.contains("BV8")){
            backVocNumber.setSelectedItem("8");
        }else if (!SystemLogic.backVocStrips.contains("BV10") && SystemLogic.backVocStrips.contains("BV9")){
            backVocNumber.setSelectedItem("9");
        }else if (SystemLogic.backVocStrips.contains("BV10")){
            backVocNumber.setSelectedItem("10");
        }
        backVocNumber.setBounds(215, 100, 40, 20);
        container.add(backVocNumber);
        leadCannels.setBounds(650, 5, 150, 25);//label1
        backCannels.setBounds(650, 20, 150, 25);//label2
        leadCannels.setForeground(Color.green);
        backCannels.setForeground(Color.green);
        container.add(leadCannels);
        container.add(backCannels);


//elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 30);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemLogic.leadVocStrips.clear();
                SystemLogic.backVocStrips.clear();

                String lVocSel = leadVocNumber.getSelectedItem().toString();
                switch (lVocSel) {
                    case "1":
                        SystemLogic.leadVocStrips.add("MV");
                        break;
                    case "2":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        break;
                    case "3":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        break;
                    case "4":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        break;
                    case "5":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        break;
                    case "6":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        SystemLogic.leadVocStrips.add("MV6");
                        break;
                    case "7":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        SystemLogic.leadVocStrips.add("MV6");
                        SystemLogic.leadVocStrips.add("MV7");
                        break;
                    case "8":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        SystemLogic.leadVocStrips.add("MV6");
                        SystemLogic.leadVocStrips.add("MV7");
                        SystemLogic.leadVocStrips.add("MV8");
                        break;
                    case "9":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        SystemLogic.leadVocStrips.add("MV6");
                        SystemLogic.leadVocStrips.add("MV7");
                        SystemLogic.leadVocStrips.add("MV8");
                        SystemLogic.leadVocStrips.add("MV9");
                        break;
                    case "10":
                        SystemLogic.leadVocStrips.add("MV1");
                        SystemLogic.leadVocStrips.add("MV2");
                        SystemLogic.leadVocStrips.add("MV3");
                        SystemLogic.leadVocStrips.add("MV4");
                        SystemLogic.leadVocStrips.add("MV5");
                        SystemLogic.leadVocStrips.add("MV6");
                        SystemLogic.leadVocStrips.add("MV7");
                        SystemLogic.leadVocStrips.add("MV8");
                        SystemLogic.leadVocStrips.add("MV9");
                        SystemLogic.leadVocStrips.add("MV10");
                        break;
                }
                String bVocSel = backVocNumber.getSelectedItem().toString();
                switch (bVocSel) {
                    case "1":
                        SystemLogic.backVocStrips.add("BV");
                        break;
                    case "2":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        break;
                    case "3":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        break;
                    case "4":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        break;
                    case "5":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        break;
                    case "6":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        SystemLogic.backVocStrips.add("BV6");
                        break;
                    case "7":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        SystemLogic.backVocStrips.add("BV6");
                        SystemLogic.backVocStrips.add("BV7");
                        break;
                    case "8":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        SystemLogic.backVocStrips.add("BV6");
                        SystemLogic.backVocStrips.add("BV7");
                        SystemLogic.backVocStrips.add("BV8");
                        break;
                    case "9":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        SystemLogic.backVocStrips.add("BV6");
                        SystemLogic.backVocStrips.add("BV7");
                        SystemLogic.backVocStrips.add("BV8");
                        SystemLogic.backVocStrips.add("BV9");
                        break;
                    case "10":
                        SystemLogic.backVocStrips.add("BV1");
                        SystemLogic.backVocStrips.add("BV2");
                        SystemLogic.backVocStrips.add("BV3");
                        SystemLogic.backVocStrips.add("BV4");
                        SystemLogic.backVocStrips.add("BV5");
                        SystemLogic.backVocStrips.add("BV6");
                        SystemLogic.backVocStrips.add("BV7");
                        SystemLogic.backVocStrips.add("BV8");
                        SystemLogic.backVocStrips.add("BV9");
                        SystemLogic.backVocStrips.add("BV10");
                        break;
                }
                buttonNext.setEnabled(true);
                leadCannels.setText("Lead Channels: " + (SystemLogic.leadVocStrips.size()));
                backCannels.setText("Back Channels: " + (SystemLogic.backVocStrips.size()));
            }
        });
//Button apply end


//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminateThisWindow();

            }
        });
//Button back end

//Button next start
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefineInstruments.buttonVocals.setText("Vocals:" + (SystemLogic.leadVocStrips.size() + SystemLogic.backVocStrips.size()));
                DefineInstruments.numChannels.setText("All Channels:" + SystemLogic.CommonChannels());
                terminateThisWindow();
            }

        });
//Button next end



        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you really want to quit?", "Confirm", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }else if (option == JOptionPane.NO_OPTION){
                    Vocals percussion = new Vocals();
                    percussion.setVisible(true);
                }
            }
        });
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }

}

