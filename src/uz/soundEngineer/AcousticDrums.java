package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;

public class AcousticDrums extends JFrame implements ItemListener {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonApply = new JButton("Apply");
    private JButton buttonNext = new JButton("Next");
    private JLabel defineDrumsLabel = new JLabel("Define Drum channels quantity:");
    private JLabel overLabel = new JLabel("OverHead");
    private JLabel kicksLabel = new JLabel("Kicks:");
    private JLabel snaresLabel = new JLabel("Snares:");
    private JLabel hatLabel = new JLabel("Hat:");
    private JLabel rackTomsLabel = new JLabel("Rack Toms:");
    private JLabel floorTomsLabel = new JLabel("Floor Toms:");
    private JLabel snare2Label = new JLabel("Snare2:");
    private JLabel drumChannels = new JLabel("");

    private JComboBox<String> kicksNumber = new JComboBox();
    private JComboBox<String> snaresNumber = new JComboBox();
    private JComboBox<String> hatsNumber = new JComboBox();
    private JComboBox<String> rackTomsNumber = new JComboBox();
    private JComboBox<String> floorTomsNumber = new JComboBox();
    private JComboBox<String> overNumber = new JComboBox();
    private JComboBox<String> snare2Number = new JComboBox();

    public void terminateThisWindow() {
        this.dispose();
    }

    public AcousticDrums() throws HeadlessException {
        super("Sound Engineer");
        Font font = new Font("", Font.BOLD, 18);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 854, 480);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/acousticDrums.jpg"));
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
        defineDrumsLabel.setFont(font);
        defineDrumsLabel.setBounds(10, 1, 300, 30);
        container.add(defineDrumsLabel);


        kicksNumber.addItemListener(this);
        kicksNumber.addItem("1");
        kicksNumber.addItem("2");
        if (SystemLogic.drumStrips.contains("Kick")) {
            kicksNumber.setSelectedItem("1");
        } else kicksNumber.setSelectedItem("2");
        kicksLabel.setBounds(330, 240, 38, 20);
        kicksLabel.setBackground(Color.cyan);
        kicksLabel.setOpaque(true);
        container.add(kicksLabel);
        kicksNumber.setBounds(375, 240, 40, 20);
        container.add(kicksNumber);

        snaresNumber.addItemListener(this);
        snaresNumber.addItem("just top");
        snaresNumber.addItem("top+bottom");
        if (SystemLogic.drumStrips.contains("Sn1Bot")) {
            snaresNumber.setSelectedItem("top+bottom");
        } else snaresNumber.setSelectedItem("just top");
        snaresLabel.setOpaque(true);
        snaresLabel.setBackground(Color.cyan);
        snaresLabel.setBounds(395, 165, 48, 20);
        container.add(snaresLabel);
        snaresNumber.setBounds(445, 165, 90, 20);
        container.add(snaresNumber);

        snare2Number.addItemListener(this);
        snare2Number.addItem("no one");
        snare2Number.addItem("just top");
        snare2Number.addItem("top+bottom");
        if (SystemLogic.drumStrips.contains("Sn2Bot")) {
            snare2Number.setSelectedItem("top+bottom");
        } else if (SystemLogic.drumStrips.contains("Sn2")) {
            snare2Number.setSelectedItem("just top");
        } else snare2Number.setSelectedItem("no one");
        snare2Label.setOpaque(true);
        snare2Label.setBackground(Color.cyan);
        snare2Label.setBounds(645, 95, 48, 20);
        container.add(snare2Label);
        snare2Number.setBounds(625, 120, 90, 20);
        container.add(snare2Number);

        hatsNumber.addItemListener(this);
        hatsNumber.addItem("0");
        hatsNumber.addItem("1");
        if (SystemLogic.drumStrips.contains("Hat")) {
            hatsNumber.setSelectedItem("1");
        } else hatsNumber.setSelectedItem("0");
        hatLabel.setOpaque(true);
        hatLabel.setBackground(Color.cyan);
        hatLabel.setBounds(517, 90, 25, 20);
        container.add(hatLabel);
        hatsNumber.setBounds(545, 90, 40, 20);
        container.add(hatsNumber);

        rackTomsNumber.addItemListener(this);
        rackTomsNumber.addItem("0");
        rackTomsNumber.addItem("1");
        rackTomsNumber.addItem("2");
        rackTomsNumber.addItem("3");
        rackTomsNumber.addItem("4");
        if (!SystemLogic.drumStrips.contains("Tom") && !SystemLogic.drumStrips.contains("Tom1")) {
            rackTomsNumber.setSelectedItem("0");
        } else if (SystemLogic.drumStrips.contains("Tom")) {
            rackTomsNumber.setSelectedItem("1");
        } else if (SystemLogic.drumStrips.contains("Tom2") && !SystemLogic.drumStrips.contains("Tom3")) {
            rackTomsNumber.setSelectedItem("2");
        } else if (SystemLogic.drumStrips.contains("Tom3") && !SystemLogic.drumStrips.contains("Tom4")) {
            rackTomsNumber.setSelectedItem("3");
        } else rackTomsNumber.setSelectedItem("4");
        rackTomsLabel.setOpaque(true);
        rackTomsLabel.setBackground(Color.cyan);
        rackTomsLabel.setBounds(310, 110, 70, 20);
        container.add(rackTomsLabel);
        rackTomsNumber.setBounds(390, 110, 40, 20);
        container.add(rackTomsNumber);

