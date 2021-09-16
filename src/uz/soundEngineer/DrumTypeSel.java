package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class DrumTypeSel extends JFrame {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonCancel = new JButton("Cancel");
    private JButton buttonNext = new JButton("Next");
    private JLabel chooseDrumsType = new JLabel("Choose drums type:");
    private JRadioButton acoustic = new JRadioButton("Acoustic drum kit");
    private JRadioButton electronic = new JRadioButton("Electronic drum kit");
    private JRadioButton noDrums = new JRadioButton("No drum kit (the drum part");
    private JLabel backtrack = new JLabel("is recorded in the backtrack)");
    public void terminateThisWindow(){
        this.dispose();
    }



    public DrumTypeSel() throws HeadlessException{
        super("Sound Engineer");
        Font font = new Font("",Font.BOLD,20);
        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width/2-350, dimension.height/2-250, 854, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/drumKitType.jpg"));
            setContentPane(new JPanel(new BorderLayout()) {
                @Override public void paintComponent(Graphics g) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(),getHeight(), this);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//background image end
        Container container = this.getContentPane();
        container.setLayout(null);
        chooseDrumsType.setFont(font);
        chooseDrumsType.setBounds(300, 5, 200, 50);
        container.add(chooseDrumsType);

        ButtonGroup group = new ButtonGroup();
        acoustic.setSelected(true);
        group.add(acoustic);
        group.add(electronic);
        group.add(noDrums);

        container.add(acoustic);
        acoustic.setBounds(110, 295, 150, 25);
        container.add(electronic);
        electronic.setBounds(350, 295, 150,25);
        container.add(noDrums);
        noDrums.setBounds(555, 295,200,25);
        container.add(backtrack);
        backtrack.setBounds(570,320,200,25);

//Button back start
        buttonBack.setBounds(100, 360, 100, 40);
        buttonBack.setBorderPainted(true);
        buttonBack.setBackground(Color.orange);
        container.add(buttonBack);

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChooseBandType chooseBandType = new ChooseBandType();
                chooseBandType.setVisible(true);
                terminateThisWindow();

            }
        });
//Button back end

//Button cancel start
        buttonCancel.setBounds(374, 360, 100, 40);
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
        buttonNext.setBounds(640, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (acoustic.isSelected()){
                AcousticDrums acousticDrums = new AcousticDrums();
                acousticDrums.setVisible(true);
                terminateThisWindow();
            }else if (electronic.isSelected()){}else {}

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

}
