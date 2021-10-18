package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Guitars extends JFrame implements ItemListener {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonApply = new JButton("Apply");
    private JButton buttonNext = new JButton("Next");
    private JLabel defineGuitarsLabel = new JLabel("Define Guitar channels quantity:");
    private JLabel bassGuitarLabel = new JLabel("Bass Guitar:");
    private JLabel elGuitarLabel = new JLabel("Electro Guitar:");
    private JLabel accGuitarsLabel = new JLabel("Accoustic Guitar:");
    private JLabel guitarChannels = new JLabel("");

    private JComboBox<String> bassNumber = new JComboBox();
    private JComboBox<String> elGtrNumber = new JComboBox();
    private JComboBox<String> acGtrNumber = new JComboBox();

    public void terminateThisWindow() {
        this.dispose();
    }

    public Guitars() throws HeadlessException {
        super("Sound Engineer");
        Font font = new Font("", Font.BOLD, 18);
        Font font1 = new Font("", Font.BOLD, 15);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 854, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        m1.add(new JMenuItem("Open", 'O'));
        m1.add(new JMenuItem("Save", 'S'));
        m1.add(new JMenuItem("Recent"));
        m1.addSeparator();
        JMenuItem exit = m1.add(new JMenuItem("Exit"));
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/guitars.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end

//Elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        defineGuitarsLabel.setFont(font);
        defineGuitarsLabel.setBounds(10, 1, 300, 30);
        container.add(defineGuitarsLabel);
        bassGuitarLabel.setFont(font1);
        bassGuitarLabel.setBounds(100,100,100,20);
        container.add(bassGuitarLabel);
        elGuitarLabel.setFont(font1);
        elGuitarLabel.setBounds(350,100,150,20);
        container.add(elGuitarLabel);
        accGuitarsLabel.setFont(font1);
        accGuitarsLabel.setBounds(600,100,150,20);
        container.add(accGuitarsLabel);
        bassNumber.addItemListener(this);
        bassNumber.addItem("Mono");
        bassNumber.addItem("Stereo");
        bassNumber.addItem("No One");
        bassNumber.setBounds(100, 130, 100, 20);
        container.add(bassNumber);
        elGtrNumber.addItemListener(this);
        elGtrNumber.addItem("1 Mono");
        elGtrNumber.addItem("2 Mono");
        elGtrNumber.addItem("1 Stereo");
        elGtrNumber.addItem("2 Stereo");
        elGtrNumber.addItem("1mono,1stereo");
        elGtrNumber.addItem("1mono,2stereo");
        elGtrNumber.addItem("2mono,1stereo");
        elGtrNumber.addItem("No One");
        elGtrNumber.setBounds(350, 130, 120, 20);
        container.add(elGtrNumber);
        acGtrNumber.addItemListener(this);
        acGtrNumber.addItem("1 Mono");
        acGtrNumber.addItem("2 Mono");
        acGtrNumber.addItem("1 Stereo");
        acGtrNumber.addItem("2 Stereo");
        acGtrNumber.addItem("1mono,1stereo");
        acGtrNumber.addItem("1mono,2stereo");
        acGtrNumber.addItem("2mono,1stereo");
        acGtrNumber.addItem("No One");
        acGtrNumber.setBounds(600, 130, 120, 20);
        container.add(acGtrNumber);

        guitarChannels.setBounds(650, 5, 150, 25);//label
        container.add(guitarChannels);



//Elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 60);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemLogic.guitarStrips.clear();
            if (bassNumber.getSelectedItem() == "Mono"){
                SystemLogic.guitarStrips.add(0,"Bass");
            }else if (bassNumber.getSelectedItem() == "Stereo"){
                SystemLogic.guitarStrips.add(0,"BasL");
                SystemLogic.guitarStrips.add(1,"BasR");
            }
            String eGtSel = elGtrNumber.getSelectedItem().toString();
            switch (eGtSel){
                case "1 Mono":
                    SystemLogic.guitarStrips.add("EGtr");
                    break;
                case "2 Mono":
                    SystemLogic.guitarStrips.add("EGt1");
                    SystemLogic.guitarStrips.add("EGt2");
                    break;
                case "1 Stereo":
                    SystemLogic.guitarStrips.add("EGtL");
                    SystemLogic.guitarStrips.add("EGtR");
                    break;
                case "2 Stereo":
                    SystemLogic.guitarStrips.add("EG1L");
                    SystemLogic.guitarStrips.add("EG1R");
                    SystemLogic.guitarStrips.add("EG2L");
                    SystemLogic.guitarStrips.add("EG2R");
                    break;
                case "1mono,1stereo":
                    if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                        SystemLogic.guitarStrips.add("EGt1");
                        SystemLogic.guitarStrips.add("EG2L");
                        SystemLogic.guitarStrips.add("EG2R");
                    }else {
                        SystemLogic.guitarStrips.add("EG1L");
                        SystemLogic.guitarStrips.add("EG1R");
                        SystemLogic.guitarStrips.add("EGt2");
                    }
                    break;
                case "1mono,2stereo":
                    if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                        SystemLogic.guitarStrips.add("EGt1");
                        SystemLogic.guitarStrips.add("EG2L");
                        SystemLogic.guitarStrips.add("EG2R");
                        SystemLogic.guitarStrips.add("EG3L");
                        SystemLogic.guitarStrips.add("EG3R");
                    }else {
                        SystemLogic.guitarStrips.add("EG1L");
                        SystemLogic.guitarStrips.add("EG1R");
                        SystemLogic.guitarStrips.add("EG2L");
                        SystemLogic.guitarStrips.add("EG2R");
                        SystemLogic.guitarStrips.add("EGt3");
                    }
                    break;
                case "2mono,1stereo":
                    if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                        SystemLogic.guitarStrips.add("EGt1");
                        SystemLogic.guitarStrips.add("EG2L");
                        SystemLogic.guitarStrips.add("EG2R");
                        SystemLogic.guitarStrips.add("EGt3");
                    }else {
                        SystemLogic.guitarStrips.add("EG1L");
                        SystemLogic.guitarStrips.add("EG1R");
                        SystemLogic.guitarStrips.add("EGt2");
                        SystemLogic.guitarStrips.add("EGt3");
                    }
                    break;
            }
                String aGtSel = acGtrNumber.getSelectedItem().toString();
                switch (aGtSel){
                    case "1 Mono":
                        SystemLogic.guitarStrips.add("AGtr");
                        break;
                    case "2 Mono":
                        SystemLogic.guitarStrips.add("AGt1");
                        SystemLogic.guitarStrips.add("AGt2");
                        break;
                    case "1 Stereo":
                        SystemLogic.guitarStrips.add("AGtL");
                        SystemLogic.guitarStrips.add("AGtR");
                        break;
                    case "2 Stereo":
                        SystemLogic.guitarStrips.add("AG1L");
                        SystemLogic.guitarStrips.add("AG1R");
                        SystemLogic.guitarStrips.add("AG2L");
                        SystemLogic.guitarStrips.add("AG2R");
                        break;
                    case "1mono,1stereo":
                        if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                            SystemLogic.guitarStrips.add("AGt1");
                            SystemLogic.guitarStrips.add("AG2L");
                            SystemLogic.guitarStrips.add("AG2R");
                        }else {
                            SystemLogic.guitarStrips.add("AG1L");
                            SystemLogic.guitarStrips.add("AG1R");
                            SystemLogic.guitarStrips.add("AGt2");
                        }
                        break;
                    case "1mono,2stereo":
                        if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                            SystemLogic.guitarStrips.add("AGt1");
                            SystemLogic.guitarStrips.add("AG2L");
                            SystemLogic.guitarStrips.add("AG2R");
                            SystemLogic.guitarStrips.add("AG3L");
                            SystemLogic.guitarStrips.add("AG3R");
                        }else {
                            SystemLogic.guitarStrips.add("AG1L");
                            SystemLogic.guitarStrips.add("AG1R");
                            SystemLogic.guitarStrips.add("AG2L");
                            SystemLogic.guitarStrips.add("AG2R");
                            SystemLogic.guitarStrips.add("AGt3");
                        }
                        break;
                    case "2mono,1stereo":
                        if ((SystemLogic.drumStrips.size() + SystemLogic.guitarStrips.size())%2 == 0){
                            SystemLogic.guitarStrips.add("AGt1");
                            SystemLogic.guitarStrips.add("AG2L");
                            SystemLogic.guitarStrips.add("AG2R");
                            SystemLogic.guitarStrips.add("AGt3");
                        }else {
                            SystemLogic.guitarStrips.add("AG1L");
                            SystemLogic.guitarStrips.add("AG1R");
                            SystemLogic.guitarStrips.add("AGt2");
                            SystemLogic.guitarStrips.add("AGt3");
                        }
                        break;
                }
                buttonNext.setEnabled(true);
                guitarChannels.setText("Guitar Channels: " + SystemLogic.guitarStrips.size());
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
        buttonNext.setEnabled(false);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefineInstruments.buttonGuitars.setText("Guitars:" + SystemLogic.guitarStrips.size());
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
                }
            }
        });
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }
}