        floorTomsNumber.addItemListener(this);
        floorTomsNumber.addItem("0");
        floorTomsNumber.addItem("1");
        floorTomsNumber.addItem("2");
        floorTomsNumber.addItem("3");
        floorTomsNumber.addItem("4");
        if (!SystemLogic.drumStrips.contains("FlTom") && !SystemLogic.drumStrips.contains("FlTom1")) {
            floorTomsNumber.setSelectedItem("0");
        } else if (SystemLogic.drumStrips.contains("FlTom")) {
            floorTomsNumber.setSelectedItem("1");
        } else if (SystemLogic.drumStrips.contains("FlTom2") && !SystemLogic.drumStrips.contains("FlTom3")) {
            floorTomsNumber.setSelectedItem("2");
        } else if (SystemLogic.drumStrips.contains("FlTom3") && !SystemLogic.drumStrips.contains("FlTom4")) {
            floorTomsNumber.setSelectedItem("3");
        } else floorTomsNumber.setSelectedItem("4");
        floorTomsLabel.setOpaque(true);
        floorTomsLabel.setBackground(Color.cyan);
        floorTomsLabel.setBounds(205, 180, 70, 20);
        container.add(floorTomsLabel);
        floorTomsNumber.setBounds(280, 180, 40, 20);
        container.add(floorTomsNumber);

        overNumber.addItemListener(this);
        overNumber.addItem("0");
        overNumber.addItem("1");
        overNumber.addItem("2");
        if (SystemLogic.drumStrips.contains("Over")) {
            overNumber.setSelectedItem("1");
        } else if (SystemLogic.drumStrips.contains("Over1")) overNumber.setSelectedItem("2");
        else overNumber.setSelectedItem("0");
        overLabel.setOpaque(true);
        overLabel.setBackground(Color.cyan);
        overLabel.setBounds(350, 10, 60, 20);
        container.add(overLabel);
        overNumber.setBounds(360, 35, 40, 20);
        container.add(overNumber);

        drumChannels.setBounds(650, 5, 150, 25);
        container.add(drumChannels);

//Elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 60);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNext.setEnabled(true);
                SystemLogic.drumStrips.clear();
                if (kicksNumber.getSelectedItem() == "1") {
                    SystemLogic.drumStrips.add(0, "Kick");
                }else {
                    SystemLogic.drumStrips.add(0, "Kick1");
                    SystemLogic.drumStrips.add(1, "Kick2");
                }
                if (snaresNumber.getSelectedItem() == "just top"){
                    SystemLogic.drumStrips.add("Sn1");
                }else {
                    SystemLogic.drumStrips.add("Sn1Top");
                    SystemLogic.drumStrips.add("Sn1Bot");
                }
                if (snare2Number.getSelectedItem() == "just top"){
                    SystemLogic.drumStrips.add("Sn2");
                }else if (snare2Number.getSelectedItem() == "top+bottom"){
                    SystemLogic.drumStrips.add("Sn2Top");
                    SystemLogic.drumStrips.add("Sn2Bot");
                }
                if (hatsNumber.getSelectedItem() == "1") SystemLogic.drumStrips.add("Hat");
                if (rackTomsNumber.getSelectedItem() == "1"){
                    SystemLogic.drumStrips.add("Tom");
                }else if (rackTomsNumber.getSelectedItem() == "2"){
                    SystemLogic.drumStrips.add("Tom1");
                    SystemLogic.drumStrips.add("Tom2");
                }else if (rackTomsNumber.getSelectedItem() == "3"){
                    SystemLogic.drumStrips.add("Tom1");
                    SystemLogic.drumStrips.add("Tom2");
                    SystemLogic.drumStrips.add("Tom3");
                }else if (rackTomsNumber.getSelectedItem() == "4"){
                    SystemLogic.drumStrips.add("Tom1");
                    SystemLogic.drumStrips.add("Tom2");
                    SystemLogic.drumStrips.add("Tom3");
                    SystemLogic.drumStrips.add("Tom4");
                }
                if (floorTomsNumber.getSelectedItem() == "1"){
                    SystemLogic.drumStrips.add("FlTom");
                }else if (floorTomsNumber.getSelectedItem() == "2"){
                    SystemLogic.drumStrips.add("FlTom1");
                    SystemLogic.drumStrips.add("FlTom2");
                }else if (floorTomsNumber.getSelectedItem() == "3"){
                    SystemLogic.drumStrips.add("FlTom1");
                    SystemLogic.drumStrips.add("FlTom2");
                    SystemLogic.drumStrips.add("FlTom3");
                }else if (floorTomsNumber.getSelectedItem() == "4"){
                    SystemLogic.drumStrips.add("FlTom1");
                    SystemLogic.drumStrips.add("FlTom2");
                    SystemLogic.drumStrips.add("FlTom3");
                    SystemLogic.drumStrips.add("FlTom4");
                }
                if (overNumber.getSelectedItem() == "1"){
                    SystemLogic.drumStrips.add("Over");
                }else if (overNumber.getSelectedItem() == "2"){
                    SystemLogic.drumStrips.add("Over1");
                    SystemLogic.drumStrips.add("Over2");
                }
                drumChannels.setText("Drum Channels: " + SystemLogic.drumStrips.size());
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
                DrumTypeSel drumTypeSel = new DrumTypeSel();
                drumTypeSel.setVisible(true);
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
                DefineInstruments.buttonDrums.setText("Drums:" + SystemLogic.drumStrips.size());
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
                    AcousticDrums acousticDrums = new AcousticDrums();
                    acousticDrums.setVisible(true);
                }
            }
        });
    }


    @Override
    public void itemStateChanged(ItemEvent event) {
        buttonNext.setEnabled(false);


    }
}


