package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Stringed extends JFrame implements ItemListener {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonApply = new JButton("Apply");
    private JLabel chooseOutputsLabel = new JLabel("Choose among stringed:");
    private JLabel vio1Label = new JLabel("1st violins");
    private JLabel vio2Label = new JLabel("2nd violins");
    private JLabel violasLabel = new JLabel("Violas");
    private JLabel cellosLabel = new JLabel("Cellos");
    private JLabel dBassLabel = new JLabel("Double Bass");
    private JComboBox<String> vio1Number = new JComboBox();
    private JComboBox<String> vio2Number = new JComboBox();
    private JComboBox<String> violasNumber = new JComboBox();
    private JComboBox<String> cellosNumber = new JComboBox();
    private JComboBox<String> dBassNumber = new JComboBox();
    private JLabel numChannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }

    public Stringed() throws HeadlessException {
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/stringed.jpg"));
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

        Container gridContainerL= new Container();//for labels
        gridContainerL.setLayout(new GridLayout(1,5, 70, 10));
        gridContainerL.setBounds(35, 280, 640, 20);

        Container gridContainerN= new Container();//for combo boxes
        gridContainerN.setLayout(new GridLayout(1,5, 70, 10));
        gridContainerN.setBounds(35, 310, 640, 20);

        gridContainerL.add(vio1Label);
        vio1Number.addItem("0");
        vio1Number.addItem("1");
        vio1Number.addItem("2");
        vio1Number.addItem("3");
        vio1Number.addItem("4");
        vio1Number.addItem("5");
        vio1Number.addItem("6");
        vio1Number.addItem("7");
        vio1Number.addItem("8");
        vio1Number.addItemListener(this);
        if (SystemLogic.stringedStrips.contains("Vio1")){
            vio1Number.setSelectedItem("1");
        }else if (!SystemLogic.stringedStrips.contains("V1-3") && SystemLogic.stringedStrips.contains("V1-2")){
            vio1Number.setSelectedItem("2");
        }else if (!SystemLogic.stringedStrips.contains("V1-4") && SystemLogic.stringedStrips.contains("V1-3")){
            vio1Number.setSelectedItem("3");
        }else if (!SystemLogic.stringedStrips.contains("V1-5") && SystemLogic.stringedStrips.contains("V1-4")){
            vio1Number.setSelectedItem("4");
        }else if (!SystemLogic.stringedStrips.contains("V1-6") && SystemLogic.stringedStrips.contains("V1-5")){
            vio1Number.setSelectedItem("5");
        }else if (!SystemLogic.stringedStrips.contains("V1-7") && SystemLogic.stringedStrips.contains("V1-6")){
            vio1Number.setSelectedItem("6");
        }else if (!SystemLogic.stringedStrips.contains("V1-8") && SystemLogic.stringedStrips.contains("V1-7")){
            vio1Number.setSelectedItem("7");
        }else if (SystemLogic.stringedStrips.contains("V1-8")){
            vio1Number.setSelectedItem("8");
        }
        gridContainerN.add(vio1Number);
        gridContainerL.add(vio2Label);
        vio2Number.addItem("0");
        vio2Number.addItem("1");
        vio2Number.addItem("2");
        vio2Number.addItem("3");
        vio2Number.addItem("4");
        vio2Number.addItem("5");
        vio2Number.addItem("6");
        vio2Number.addItem("7");
        vio2Number.addItem("8");
        if (SystemLogic.stringedStrips.contains("Vio2")){
            vio2Number.setSelectedItem("1");
        }else if (!SystemLogic.stringedStrips.contains("V2-3") && SystemLogic.stringedStrips.contains("V2-2")){
            vio2Number.setSelectedItem("2");
        }else if (!SystemLogic.stringedStrips.contains("V2-4") && SystemLogic.stringedStrips.contains("V2-3")){
            vio2Number.setSelectedItem("3");
        }else if (!SystemLogic.stringedStrips.contains("V2-5") && SystemLogic.stringedStrips.contains("V2-4")){
            vio2Number.setSelectedItem("4");
        }else if (!SystemLogic.stringedStrips.contains("V2-6") && SystemLogic.stringedStrips.contains("V2-5")){
            vio2Number.setSelectedItem("5");
        }else if (!SystemLogic.stringedStrips.contains("V2-7") && SystemLogic.stringedStrips.contains("V2-6")){
            vio2Number.setSelectedItem("6");
        }else if (!SystemLogic.stringedStrips.contains("V2-8") && SystemLogic.stringedStrips.contains("V2-7")){
            vio2Number.setSelectedItem("7");
        }else if (SystemLogic.stringedStrips.contains("V2-8")){
            vio2Number.setSelectedItem("8");
        }
        vio2Number.addItemListener(this);
        gridContainerN.add(vio2Number);
        gridContainerL.add(violasLabel);
        violasNumber.addItem("0");
        violasNumber.addItem("1");
        violasNumber.addItem("2");
        violasNumber.addItem("3");
        violasNumber.addItem("4");
        violasNumber.addItem("5");
        violasNumber.addItem("6");
        violasNumber.addItem("7");
        violasNumber.addItem("8");
        if (SystemLogic.stringedStrips.contains("Alts")){
            violasNumber.setSelectedItem("1");
        }else if (!SystemLogic.stringedStrips.contains("Alt3") && SystemLogic.stringedStrips.contains("Alt2")){
            violasNumber.setSelectedItem("2");
        }else if (!SystemLogic.stringedStrips.contains("Alt4") && SystemLogic.stringedStrips.contains("Alt3")){
            violasNumber.setSelectedItem("3");
        }else if (!SystemLogic.stringedStrips.contains("Alt5") && SystemLogic.stringedStrips.contains("Alt4")){
            violasNumber.setSelectedItem("4");
        }else if (!SystemLogic.stringedStrips.contains("Alt6") && SystemLogic.stringedStrips.contains("Alt5")){
            violasNumber.setSelectedItem("5");
        }else if (!SystemLogic.stringedStrips.contains("Alt7") && SystemLogic.stringedStrips.contains("Alt6")){
            violasNumber.setSelectedItem("6");
        }else if (!SystemLogic.stringedStrips.contains("Alt8") && SystemLogic.stringedStrips.contains("Alt7")){
            violasNumber.setSelectedItem("7");
        }else if (SystemLogic.stringedStrips.contains("Alt8")){
            violasNumber.setSelectedItem("8");
        }
        violasNumber.addItemListener(this);
        gridContainerN.add(violasNumber);
        cellosLabel.setOpaque(true);
        cellosLabel.setBackground(Color.yellow);
        gridContainerL.add(cellosLabel);
        cellosNumber.addItem("0");
        cellosNumber.addItem("1");
        cellosNumber.addItem("2");
        cellosNumber.addItem("3");
        cellosNumber.addItem("4");
        cellosNumber.addItem("5");
        cellosNumber.addItem("6");
        cellosNumber.addItem("7");
        cellosNumber.addItem("8");
        if (SystemLogic.stringedStrips.contains("Celo")){
            cellosNumber.setSelectedItem("1");
        }else if (!SystemLogic.stringedStrips.contains("Cel3") && SystemLogic.stringedStrips.contains("Cel2")){
            cellosNumber.setSelectedItem("2");
        }else if (!SystemLogic.stringedStrips.contains("Cel4") && SystemLogic.stringedStrips.contains("Cel3")){
            cellosNumber.setSelectedItem("3");
        }else if (!SystemLogic.stringedStrips.contains("Cel5") && SystemLogic.stringedStrips.contains("Cel4")){
            cellosNumber.setSelectedItem("4");
        }else if (!SystemLogic.stringedStrips.contains("Cel6") && SystemLogic.stringedStrips.contains("Cel5")){
            cellosNumber.setSelectedItem("5");
        }else if (!SystemLogic.stringedStrips.contains("Cel7") && SystemLogic.stringedStrips.contains("Cel6")){
            cellosNumber.setSelectedItem("6");
        }else if (!SystemLogic.stringedStrips.contains("Cel8") && SystemLogic.stringedStrips.contains("Cel7")){
            cellosNumber.setSelectedItem("7");
        }else if (SystemLogic.stringedStrips.contains("Cel8")){
            cellosNumber.setSelectedItem("8");
        }
        cellosNumber.addItemListener(this);
        gridContainerN.add(cellosNumber);
        dBassLabel.setOpaque(true);
        dBassLabel.setBackground(Color.yellow);
        gridContainerL.add(dBassLabel);
        dBassNumber.addItem("0");
        dBassNumber.addItem("1");
        dBassNumber.addItem("2");
        dBassNumber.addItem("3");
        dBassNumber.addItem("4");
        dBassNumber.addItem("5");
        dBassNumber.addItem("6");
        dBassNumber.addItem("7");
        dBassNumber.addItem("8");
        dBassNumber.addItemListener(this);
        if (SystemLogic.stringedStrips.contains("DBas")){
            dBassNumber.setSelectedItem("1");
        }else if (!SystemLogic.stringedStrips.contains("DBs3") && SystemLogic.stringedStrips.contains("DBs2")){
            dBassNumber.setSelectedItem("2");
        }else if (!SystemLogic.stringedStrips.contains("DBs4") && SystemLogic.stringedStrips.contains("DBs3")){
            dBassNumber.setSelectedItem("3");
        }else if (!SystemLogic.stringedStrips.contains("DBs5") && SystemLogic.stringedStrips.contains("DBs4")){
            dBassNumber.setSelectedItem("4");
        }else if (!SystemLogic.stringedStrips.contains("DBs6") && SystemLogic.stringedStrips.contains("DBs5")){
            dBassNumber.setSelectedItem("5");
        }else if (!SystemLogic.stringedStrips.contains("DBs7") && SystemLogic.stringedStrips.contains("DBs6")){
            dBassNumber.setSelectedItem("6");
        }else if (!SystemLogic.stringedStrips.contains("DBs8") && SystemLogic.stringedStrips.contains("DBs7")){
            dBassNumber.setSelectedItem("7");
        }else if (SystemLogic.stringedStrips.contains("DBs8")){
            dBassNumber.setSelectedItem("8");
        }
        gridContainerN.add(dBassNumber);
        container.add(gridContainerL);
        container.add(gridContainerN);
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
                SystemLogic.stringedStrips.clear();

                String vio1Sel = vio1Number.getSelectedItem().toString();
                switch (vio1Sel) {
                    case "1":
                        SystemLogic.stringedStrips.add("Vio1");
                        break;
                    case "2":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        break;
                    case "3":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        break;
                    case "4":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        SystemLogic.stringedStrips.add("V1-4");
                        break;
                    case "5":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        SystemLogic.stringedStrips.add("V1-4");
                        SystemLogic.stringedStrips.add("V1-5");
                        break;
                    case "6":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        SystemLogic.stringedStrips.add("V1-4");
                        SystemLogic.stringedStrips.add("V1-5");
                        SystemLogic.stringedStrips.add("V1-6");
                        break;
                    case "7":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        SystemLogic.stringedStrips.add("V1-4");
                        SystemLogic.stringedStrips.add("V1-5");
                        SystemLogic.stringedStrips.add("V1-6");
                        SystemLogic.stringedStrips.add("V1-7");
                        break;
                    case "8":
                        SystemLogic.stringedStrips.add("V1-1");
                        SystemLogic.stringedStrips.add("V1-2");
                        SystemLogic.stringedStrips.add("V1-3");
                        SystemLogic.stringedStrips.add("V1-4");
                        SystemLogic.stringedStrips.add("V1-5");
                        SystemLogic.stringedStrips.add("V1-6");
                        SystemLogic.stringedStrips.add("V1-7");
                        SystemLogic.stringedStrips.add("V1-8");
                        break;
                }
                String vio2Sel = vio2Number.getSelectedItem().toString();
                switch (vio2Sel) {
                    case "1":
                        SystemLogic.stringedStrips.add("Vio2");
                        break;
                    case "2":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        break;
                    case "3":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        break;
                    case "4":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        SystemLogic.stringedStrips.add("V2-4");
                        break;
                    case "5":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        SystemLogic.stringedStrips.add("V2-4");
                        SystemLogic.stringedStrips.add("V2-5");
                        break;
                    case "6":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        SystemLogic.stringedStrips.add("V2-4");
                        SystemLogic.stringedStrips.add("V2-5");
                        SystemLogic.stringedStrips.add("V2-6");
                        break;
                    case "7":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        SystemLogic.stringedStrips.add("V2-4");
                        SystemLogic.stringedStrips.add("V2-5");
                        SystemLogic.stringedStrips.add("V2-6");
                        SystemLogic.stringedStrips.add("V2-7");
                        break;
                    case "8":
                        SystemLogic.stringedStrips.add("V2-1");
                        SystemLogic.stringedStrips.add("V2-2");
                        SystemLogic.stringedStrips.add("V2-3");
                        SystemLogic.stringedStrips.add("V2-4");
                        SystemLogic.stringedStrips.add("V2-5");
                        SystemLogic.stringedStrips.add("V2-6");
                        SystemLogic.stringedStrips.add("V2-7");
                        SystemLogic.stringedStrips.add("V2-8");
                        break;
                }
                String altSel = violasNumber.getSelectedItem().toString();
                switch (altSel) {
                    case "1":
                        SystemLogic.stringedStrips.add("Alts");
                        break;
                    case "2":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        break;
                    case "3":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        break;
                    case "4":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        SystemLogic.stringedStrips.add("Alt4");
                        break;
                    case "5":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        SystemLogic.stringedStrips.add("Alt4");
                        SystemLogic.stringedStrips.add("Alt5");
                        break;
                    case "6":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        SystemLogic.stringedStrips.add("Alt4");
                        SystemLogic.stringedStrips.add("Alt5");
                        SystemLogic.stringedStrips.add("Alt6");
                        break;
                    case "7":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        SystemLogic.stringedStrips.add("Alt4");
                        SystemLogic.stringedStrips.add("Alt5");
                        SystemLogic.stringedStrips.add("Alt6");
                        SystemLogic.stringedStrips.add("Alt7");
                        break;
                    case "8":
                        SystemLogic.stringedStrips.add("Alt1");
                        SystemLogic.stringedStrips.add("Alt2");
                        SystemLogic.stringedStrips.add("Alt3");
                        SystemLogic.stringedStrips.add("Alt4");
                        SystemLogic.stringedStrips.add("Alt5");
                        SystemLogic.stringedStrips.add("Alt6");
                        SystemLogic.stringedStrips.add("Alt7");
                        SystemLogic.stringedStrips.add("Alt8");
                        break;
                }
                String cellosSel = cellosNumber.getSelectedItem().toString();
                switch (cellosSel) {
                    case "1":
                        SystemLogic.stringedStrips.add("Celo");
                        break;
                    case "2":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        break;
                    case "3":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        break;
                    case "4":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        SystemLogic.stringedStrips.add("Cel4");
                        break;
                    case "5":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        SystemLogic.stringedStrips.add("Cel4");
                        SystemLogic.stringedStrips.add("Cel5");
                        break;
                    case "6":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        SystemLogic.stringedStrips.add("Cel4");
                        SystemLogic.stringedStrips.add("Cel5");
                        SystemLogic.stringedStrips.add("Cel6");
                        break;
                    case "7":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        SystemLogic.stringedStrips.add("Cel4");
                        SystemLogic.stringedStrips.add("Cel5");
                        SystemLogic.stringedStrips.add("Cel6");
                        SystemLogic.stringedStrips.add("Cel7");
                        break;
                    case "8":
                        SystemLogic.stringedStrips.add("Cel1");
                        SystemLogic.stringedStrips.add("Cel2");
                        SystemLogic.stringedStrips.add("Cel3");
                        SystemLogic.stringedStrips.add("Cel4");
                        SystemLogic.stringedStrips.add("Cel5");
                        SystemLogic.stringedStrips.add("Cel6");
                        SystemLogic.stringedStrips.add("Cel7");
                        SystemLogic.stringedStrips.add("Cel8");
                        break;
                }
                String dBassSel = dBassNumber.getSelectedItem().toString();
                switch (dBassSel) {
                    case "1":
                        SystemLogic.stringedStrips.add("DBas");
                        break;
                    case "2":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        break;
                    case "3":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        break;
                    case "4":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        SystemLogic.stringedStrips.add("DBs4");
                        break;
                    case "5":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        SystemLogic.stringedStrips.add("DBs4");
                        SystemLogic.stringedStrips.add("DBs5");
                        break;
                    case "6":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        SystemLogic.stringedStrips.add("DBs4");
                        SystemLogic.stringedStrips.add("DBs5");
                        SystemLogic.stringedStrips.add("DBs6");
                        break;
                    case "7":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        SystemLogic.stringedStrips.add("DBs4");
                        SystemLogic.stringedStrips.add("DBs5");
                        SystemLogic.stringedStrips.add("DBs6");
                        SystemLogic.stringedStrips.add("DBs7");
                        break;
                    case "8":
                        SystemLogic.stringedStrips.add("DBs1");
                        SystemLogic.stringedStrips.add("DBs2");
                        SystemLogic.stringedStrips.add("DBs3");
                        SystemLogic.stringedStrips.add("DBs4");
                        SystemLogic.stringedStrips.add("DBs5");
                        SystemLogic.stringedStrips.add("DBs6");
                        SystemLogic.stringedStrips.add("DBs7");
                        SystemLogic.stringedStrips.add("DBs8");
                        break;
                }

                buttonNext.setEnabled(true);
                numChannels.setText("Stringed Channels: " + SystemLogic.stringedStrips.size());
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
                DefineInstruments.buttonStrings.setText("Stringed:" + SystemLogic.stringedStrips.size());
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
                    Stringed percussion = new Stringed();
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

