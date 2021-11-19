package uz.soundEngineer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Consoles extends JFrame {
    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");

    private JButton buttonBack = new JButton ("Back");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonCut32 = new JButton("Cut to 32");
    private JButton buttonCut38 = new JButton("Cut to 38");
    private JButton buttonCut56 = new JButton("Cut to 56");
    private JButton buttonCut64 = new JButton("Cut to 64");
    private JLabel fohLabel = new JLabel("FOH");
    private JLabel monLabel = new JLabel("Mon");
    private JLabel selConsLabel = new JLabel("Select console:");
    private JLabel totalLabel = new JLabel("Total");
    private JLabel inputsLabel = new JLabel("Inputs:");
    private JLabel omniInLabel = new JLabel("Omni In:");
    private JLabel outputsLabel = new JLabel("Outputs:");
    private JLabel omniOutLabel = new JLabel("Omni Out:");
    private JLabel inputsFieldLabel = new JLabel("00");
    private JLabel omniInFieldLabel = new JLabel("00");
    private JLabel outFieldLabel = new JLabel("00");
    private JLabel omniOutFieldLabel = new JLabel("00");

    private JRadioButton noFoh = new JRadioButton("No One");
    private JRadioButton pm5d = new JRadioButton("PM5D");
    private JRadioButton cl = new JRadioButton("CL5");
    private JRadioButton iLive = new JRadioButton("iLive");
    private JRadioButton rivage = new JRadioButton("Rivage");
    private JRadioButton digico = new JRadioButton("Digico");
    private JRadioButton x32 = new JRadioButton("X32");

    private JRadioButton noMon = new JRadioButton("No One");
    private JRadioButton pm5dMon = new JRadioButton("PM5D");
    private JRadioButton clMon = new JRadioButton("CL5");
    private JRadioButton iLiveMon = new JRadioButton("iLive");
    private JRadioButton rivageMon = new JRadioButton("Rivage");
    private JRadioButton digicoMon = new JRadioButton("Digico");
    private JRadioButton x32Mon = new JRadioButton("X32");


    public void terminateThisWindow(){
        this.dispose();
    }

    public Consoles() throws HeadlessException {
        super("Sound Engineer  " + SystemLogic.sceneName);
        this.setBounds(854, 480, 500, 300);
        Font font = new Font("", Font.BOLD, 30);
        Font infoFont = new Font("", Font.BOLD, 80);

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

        Container fohContainer = new Container();
        fohContainer.setLayout(new GridLayout(8, 1, 3, 10));
        fohContainer.setBounds(220, 70, 100, 250);

        Container monContainer = new Container();
        monContainer.setLayout(new GridLayout(8, 1, 3, 10));
        monContainer.setBounds(420, 70, 100, 250);

        selConsLabel.setBounds(220, 20, 300, 40);
        selConsLabel.setFont(font);
        container.add(selConsLabel);

        totalLabel.setBounds(650, 20, 150, 40);
        totalLabel.setFont(font);
        container.add(totalLabel);

        inputsLabel.setBounds(560, 80, 100, 40);
        inputsLabel.setFont(font);
        container.add(inputsLabel);

        outputsLabel.setBounds(680, 80, 150, 40);
        outputsLabel.setFont(font);
        container.add(outputsLabel);

        inputsFieldLabel.setBounds(560, 150, 95, 100);
        inputsFieldLabel.setFont(infoFont);
        inputsFieldLabel.setBackground(Color.black);
        inputsFieldLabel.setForeground(Color.yellow);
        inputsFieldLabel.setOpaque(true);
        inputsFieldLabel.setText(SystemLogic.CommonChannels().toString());
        container.add(inputsFieldLabel);

        outFieldLabel.setBounds(680, 150,95, 100);
        outFieldLabel.setFont(infoFont);
        outFieldLabel.setBackground(Color.black);
        outFieldLabel.setForeground(Color.yellow);
        outFieldLabel.setOpaque(true);
        if (SystemLogic.outStrips.size() < 10){
            outFieldLabel.setText("0"+SystemLogic.outStrips.size());
        }else {
            outFieldLabel.setText(""+SystemLogic.outStrips.size());
        }
        container.add(outFieldLabel);

        ButtonGroup fohGroup = new ButtonGroup();
        noFoh.setActionCommand("1");
        fohGroup.add(noFoh);
        pm5d.setActionCommand("2");
        fohGroup.add(pm5d);
        iLive.setActionCommand("3");
        fohGroup.add(iLive);
        cl.setActionCommand("4");
        fohGroup.add(cl);
        rivage.setActionCommand("5");
        fohGroup.add(rivage);
        x32.setActionCommand("6");
        fohGroup.add(x32);
        digico.setActionCommand("7");
        fohGroup.add(digico);

        ButtonGroup monGroup = new ButtonGroup();
        noMon.setActionCommand("1");
        monGroup.add(noMon);
        pm5dMon.setActionCommand("2");
        monGroup.add(pm5dMon);
        iLiveMon.setActionCommand("3");
        monGroup.add(iLiveMon);
        clMon.setActionCommand("4");
        monGroup.add(clMon);
        rivageMon.setActionCommand("5");
        monGroup.add(rivageMon);
        x32Mon.setActionCommand("6");
        monGroup.add(x32Mon);
        digicoMon.setActionCommand("7");
        monGroup.add(digicoMon);

//cutting logic start
        if (SystemLogic.CommonChannels() > 38){  //38
          x32.setEnabled(false);
          x32Mon.setEnabled(false);
          buttonCut38.setBackground(Color.red);
          buttonCut38.setBounds(320, 263, 100, 25);
          container.add(buttonCut38);
          buttonCut38.setText("Cut to 38");
          buttonCut38.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {

              }
          });

        }
        if (SystemLogic.CommonChannels() > 56){ //56
            pm5d.setEnabled(false);
            pm5dMon.setEnabled(false);
            buttonCut56.setBackground(Color.red);
            buttonCut56.setBounds(320, 135, 100, 25);
            container.add(buttonCut56);
            buttonCut56.setText("Cut to 56");
        }
