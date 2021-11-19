package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Others extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOutputsLabel = new JLabel("Choose other channels:");
    private JLabel roomLabel = new JLabel("Room");
    private JLabel dJLabel = new JLabel("Stereo DJ");
    private JLabel screenLabel = new JLabel("Screen");
    private JLabel extraLabel = new JLabel("Extra");

    private JComboBox<String> roomNumber = new JComboBox();
    private JComboBox<String> dJNumber = new JComboBox();
    private JComboBox<String> screenNumber = new JComboBox();
    private JComboBox<String> extraNumber = new JComboBox();
    private JLabel otherCannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }



    public Others() throws HeadlessException {
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/mixer.jpg"));
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
        Container labelContainer = new Container();
        labelContainer.setLayout(new GridLayout(6, 1, 10, 10));
        labelContainer.setBounds(300, 120, 100, 200);
        Container numContainer = new Container();
        numContainer.setLayout(new GridLayout(6, 1, 10, 10));
        numContainer.setBounds(400, 120, 40, 200);
        chooseOutputsLabel.setFont(font);
        chooseOutputsLabel.setForeground(Color.orange);
        chooseOutputsLabel.setBounds(245, 5, 300, 50);
        container.add(chooseOutputsLabel);
        dJLabel.setForeground(Color.orange);
        dJLabel.setOpaque(true);
        dJLabel.setBackground(Color.BLUE);

        roomLabel.setForeground(Color.orange);
        roomLabel.setOpaque(true);
        roomLabel.setBackground(Color.BLUE);
        screenLabel.setOpaque(true);
        screenLabel.setBackground(Color.BLUE);
        screenLabel.setForeground(Color.orange);
        extraLabel.setForeground(Color.orange);
        extraLabel.setOpaque(true);
        extraLabel.setBackground(Color.BLUE);
        labelContainer.add(dJLabel);
        labelContainer.add(screenLabel);
        labelContainer.add(extraLabel);
        labelContainer.add(roomLabel);

        roomNumber.addItem("0");
        roomNumber.addItem("1");
        roomNumber.addItem("2");
        roomNumber.addItem("3");
        roomNumber.addItem("4");
        roomNumber.addItem("5");
        roomNumber.addItem("6");
        roomNumber.addItem("7");
        roomNumber.addItem("8");
        roomNumber.addItem("9");
        roomNumber.addItem("10");
        roomNumber.addItemListener(this);
        if (SystemLogic.otherStrips.contains("Room")){
            roomNumber.setSelectedItem("1");
        }else if (!SystemLogic.otherStrips.contains("Roo3") && SystemLogic.otherStrips.contains("Roo2")){
            roomNumber.setSelectedItem("2");
        }else if (!SystemLogic.otherStrips.contains("Roo4") && SystemLogic.otherStrips.contains("Roo3")){
            roomNumber.setSelectedItem("3");
        }else if (!SystemLogic.otherStrips.contains("Roo5") && SystemLogic.otherStrips.contains("Roo4")){
            roomNumber.setSelectedItem("4");
        }else if (!SystemLogic.otherStrips.contains("Roo6") && SystemLogic.otherStrips.contains("Roo5")){
            roomNumber.setSelectedItem("5");
        }else if (!SystemLogic.otherStrips.contains("Roo7") && SystemLogic.otherStrips.contains("Roo6")){
            roomNumber.setSelectedItem("6");
        }else if (!SystemLogic.otherStrips.contains("Roo8") && SystemLogic.otherStrips.contains("Roo7")){
            roomNumber.setSelectedItem("7");
        }else if (!SystemLogic.otherStrips.contains("Roo9") && SystemLogic.otherStrips.contains("Roo8")){
            roomNumber.setSelectedItem("8");
        }else if (!SystemLogic.otherStrips.contains("Roo10") && SystemLogic.otherStrips.contains("Roo9")){
            roomNumber.setSelectedItem("9");
        }else if (SystemLogic.otherStrips.contains("Roo10")){
            roomNumber.setSelectedItem("10");
        }
        dJNumber.addItem("0");
        dJNumber.addItem("1");
        dJNumber.addItem("2");
        dJNumber.addItem("3");
        dJNumber.addItem("4");
        dJNumber.addItem("5");
        dJNumber.addItem("6");
        dJNumber.addItemListener(this);
        if (SystemLogic.otherStrips.contains("DJ L")){
            dJNumber.setSelectedItem("1");
        }else if (!SystemLogic.otherStrips.contains("DJ3L") && SystemLogic.otherStrips.contains("DJ2L")){
            dJNumber.setSelectedItem("2");
        }else if (!SystemLogic.otherStrips.contains("DJ4L") && SystemLogic.otherStrips.contains("DJ3L")){
            dJNumber.setSelectedItem("3");
        }else if (!SystemLogic.otherStrips.contains("DJ5L") && SystemLogic.otherStrips.contains("DJ4L")){
            dJNumber.setSelectedItem("4");
        }else if (!SystemLogic.otherStrips.contains("DJ6L") && SystemLogic.otherStrips.contains("DJ5L")){
            dJNumber.setSelectedItem("5");
        }else if (SystemLogic.otherStrips.contains("DJ6L")){
            dJNumber.setSelectedItem("6");
        }
        screenNumber.addItem("0");
        screenNumber.addItem("1");
        screenNumber.addItem("2");
        screenNumber.addItem("3");
        screenNumber.addItem("4");
        screenNumber.addItem("5");
        screenNumber.addItem("6");
        screenNumber.addItemListener(this);
        if (SystemLogic.otherStrips.contains("ScrL")){
            screenNumber.setSelectedItem("1");
        }else if (!SystemLogic.otherStrips.contains("Sc3L") && SystemLogic.otherStrips.contains("Sc2L")){
            screenNumber.setSelectedItem("2");
        }else if (!SystemLogic.otherStrips.contains("Sc4L") && SystemLogic.otherStrips.contains("Sc3L")){
            screenNumber.setSelectedItem("3");
        }else if (!SystemLogic.otherStrips.contains("Sc5L") && SystemLogic.otherStrips.contains("Sc4L")){
            screenNumber.setSelectedItem("4");
        }else if (!SystemLogic.otherStrips.contains("Sc6L") && SystemLogic.otherStrips.contains("Sc5L")){
            screenNumber.setSelectedItem("5");
        }else if (SystemLogic.otherStrips.contains("Sc6L")){
            screenNumber.setSelectedItem("6");
        }
        extraNumber.addItem("0");
        extraNumber.addItem("1");
        extraNumber.addItem("2");
        extraNumber.addItem("3");
        extraNumber.addItem("4");
        extraNumber.addItem("5");
        extraNumber.addItem("6");
        extraNumber.addItem("7");
        extraNumber.addItem("8");
        extraNumber.addItem("9");
        extraNumber.addItem("10");
        extraNumber.addItemListener(this);
        if (SystemLogic.otherStrips.contains("Extr")){
            extraNumber.setSelectedItem("1");
        }else if (!SystemLogic.otherStrips.contains("Ext3") && SystemLogic.otherStrips.contains("Ext2")){
            extraNumber.setSelectedItem("2");
        }else if (!SystemLogic.otherStrips.contains("Ext4") && SystemLogic.otherStrips.contains("Ext3")){
            extraNumber.setSelectedItem("3");
        }else if (!SystemLogic.otherStrips.contains("Ext5") && SystemLogic.otherStrips.contains("Ext4")){
            extraNumber.setSelectedItem("4");
        }else if (!SystemLogic.otherStrips.contains("Ext6") && SystemLogic.otherStrips.contains("Ext5")){
            extraNumber.setSelectedItem("5");
        }else if (!SystemLogic.otherStrips.contains("Ext7") && SystemLogic.otherStrips.contains("Ext6")){
            extraNumber.setSelectedItem("6");
        }else if (!SystemLogic.otherStrips.contains("Ext8") && SystemLogic.otherStrips.contains("Ext7")){
            extraNumber.setSelectedItem("7");
        }else if (!SystemLogic.otherStrips.contains("Ext9") && SystemLogic.otherStrips.contains("Ext8")){
            extraNumber.setSelectedItem("8");
        }else if (!SystemLogic.otherStrips.contains("Ext10") && SystemLogic.otherStrips.contains("Ext9")){
            extraNumber.setSelectedItem("9");
        }else if (SystemLogic.otherStrips.contains("Ext10")){
            roomNumber.setSelectedItem("10");
        }
        numContainer.add(dJNumber);
        numContainer.add(screenNumber);
        numContainer.add(extraNumber);
        numContainer.add(roomNumber);

        otherCannels.setBounds(650, 20, 150, 25);//label
        otherCannels.setForeground(Color.green);
        container.add(otherCannels);
        container.add(labelContainer);
        container.add(numContainer);

//elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 30);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemLogic.otherStrips.clear();

                String djSel = dJNumber.getSelectedItem().toString();
                switch (djSel) {
                    case "1":
                        SystemLogic.otherStrips.add("DJ L");
                        SystemLogic.otherStrips.add("DJ R");
                        break;
                    case "2":
                        SystemLogic.otherStrips.add("DJ1L");
                        SystemLogic.otherStrips.add("DJ1R");
                        SystemLogic.otherStrips.add("DJ2L");
                        SystemLogic.otherStrips.add("DJ2R");
                        break;
                    case "3":
                        SystemLogic.otherStrips.add("DJ1L");
                        SystemLogic.otherStrips.add("DJ1R");
                        SystemLogic.otherStrips.add("DJ2L");
                        SystemLogic.otherStrips.add("DJ2R");
                        SystemLogic.otherStrips.add("DJ3L");
                        SystemLogic.otherStrips.add("DJ3R");
                        break;
                    case "4":
                        SystemLogic.otherStrips.add("DJ1L");
                        SystemLogic.otherStrips.add("DJ1R");
                        SystemLogic.otherStrips.add("DJ2L");
                        SystemLogic.otherStrips.add("DJ2R");
                        SystemLogic.otherStrips.add("DJ3L");
                        SystemLogic.otherStrips.add("DJ3R");
                        SystemLogic.otherStrips.add("DJ4L");
                        SystemLogic.otherStrips.add("DJ4R");
                        break;
                    case "5":
                        SystemLogic.otherStrips.add("DJ1L");
                        SystemLogic.otherStrips.add("DJ1R");
                        SystemLogic.otherStrips.add("DJ2L");
                        SystemLogic.otherStrips.add("DJ2R");
                        SystemLogic.otherStrips.add("DJ3L");
                        SystemLogic.otherStrips.add("DJ3R");
                        SystemLogic.otherStrips.add("DJ4L");
                        SystemLogic.otherStrips.add("DJ4R");
                        SystemLogic.otherStrips.add("DJ5L");
                        SystemLogic.otherStrips.add("DJ5R");
                        break;
                    case "6":
                        SystemLogic.otherStrips.add("DJ1L");
                        SystemLogic.otherStrips.add("DJ1R");
                        SystemLogic.otherStrips.add("DJ2L");
                        SystemLogic.otherStrips.add("DJ2R");
                        SystemLogic.otherStrips.add("DJ3L");
                        SystemLogic.otherStrips.add("DJ3R");
                        SystemLogic.otherStrips.add("DJ4L");
                        SystemLogic.otherStrips.add("DJ4R");
                        SystemLogic.otherStrips.add("DJ5L");
                        SystemLogic.otherStrips.add("DJ5R");
                        SystemLogic.otherStrips.add("DJ6L");
                        SystemLogic.otherStrips.add("DJ6R");
                        break;

                }
                String scrSel = dJNumber.getSelectedItem().toString();
                switch (scrSel) {
                    case "1":
                        SystemLogic.otherStrips.add("ScrL");
                        SystemLogic.otherStrips.add("ScrR");
                        break;
                    case "2":
                        SystemLogic.otherStrips.add("Sc1L");
                        SystemLogic.otherStrips.add("Sc1R");
                        SystemLogic.otherStrips.add("Sc2L");
                        SystemLogic.otherStrips.add("Sc2R");
                        break;
                    case "3":
                        SystemLogic.otherStrips.add("Sc1L");
                        SystemLogic.otherStrips.add("Sc1R");
                        SystemLogic.otherStrips.add("Sc2L");
                        SystemLogic.otherStrips.add("Sc2R");
                        SystemLogic.otherStrips.add("Sc3L");
                        SystemLogic.otherStrips.add("Sc3R");
                        break;
                    case "4":
                        SystemLogic.otherStrips.add("Sc1L");
                        SystemLogic.otherStrips.add("Sc1R");
                        SystemLogic.otherStrips.add("Sc2L");
                        SystemLogic.otherStrips.add("Sc2R");
                        SystemLogic.otherStrips.add("Sc3L");
                        SystemLogic.otherStrips.add("Sc3R");
                        SystemLogic.otherStrips.add("Sc4L");
                        SystemLogic.otherStrips.add("Sc4R");
                        break;
                    case "5":
                        SystemLogic.otherStrips.add("Sc1L");
                        SystemLogic.otherStrips.add("Sc1R");
                        SystemLogic.otherStrips.add("Sc2L");
                        SystemLogic.otherStrips.add("Sc2R");
                        SystemLogic.otherStrips.add("Sc3L");
                        SystemLogic.otherStrips.add("Sc3R");
                        SystemLogic.otherStrips.add("Sc4L");
                        SystemLogic.otherStrips.add("Sc4R");
                        SystemLogic.otherStrips.add("Sc5L");
                        SystemLogic.otherStrips.add("Sc5R");
                        break;
                    case "6":
                        SystemLogic.otherStrips.add("Sc1L");
                        SystemLogic.otherStrips.add("Sc1R");
                        SystemLogic.otherStrips.add("Sc2L");
                        SystemLogic.otherStrips.add("Sc2R");
                        SystemLogic.otherStrips.add("Sc3L");
                        SystemLogic.otherStrips.add("Sc3R");
                        SystemLogic.otherStrips.add("Sc4L");
                        SystemLogic.otherStrips.add("Sc4R");
                        SystemLogic.otherStrips.add("Sc5L");
                        SystemLogic.otherStrips.add("Sc5R");
                        SystemLogic.otherStrips.add("Sc6L");
                        SystemLogic.otherStrips.add("Sc6R");
                        break;
                }
                String extSel = extraNumber.getSelectedItem().toString();
                switch (extSel) {
                    case "1":
                        SystemLogic.otherStrips.add("Extr");
                        break;
                    case "2":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        break;
                    case "3":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        break;
                    case "4":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        break;
                    case "5":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        break;
                    case "6":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        SystemLogic.otherStrips.add("Ext6");
                        break;
                    case "7":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        SystemLogic.otherStrips.add("Ext6");
                        SystemLogic.otherStrips.add("Ext7");
                        break;
                    case "8":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        SystemLogic.otherStrips.add("Ext6");
                        SystemLogic.otherStrips.add("Ext7");
                        SystemLogic.otherStrips.add("Ext8");
                        break;
                    case "9":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        SystemLogic.otherStrips.add("Ext6");
                        SystemLogic.otherStrips.add("Ext7");
                        SystemLogic.otherStrips.add("Ext8");
                        SystemLogic.otherStrips.add("Ext9");
                        break;
                    case "10":
                        SystemLogic.otherStrips.add("Ext1");
                        SystemLogic.otherStrips.add("Ext2");
                        SystemLogic.otherStrips.add("Ext3");
                        SystemLogic.otherStrips.add("Ext4");
                        SystemLogic.otherStrips.add("Ext5");
                        SystemLogic.otherStrips.add("Ext6");
                        SystemLogic.otherStrips.add("Ext7");
                        SystemLogic.otherStrips.add("Ext8");
                        SystemLogic.otherStrips.add("Ext9");
                        SystemLogic.otherStrips.add("Ext10");
                        break;
                }
                String roomSel = roomNumber.getSelectedItem().toString();
                switch (roomSel) {
                    case "1":
                        SystemLogic.otherStrips.add("Room");
                        break;
                    case "2":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        break;
                    case "3":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        break;
                    case "4":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        break;
                    case "5":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        break;
                    case "6":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        SystemLogic.otherStrips.add("Roo6");
                        break;
                    case "7":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        SystemLogic.otherStrips.add("Roo6");
                        SystemLogic.otherStrips.add("Roo7");
                        break;
                    case "8":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        SystemLogic.otherStrips.add("Roo6");
                        SystemLogic.otherStrips.add("Roo7");
                        SystemLogic.otherStrips.add("Roo8");
                        break;
                    case "9":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        SystemLogic.otherStrips.add("Roo6");
                        SystemLogic.otherStrips.add("Roo7");
                        SystemLogic.otherStrips.add("Roo8");
                        SystemLogic.otherStrips.add("Roo9");
                        break;
                    case "10":
                        SystemLogic.otherStrips.add("Roo1");
                        SystemLogic.otherStrips.add("Roo2");
                        SystemLogic.otherStrips.add("Roo3");
                        SystemLogic.otherStrips.add("Roo4");
                        SystemLogic.otherStrips.add("Roo5");
                        SystemLogic.otherStrips.add("Roo6");
                        SystemLogic.otherStrips.add("Roo7");
                        SystemLogic.otherStrips.add("Roo8");
                        SystemLogic.otherStrips.add("Roo9");
                        SystemLogic.otherStrips.add("Roo10");
                        break;
                }
                buttonNext.setEnabled(true);
                otherCannels.setText("Other Channels: " + (SystemLogic.otherStrips.size()));
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
                DefineInstruments.buttonOthers.setText("Others:" + SystemLogic.otherStrips.size());
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
                    Others percussion = new Others();
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

