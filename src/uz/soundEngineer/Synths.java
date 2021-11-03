package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Synths extends JFrame implements ItemListener {

        private JMenuBar jMenuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        private JButton buttonBack = new JButton("Back");
        private JButton buttonNext = new JButton("Next");
        private JButton buttonApply = new JButton("Apply");
        private JLabel chooseOutputsLabel = new JLabel("Choose outputs quantity:");
        private JLabel synth1Label = new JLabel("Synth1");
        private JLabel synth2Label = new JLabel("Synth2");
        private JLabel synth3Label = new JLabel("Synth3");
    private JComboBox<String> synt1Number = new JComboBox();
    private JComboBox<String> synt2Number = new JComboBox();
    private JComboBox<String> synt3Number = new JComboBox();
      private JLabel synthChannels = new JLabel("");
        public void terminateThisWindow(){
            this.dispose();
        }



        public Synths() throws HeadlessException {
            super("Sound Engineer");
            Font font = new Font("",Font.BOLD,20);
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
                Image backgroundImage = javax.imageio.ImageIO.read(new File("img/synths.jpg"));
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
            chooseOutputsLabel.setBounds(300, 5, 300, 50);
            container.add(chooseOutputsLabel);

            synth1Label.setBounds(120, 50, 40, 50);
            container.add(synth1Label);
            synth2Label.setBounds(375, 50, 40, 50);
            container.add(synth2Label);
            synth3Label.setBounds(650, 50, 40, 50);
            container.add(synth3Label);

            synt1Number.addItemListener(this);
            synt1Number.addItem("Mono");
            synt1Number.addItem("Stereo");
            synt1Number.addItem("No one");
            if (SystemLogic.synthStrips.contains("Syn1")){
                synt1Number.setSelectedItem("Mono");
            }else if (SystemLogic.synthStrips.contains("Sy1L")){
                synt1Number.setSelectedItem("Stereo");
            }else {synt1Number.setSelectedItem("No one");}
            synt1Number.setBounds(100, 250,80, 20);
            container.add(synt1Number);

            synt2Number.addItemListener(this);
            synt2Number.addItem("Mono");
            synt2Number.addItem("Stereo");
            synt2Number.addItem("No one");
            if (SystemLogic.synthStrips.contains("Syn2")){
                synt2Number.setSelectedItem("Mono");
            }else if (SystemLogic.synthStrips.contains("Sy2L")){
                synt2Number.setSelectedItem("Stereo");
            }else {synt2Number.setSelectedItem("No one");}
            synt2Number.setBounds(355, 250,80, 20);
            container.add(synt2Number);

            synt3Number.addItemListener(this);
            synt3Number.addItem("Mono");
            synt3Number.addItem("Stereo");
            synt3Number.addItem("No one");
            if (SystemLogic.synthStrips.contains("Syn3")){
                synt3Number.setSelectedItem("Mono");
            }else if (SystemLogic.synthStrips.contains("Sy3L")){
                synt3Number.setSelectedItem("Stereo");
            }else {synt3Number.setSelectedItem("No one");}
            synt3Number.setBounds(630, 250,80, 20);
            container.add(synt3Number);
            synthChannels.setBounds(650, 5, 150, 25);//label
            container.add(synthChannels);
//elements end

//Button apply start
            buttonApply.setBounds(725, 240, 70, 60);
            buttonApply.setBorderPainted(true);
            buttonApply.setBackground(Color.green);
            container.add(buttonApply);
            buttonApply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SystemLogic.synthStrips.clear();

                    String syn1Sel = synt1Number.getSelectedItem().toString();
                    switch (syn1Sel) {
                        case "Mono":
                            SystemLogic.synthStrips.add("Syn1");
                            break;
                        case "Stereo":
                            SystemLogic.synthStrips.add("Sy1L");
                            SystemLogic.synthStrips.add("Sy1R");
                            break;

                    }
                    String syn2Sel = synt2Number.getSelectedItem().toString();
                    switch (syn2Sel) {
                        case "Mono":
                            SystemLogic.synthStrips.add("Syn2");
                            break;
                        case "Stereo":
                            SystemLogic.synthStrips.add("Sy2L");
                            SystemLogic.synthStrips.add("Sy2R");
                            break;
                    }
                    String syn3Sel = synt3Number.getSelectedItem().toString();
                    switch (syn3Sel) {
                        case "Mono":
                            SystemLogic.synthStrips.add("Syn3");
                            break;
                        case "Stereo":
                            SystemLogic.synthStrips.add("Sy3L");
                            SystemLogic.synthStrips.add("Sy3R");
                            break;
                    }
                    buttonNext.setEnabled(true);
                    synthChannels.setText("Synth Channels: " + SystemLogic.synthStrips.size());
                    System.out.println(SystemLogic.synthStrips);
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
                    DefineInstruments.buttonSynths.setText("Synths:" + SystemLogic.synthStrips.size());
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
                        Synths synths = new Synths();
                        synths.setVisible(true);
                    }
                }
            });
        }
    @Override
    public void itemStateChanged(ItemEvent e) {
        buttonNext.setEnabled(false);
    }

}