//cutting logic end

        fohContainer.add(fohLabel);
        fohContainer.add(noFoh);
        fohContainer.add(pm5d);
        pm5d.setSelected(true);
        fohContainer.add(iLive);
        fohContainer.add(cl);
        fohContainer.add(rivage);
        fohContainer.add(x32);
        fohContainer.add(digico);

        monContainer.add(monLabel);
        monContainer.add(noMon);
        noMon.setSelected(true);
        monContainer.add(pm5dMon);
        monContainer.add(iLiveMon);
        monContainer.add(clMon);
        monContainer.add(rivageMon);
        monContainer.add(x32Mon);
        monContainer.add(digicoMon);

        container.add(fohContainer);
        container.add(monContainer);
//elements end

//button next start
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String selectedConsole = fohGroup.getSelection().getActionCommand();
            String consoleName = null;

            switch (selectedConsole){
                case "1":
                    break;
                case "2":
                    consoleName = "PM5D";
                    break;
                case "3":
                    consoleName = "iLive";
                    break;
                case "4":
                    consoleName = "CL";
                    break;
                case "5":
                    consoleName = "Rivage";
                    break;
                case "6":
                    consoleName = "X32";
                    break;
                case "7":
                    consoleName = "Digico";
                    break;
            }
                GenericMixer genericMixer = new GenericMixer();
            genericMixer.setMixerName(consoleName);
                genericMixer.populateInputs();
            }
        });
//button next end


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
        buttonNext.setBounds(540, 360, 100, 40);
        buttonNext.setBorderPainted(true);
        buttonNext.setBackground(Color.orange);
        container.add(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });
//Button next end

   }

}
