package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class DefineInstruments extends JFrame{
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    public static JButton buttonDrums =new JButton("Drums");
    public static JButton buttonGuitars =new JButton("Guitars");
    public static JButton buttonSynths =new JButton("Synths");
    public static JButton buttonPercuss =new JButton("Percussion");
    public static JButton buttonStrings =new JButton("Strings");
    public static JButton buttonBrass =new JButton("Brass&Woods");
    public static JButton buttonVocals =new JButton("Vocals");
    public static JButton buttonOthers =new JButton("Others");
    private JButton buttonBack =new JButton("Back");
    private JButton buttonCancel =new JButton("Cancel");
    private JButton buttonNext =new JButton("Next");
    private JLabel define = new JLabel("Define instruments:");
    public static JLabel numChannels = new JLabel("");
    public void terminateThisWindow(){
        this.dispose();
    }

    public DefineInstruments() throws HeadlessException {
        super("Sound Engineer");
        Font font = new Font("", Font.BOLD, 30);

        this.setIconImage(new ImageIcon("img/logo.png").getImage());
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 350, dimension.height / 2 - 250, 854, 480);
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

//elements start
        Container container = this.getContentPane();
        container.setLayout(null);
        define.setFont(font);
        define.setOpaque(false);
        define.setBackground(Color.cyan);
        define.setBounds(250, 20, 300, 40);
        define.setForeground(Color.orange);
        container.add(define);
        numChannels.setBounds(650, 5, 150, 25);
        numChannels.setForeground(Color.yellow);
        container.add(numChannels);
        Container gridContainer = new Container();
        gridContainer.setLayout(new GridLayout(2, 4, 10, 20));
        gridContainer.setBounds(150, 100, 500, 150);
        buttonDrums.setBackground(Color.green);
        gridContainer.add(buttonDrums);
        buttonDrums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrumTypeSel drumTypeSel = new DrumTypeSel();
                drumTypeSel.setVisible(true);
            }
        });
        buttonGuitars.setBackground(Color.green);
        gridContainer.add(buttonGuitars);
        buttonSynths.setBackground(Color.green);
        gridContainer.add(buttonSynths);
        buttonPercuss.setBackground(Color.green);
        gridContainer.add(buttonPercuss);
        buttonStrings.setBackground(Color.green);
        gridContainer.add(buttonStrings);
        buttonBrass.setBackground(Color.green);
        gridContainer.add(buttonBrass);
        buttonVocals.setBackground(Color.green);
        gridContainer.add(buttonVocals);
        buttonOthers.setBackground(Color.green);
        gridContainer.add(buttonOthers);
        container.add(gridContainer);
        buttonGuitars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Guitars guitars = new Guitars();
                guitars.setVisible(true);
            }
        });
        buttonSynths.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Synths synths = new Synths();
                synths.setVisible(true);
            }

        });
        buttonPercuss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Percussion percussion = new Percussion();
                percussion.setVisible(true);
            }
        });
        buttonStrings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stringed stringed = new Stringed();
                stringed.setVisible(true);
            }
        });
        buttonBrass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WoodsBrass woodsBrass = new WoodsBrass();
                woodsBrass.setVisible(true);
            }
        });
        buttonVocals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vocals vocals = new Vocals();
                vocals.setVisible(true);
            }
        });
        buttonOthers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Others others = new Others();
                others.setVisible(true);
            }
        });
//elements end

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
                    terminateThisWindow();
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
                Consoles consoles = new Consoles();
                consoles.setVisible(true);
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
                    DefineInstruments defineInstruments = new DefineInstruments();
                    defineInstruments.setVisible(true);
                }
            }
        });
    }
}
