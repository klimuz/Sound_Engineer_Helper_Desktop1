package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

public class ElDrums extends JFrame implements ItemListener {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonBack = new JButton("Back");
    private JButton buttonApply = new JButton("Apply");
    private JButton buttonNext = new JButton("Next");
    private JLabel defineDrumsLabel = new JLabel("Define Drum channels quantity:");
    private JLabel drumChannels = new JLabel("");

    private JRadioButton mono = new JRadioButton ("1 Mono");
    private JRadioButton stereo = new JRadioButton("2 Stereo");
    private JRadioButton kickStereo = new JRadioButton("3 Kick+Stereo");
    private JRadioButton kickSnareStereo = new JRadioButton("4 Kick+Snare+Stereo");
    public void terminateThisWindow() {
        this.dispose();
    }

    public ElDrums() throws HeadlessException {
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
            Image backgroundImage = javax.imageio.ImageIO.read(new File("img/elDrums.jpg"));
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

        ButtonGroup group = new ButtonGroup();
        mono.setActionCommand("1");
        mono.setBackground(Color.green);
        group.add(mono);
        stereo.setActionCommand("2");
        stereo.setBackground(Color.green);
        group.add(stereo);
        kickStereo.setActionCommand("3");
        kickStereo.setBackground(Color.green);
        group.add(kickStereo);
        kickSnareStereo.setActionCommand("4");
        kickSnareStereo.setBackground(Color.green);
        group.add(kickSnareStereo);
        drumChannels.setBounds(700, 5, 100, 25);
        container.add(drumChannels);

        Container container1 = new Container();
        container1.setLayout(new GridLayout(4, 1, 3, 20));
        container1.setBackground(Color.green);
        container.add(container1);
        container1.setBounds(450, 100, 150, 150);
        container1.add(mono);
        container1.add(stereo);
        stereo.setSelected(true);
        container1.add(kickStereo);
        container1.add(kickSnareStereo);
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
                String selectedConfig = group.getSelection().getActionCommand();
                switch (selectedConfig){
                    case "1":
                        SystemLogic.drumStrips.add(0,"Drums");
                        break;
                    case "2":
                        SystemLogic.drumStrips.add(0,"DrumL");
                        SystemLogic.drumStrips.add(1,"DrumR");
                        break;
                    case "3":
                        SystemLogic.drumStrips.add(0,"OverL");
                        SystemLogic.drumStrips.add(1,"OverR");
                        SystemLogic.drumStrips.add(2,"Kick");
                        break;
                    case "4":
                        SystemLogic.drumStrips.add(0,"Kick");
                        SystemLogic.drumStrips.add(1,"Snare");
                        SystemLogic.drumStrips.add(2,"OverL");
                        SystemLogic.drumStrips.add(3,"OverR");
                        break;

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
                terminateThisWindow();
            }
        });
//Button next end
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
