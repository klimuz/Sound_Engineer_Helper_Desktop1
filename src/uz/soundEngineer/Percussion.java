package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Percussion extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOutputsLabel = new JLabel("Choose among percussion:");
    private JLabel congasLabel = new JLabel("Congas");
    private JLabel bongosLabel = new JLabel("Bongos");
    private JLabel shakerLabel = new JLabel("Shaker");
    private JLabel tambourineLabel = new JLabel("Tambourine");
    private JLabel overLabel = new JLabel("Overhead");
    private JLabel doyraLabel = new JLabel("Doyra");
    private JLabel tablaLabel = new JLabel("Tabla");
    private JLabel nagoraLabel = new JLabel("Nagora");
    private JLabel jambeyLabel = new JLabel("Jambey");
    private JLabel kushNagLabel = new JLabel("KushNagora");
    private JLabel othersLabel = new JLabel("Others");
    private JLabel genericsLabel = new JLabel("Generic:");
    private JLabel nationalLabel = new JLabel("National:");
    private JComboBox<String> congasNumber = new JComboBox();
    private JComboBox<String> bongosNumber = new JComboBox();
    private JComboBox<String> shakerNumber = new JComboBox();
    private JComboBox<String> tambourineNumber = new JComboBox();
    private JComboBox<String> overNumber = new JComboBox();
    private JComboBox<String> doyraNumber = new JComboBox();
    private JComboBox<String> tablaNumber = new JComboBox();
    private JComboBox<String> nagoraNumber = new JComboBox();
    private JComboBox<String> jambeyNumber = new JComboBox();
    private JComboBox<String> othersNumber = new JComboBox();
    private JLabel numChannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }



    public Percussion() throws HeadlessException {
        super("Sound Engineer");
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/blueBgnd.jpg"));
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
        chooseOutputsLabel.setBounds(245, 5, 300, 50);
        container.add(chooseOutputsLabel);
        genericsLabel.setFont(font);
        genericsLabel.setBounds(180, 55, 100, 50);
        container.add(genericsLabel);
        nationalLabel.setFont(font);
        nationalLabel.setBounds(450, 55, 100, 50);
        container.add(nationalLabel);

        Container gridContainerL= new Container();//for labels
        gridContainerL.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerL.setBounds(170, 120, 100, 200);

        Container gridContainerN= new Container();//for combo boxes
        gridContainerN.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerN.setBounds(270, 120, 40, 200);

        Container gridContainerNL= new Container();//for labels
        gridContainerNL.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerNL.setBounds(440, 120, 50, 200);

        Container gridContainerNN= new Container();//for combo boxes
        gridContainerNN.setLayout(new GridLayout(6,1, 5, 10));
        gridContainerNN.setBounds(540, 120, 40, 200);

        gridContainerL.add(congasLabel);
        congasNumber.addItem("0");
        congasNumber.addItem("1");
        congasNumber.addItem("2");
        congasNumber.addItem("3");
        congasNumber.addItemListener(this);
        if (!SystemLogic.percussionStrips.contains("Cng2") && SystemLogic.percussionStrips.contains("Cng1")){
            congasNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Cng3") && SystemLogic.percussionStrips.contains("Cng2")){
            congasNumber.setSelectedItem("2");
        }else if (SystemLogic.percussionStrips.contains("Cng3")){
            congasNumber.setSelectedItem("3");
        }
        gridContainerN.add(congasNumber);
        gridContainerL.add(bongosLabel);
        bongosNumber.addItem("0");
        bongosNumber.addItem("1");
        bongosNumber.addItem("2");
        if (SystemLogic.percussionStrips.contains("Bong")){
            bongosNumber.setSelectedItem("1");
        }else if (SystemLogic.percussionStrips.contains("Bng1")){
            bongosNumber.setSelectedItem("2");
        }
        bongosNumber.addItemListener(this);
        gridContainerN.add(bongosNumber);
        gridContainerL.add(shakerLabel);
        shakerNumber.addItem("0");
        shakerNumber.addItem("1");
        shakerNumber.addItem("2");
        shakerNumber.addItem("3");
        if (SystemLogic.percussionStrips.contains("Shkr")){
            shakerNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Shk3") && SystemLogic.percussionStrips.contains("Shk2")){
            shakerNumber.setSelectedItem("2");
        }else if (SystemLogic.percussionStrips.contains("Shk3")){
            shakerNumber.setSelectedItem("3");
        }
        shakerNumber.addItemListener(this);
        gridContainerN.add(shakerNumber);
        gridContainerL.add(tambourineLabel);
        tambourineNumber.addItem("0");
        tambourineNumber.addItem("1");
        tambourineNumber.addItem("2");
        tambourineNumber.addItem("3");
        if (SystemLogic.percussionStrips.contains("Tmbn")){
            tambourineNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Tmb3") && SystemLogic.percussionStrips.contains("Tmb2")){
            tambourineNumber.setSelectedItem("2");
        }else if (SystemLogic.percussionStrips.contains("Tmb3")){
            tambourineNumber.setSelectedItem("3");
        }
        tambourineNumber.addItemListener(this);
        gridContainerN.add(tambourineNumber);
        gridContainerL.add(overLabel);
        overNumber.addItem("0");
        overNumber.addItem("1");
        overNumber.addItem("2");
        overNumber.addItemListener(this);
        if (SystemLogic.percussionStrips.contains("Over")){
            overNumber.setSelectedItem("1");
        }else if (SystemLogic.percussionStrips.contains("Ove2")){
            overNumber.setSelectedItem("2");
        }
        gridContainerN.add(overNumber);

        container.add(gridContainerL);
        container.add(gridContainerN);

        gridContainerNL.add(doyraLabel);
        doyraNumber.addItem("0");
        doyraNumber.addItem("1");
        doyraNumber.addItem("2");
        doyraNumber.addItem("3");
        doyraNumber.addItem("4");
        doyraNumber.addItem("5");
        if (SystemLogic.percussionStrips.contains("Doyr")){
            doyraNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Doy3") && SystemLogic.percussionStrips.contains("Doy2")){
            doyraNumber.setSelectedItem("2");
        }else if (!SystemLogic.percussionStrips.contains("Doy4") && SystemLogic.percussionStrips.contains("Doy3")){
            doyraNumber.setSelectedItem("3");
        }else if (!SystemLogic.percussionStrips.contains("Doy5") && SystemLogic.percussionStrips.contains("Doy4")){
            doyraNumber.setSelectedItem("4");
        }else if (SystemLogic.percussionStrips.contains("Doy5")){
            doyraNumber.setSelectedItem("5");
        }
        doyraNumber.addItemListener(this);
        gridContainerNN.add(doyraNumber);
        gridContainerNL.add(tablaLabel);
        tablaNumber.addItem("0");
        tablaNumber.addItem("1");
        tablaNumber.addItem("2");
        tablaNumber.addItem("3");
        if (SystemLogic.percussionStrips.contains("Tabl")){
            tablaNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Tab3") && SystemLogic.percussionStrips.contains("Tab2")){
            tablaNumber.setSelectedItem("2");
        }else if (SystemLogic.percussionStrips.contains("Tab3")){
            tablaNumber.setSelectedItem("3");
        }
        tablaNumber.addItemListener(this);
        gridContainerNN.add(tablaNumber);
        gridContainerNL.add(nagoraLabel);
        nagoraNumber.addItem("0");
        nagoraNumber.addItem("1");
        nagoraNumber.addItem("2");
        nagoraNumber.addItem("3");
        if (SystemLogic.percussionStrips.contains("Nago")){
            nagoraNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Nag3") && SystemLogic.percussionStrips.contains("Nag2")){
            nagoraNumber.setSelectedItem("2");
        }else if (SystemLogic.percussionStrips.contains("Nag3")){
            nagoraNumber.setSelectedItem("3");
        }
        nagoraNumber.addItemListener(this);
        gridContainerNN.add(nagoraNumber);
        gridContainerNL.add(jambeyLabel);
        jambeyNumber.addItem("0");
        jambeyNumber.addItem("1");
        jambeyNumber.addItem("2");
        if (SystemLogic.percussionStrips.contains("Jamb")){
            jambeyNumber.setSelectedItem("1");
        }else if (SystemLogic.percussionStrips.contains("Jam2")){
            jambeyNumber.setSelectedItem("2");
        }
        jambeyNumber.addItemListener(this);
        gridContainerNN.add(jambeyNumber);
        gridContainerNL.add(othersLabel);
        othersNumber.addItem("0");
        othersNumber.addItem("1");
        othersNumber.addItem("2");
        othersNumber.addItem("3");
        othersNumber.addItem("4");
        othersNumber.addItem("5");
        if (SystemLogic.percussionStrips.contains("Perc")){
            othersNumber.setSelectedItem("1");
        }else if (!SystemLogic.percussionStrips.contains("Per3") && SystemLogic.percussionStrips.contains("Per2")){
            othersNumber.setSelectedItem("2");
        }else if (!SystemLogic.percussionStrips.contains("Per4") && SystemLogic.percussionStrips.contains("Per3")){
            othersNumber.setSelectedItem("3");
        }else if (!SystemLogic.percussionStrips.contains("Per5") && SystemLogic.percussionStrips.contains("Per4")){
            othersNumber.setSelectedItem("4");
        }else if (SystemLogic.percussionStrips.contains("Per5")){
            othersNumber.setSelectedItem("5");
        }
        othersNumber.addItemListener(this);
        gridContainerNN.add(othersNumber);

        container.add(gridContainerNL);
        container.add(gridContainerNN);
        numChannels.setBounds(650, 5, 150, 25);//label
        container.add(numChannels);


//elements end

//Button apply start
        buttonApply.setBounds(725, 240, 70, 60);
        buttonApply.setBorderPainted(true);
        buttonApply.setBackground(Color.green);
        container.add(buttonApply);
        buttonApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemLogic.percussionStrips.clear();

                String congSel = congasNumber.getSelectedItem().toString();
                switch (congSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Cong");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Con1");
                        SystemLogic.percussionStrips.add("Con2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Con1");
                        SystemLogic.percussionStrips.add("Con2");
                        SystemLogic.percussionStrips.add("Con3");
                        break;

                }
                String bongSel = bongosNumber.getSelectedItem().toString();
                switch (bongSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Bong");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Bon1");
                        SystemLogic.percussionStrips.add("Bon2");
                        break;


                }
                String shakSel = shakerNumber.getSelectedItem().toString();
                switch (shakSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Shkr");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Shk1");
                        SystemLogic.percussionStrips.add("Shk2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Shk1");
                        SystemLogic.percussionStrips.add("Shk2");
                        SystemLogic.percussionStrips.add("Shk3");
                        break;
                }
                String tambSel = tambourineNumber.getSelectedItem().toString();
                switch (tambSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Tmbn");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Tmb1");
                        SystemLogic.percussionStrips.add("Tmb2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Tmb1");
                        SystemLogic.percussionStrips.add("Tmb2");
                        SystemLogic.percussionStrips.add("Tmb3");
                        break;
                }
                String overSel = overNumber.getSelectedItem().toString();
                switch (overSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Over");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Ove1");
                        SystemLogic.percussionStrips.add("Ove2");
                        break;
                }
                String doyraSel = doyraNumber.getSelectedItem().toString();
                switch (doyraSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Doyr");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Doy1");
                        SystemLogic.percussionStrips.add("Doy2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Doy1");
                        SystemLogic.percussionStrips.add("Doy2");
                        SystemLogic.percussionStrips.add("Doy3");
                        break;
                    case "4":
                        SystemLogic.percussionStrips.add("Doy1");
                        SystemLogic.percussionStrips.add("Doy2");
                        SystemLogic.percussionStrips.add("Doy3");
                        SystemLogic.percussionStrips.add("Doy4");
                        break;
                    case "5":
                        SystemLogic.percussionStrips.add("Doy1");
                        SystemLogic.percussionStrips.add("Doy2");
                        SystemLogic.percussionStrips.add("Doy3");
                        SystemLogic.percussionStrips.add("Doy4");
                        SystemLogic.percussionStrips.add("Doy5");
                        break;
                }
                String tablaSel = tablaNumber.getSelectedItem().toString();
                switch (tablaSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Tabl");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Tab1");
                        SystemLogic.percussionStrips.add("Tab2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Tab1");
                        SystemLogic.percussionStrips.add("Tab2");
                        SystemLogic.percussionStrips.add("Tab3");
                        break;
                }
                String nagoraSel = tablaNumber.getSelectedItem().toString();
                switch (nagoraSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Nago");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Nag1");
                        SystemLogic.percussionStrips.add("Nag2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Nag1");
                        SystemLogic.percussionStrips.add("Nag2");
                        SystemLogic.percussionStrips.add("Nag3");
                        break;
                }
                String jambeySel = jambeyNumber.getSelectedItem().toString();
                switch (jambeySel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Jamb");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Jam1");
                        SystemLogic.percussionStrips.add("Jam2");
                        break;
                }
                String otherSel = doyraNumber.getSelectedItem().toString();
                switch (otherSel) {
                    case "1":
                        SystemLogic.percussionStrips.add("Perc");
                        break;
                    case "2":
                        SystemLogic.percussionStrips.add("Per1");
                        SystemLogic.percussionStrips.add("Per2");
                        break;
                    case "3":
                        SystemLogic.percussionStrips.add("Per1");
                        SystemLogic.percussionStrips.add("Per2");
                        SystemLogic.percussionStrips.add("Per3");
                        break;
                    case "4":
                        SystemLogic.percussionStrips.add("Per1");
                        SystemLogic.percussionStrips.add("Per2");
                        SystemLogic.percussionStrips.add("Per3");
                        SystemLogic.percussionStrips.add("Per4");
                        break;
                    case "5":
                        SystemLogic.percussionStrips.add("Per1");
                        SystemLogic.percussionStrips.add("Per2");
                        SystemLogic.percussionStrips.add("Per3");
                        SystemLogic.percussionStrips.add("Per4");
                        SystemLogic.percussionStrips.add("Per5");
                        break;
                }

                buttonNext.setEnabled(true);
                numChannels.setText("Percussion Channels: " + SystemLogic.percussionStrips.size());
                System.out.println(SystemLogic.percussionStrips);
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
                DefineInstruments.buttonPercuss.setText("Percussion:" + SystemLogic.percussionStrips.size());
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
                    Percussion percussion = new Percussion();
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

