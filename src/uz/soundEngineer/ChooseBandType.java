package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public  class ChooseBandType extends JFrame {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");

    private JButton buttonCancel = new JButton ("Cancel");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonEnter = new JButton("Enter");
    private JRadioButton popRock = new JRadioButton ("Pop/Rock/Jazz");
    private JRadioButton symphOrc = new JRadioButton("Symphonic orchestra");
    private JRadioButton rockOrch = new JRadioButton("Rock + Orchestra");
    private JRadioButton natPop = new JRadioButton("National Pop");
    private JRadioButton national = new JRadioButton("National");
    private JTextField textField = new JTextField();
    private JLabel typeName = new JLabel("Type Scene Name:");
    private JLabel choosaBand = new JLabel("Choose Show Type:");
    private JLabel sceneLabel = new JLabel("Scene:  " + SystemLogic.sceneName);
    public void terminateThisWindow(){
        this.dispose();
    }

    public ChooseBandType() throws HeadlessException  {
        super("Sound Engineer  " + SystemLogic.sceneName);
        Font font = new Font("",Font.BOLD,15);

        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/lineArray.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end

//Elements start
        Container container = this.getContentPane();
        container.setLayout(null);

        ButtonGroup group = new ButtonGroup();
        popRock.setActionCommand("1");
        popRock.setBackground(Color.green);
        group.add(popRock);
        symphOrc.setActionCommand("2");
        symphOrc.setBackground(Color.green);
        group.add(symphOrc);
        rockOrch.setActionCommand("3");
        rockOrch.setBackground(Color.green);
        group.add(rockOrch);
        national.setActionCommand("4");
        national.setBackground(Color.green);
        group.add(national);
        natPop.setActionCommand("5");
        natPop.setBackground(Color.green);
        group.add(natPop);

        Font font1 = new Font("",Font.BOLD,20);
        sceneLabel.setFont(font1);
        sceneLabel.setForeground(Color.orange);
        sceneLabel.setBounds(320, 35, 400, 30);
        container.add(sceneLabel);
        Container container1 = new Container();
        container1.setLayout(new GridLayout(8, 1, 3, 10));
        container1.setBackground(Color.green);
        container.add(container1);
        container1.setBounds(350, 90, 150, 230);
        typeName.setFont(font);
        container1.add(typeName);
        textField.setBounds(0,0,150,30);
        container1.add(textField);
        choosaBand.setFont(font);
        container1.add(choosaBand);
        container1.add(popRock);
        popRock.setSelected(true);
        container1.add(symphOrc);
        container1.add(rockOrch);
        container1.add(national);
        container1.add(natPop);

//Elements end

//Button enter start
        buttonEnter.setBounds(500, 120, 65, 20);
        buttonEnter.setBackground(Color.cyan);
        container.add(buttonEnter);
        buttonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SystemLogic.sceneName = textField.getText();
                ChooseBandType chooseBandType = new ChooseBandType();
                chooseBandType.setVisible(true);
                terminateThisWindow();
                textField.setText(SystemLogic.sceneName);

            }
        });
//Button enter end

//Button cancel start
        buttonCancel.setBounds(200, 360, 100, 40);
        buttonCancel.setBorderPainted(true);
        buttonCancel.setBackground(Color.orange);
        container.add(buttonCancel);
        buttonCancel.addActionListener(new ActionListener() {
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
//Button cancel end
        
//Button next start
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBand = group.getSelection().getActionCommand();
                switch (selectedBand){
                    case "1":
                        DefineInstruments defineInstruments = new DefineInstruments();
                        defineInstruments.setVisible(true);
                        terminateThisWindow();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(ChooseBandType.this, "Selected band2 is not available yet");
                            break;
                    case "3":
                        JOptionPane.showMessageDialog(ChooseBandType.this, "Selected band3 is not available yet");
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(ChooseBandType.this, "Selected band4 is not available yet");
                        break;
                    case "5":
                        JOptionPane.showMessageDialog(ChooseBandType.this, "Selected band5 is not available yet");
                }
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


}
