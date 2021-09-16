package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class AcousticDrums extends JFrame {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonCancel = new JButton("Cancel");
    private JButton buttonNext = new JButton("Next");
    private JLabel defineDrumsLabel = new JLabel("Define Drum channels quantity:");
    private JLabel overLabel = new JLabel("OverHead");
    private JLabel kicksLabel = new JLabel("Kicks:");
    private JLabel snaresLabel = new JLabel("Snares:");
    private JLabel hatLabel = new JLabel("Hat:");
    private JLabel rackTomsLabel = new JLabel("Rack Toms:");
    private JLabel floorTomsLabel = new JLabel("Floor Toms:");
    private JLabel snare2Label = new JLabel("Snare2:");



    private JComboBox<Integer> kicksNumber = new JComboBox();
    private JComboBox<String> snaresNumber = new JComboBox();
    private JComboBox<Integer> hatsNumber = new JComboBox();
    private JComboBox<Integer> rackTomsNumber = new JComboBox();
    private JComboBox<Integer> floorTomsNumber = new JComboBox();
    private JComboBox<Integer> overNumber = new JComboBox();
    private JComboBox<String> snare2Number = new JComboBox();

    public void terminateThisWindow(){
        this.dispose();
    }



    public AcousticDrums() throws HeadlessException {
        super("Sound Engineer");
        Font font = new Font("", Font.BOLD, 18);
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

        kicksNumber.addItem(1);
        kicksNumber.addItem(2);
        kicksNumber.setSelectedItem(1);
        kicksLabel.setBounds(330,240,38,20);
        kicksLabel.setBackground(Color.cyan);
        kicksLabel.setOpaque(true);
        container.add(kicksLabel);
        kicksNumber.setBounds(375,240,40,20);
        container.add(kicksNumber);

        snaresNumber.addItem("just top");
        snaresNumber.addItem("top+bottom");
        snaresNumber.setSelectedItem("top+bottom");
        snaresLabel.setOpaque(true);
        snaresLabel.setBackground(Color.cyan);
        snaresLabel.setBounds(395,165,48,20);
        container.add(snaresLabel);
        snaresNumber.setBounds(445, 165,90, 20);
        container.add(snaresNumber);

        hatsNumber.addItem(0);
        hatsNumber.addItem(1);
        hatsNumber.setSelectedItem(1);
        hatLabel.setOpaque(true);
        hatLabel.setBackground(Color.cyan);
        hatLabel.setBounds(517,90,25,20);
        container.add(hatLabel);
        hatsNumber.setBounds(545,90,40,20);
        container.add(hatsNumber);

        rackTomsNumber.addItem(0);
        rackTomsNumber.addItem(1);
        rackTomsNumber.addItem(2);
        rackTomsNumber.addItem(3);
        rackTomsNumber.addItem(4);
        rackTomsNumber.setSelectedItem(2);
        rackTomsLabel.setOpaque(true);
        rackTomsLabel.setBackground(Color.cyan);
        rackTomsLabel.setBounds(310, 110, 70, 20);
        container.add(rackTomsLabel);
        rackTomsNumber.setBounds(390, 110, 40, 20);
        container.add(rackTomsNumber);

        floorTomsNumber.addItem(0);
        floorTomsNumber.addItem(1);
        floorTomsNumber.addItem(2);
        floorTomsNumber.addItem(3);
        floorTomsNumber.addItem(4);
        floorTomsNumber.setSelectedItem(1);
        floorTomsLabel.setOpaque(true);
        floorTomsLabel.setBackground(Color.cyan);
        floorTomsLabel.setBounds(205, 180, 70, 20);
        container.add(floorTomsLabel);
        floorTomsNumber.setBounds(280, 180, 40,20);
        container.add(floorTomsNumber);

        overNumber.addItem(0);
        overNumber.addItem(1);
        overNumber.addItem(2);
        overNumber.setSelectedItem(2);
        overLabel.setOpaque(true);
        overLabel.setBackground(Color.cyan);
        overLabel.setBounds(350, 10, 60, 20);
        container.add(overLabel);
        overNumber.setBounds(360, 35, 40, 20);
        container.add(overNumber);

        snare2Number.addItem("just top");
        snare2Number.addItem("top+bottom");
        snare2Number.setSelectedItem("just top");
        snare2Label.setOpaque(true);
        snare2Label.setBackground(Color.cyan);
        snare2Label.setBounds(645,95,48,20);
        container.add(snare2Label);
        snare2Number.setBounds(625, 120,90, 20);
        container.add(snare2Number);


//Elements end

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
