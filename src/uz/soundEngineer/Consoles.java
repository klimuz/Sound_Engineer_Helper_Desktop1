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
    private JButton buttonCut = new JButton("");
    private JLabel fohLabel = new JLabel("FOH");
    private JLabel monLabel = new JLabel("Mon");
    private JLabel selConsLabel = new JLabel("Select console:");

    private JRadioButton noFoh = new JRadioButton("No One");
    private JRadioButton pm5d = new JRadioButton("PM5D");
    private JRadioButton cl = new JRadioButton("CL");
    private JRadioButton iLive = new JRadioButton("iLive");
    private JRadioButton rivage = new JRadioButton("Rivage");
    private JRadioButton digico = new JRadioButton("Digico");
    private JRadioButton x32 = new JRadioButton("X32");

    private JRadioButton noMon = new JRadioButton("No One");
    private JRadioButton pm5dMon = new JRadioButton("PM5D");
    private JRadioButton clMon = new JRadioButton("CL");
    private JRadioButton iLiveMon = new JRadioButton("iLive");
    private JRadioButton rivageMon = new JRadioButton("Rivage");
    private JRadioButton digicoMon = new JRadioButton("Digico");
    private JRadioButton x32Mon = new JRadioButton("X32");


    public void terminateThisWindow(){
        this.dispose();
    }

    public Consoles() throws HeadlessException {
        super("Sound Engineer");
        this.setBounds(854, 480, 500, 300);
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

        ButtonGroup fohGroup = new ButtonGroup();
        noFoh.setActionCommand("1");
        fohGroup.add(noFoh);
        pm5d.setActionCommand("2");
        fohGroup.add(pm5d);
        cl.setActionCommand("3");
        fohGroup.add(cl);
        iLive.setActionCommand("4");
        fohGroup.add(iLive);
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
        clMon.setActionCommand("3");
        monGroup.add(clMon);
        iLiveMon.setActionCommand("4");
        monGroup.add(iLiveMon);
        rivageMon.setActionCommand("5");
        monGroup.add(rivageMon);
        x32Mon.setActionCommand("6");
        monGroup.add(x32Mon);
        digicoMon.setActionCommand("7");
        monGroup.add(digicoMon);

//cutting logic start
        if (SystemLogic.CommonChannels() > 38){
          x32.setEnabled(false);
          x32Mon.setEnabled(false);

        }
        if (SystemLogic.CommonChannels() > 56){
            pm5d.setEnabled(false);
            pm5dMon.setEnabled(false);
        }
//cutting logic end

        fohContainer.add(fohLabel);
        fohContainer.add(noFoh);
        fohContainer.add(pm5d);
        pm5d.setSelected(true);
        fohContainer.add(cl);
        fohContainer.add(iLive);
        fohContainer.add(rivage);
        fohContainer.add(x32);
        fohContainer.add(digico);

        monContainer.add(monLabel);
        monContainer.add(noMon);
        noMon.setSelected(true);
        monContainer.add(pm5dMon);
        monContainer.add(clMon);
        monContainer.add(iLiveMon);
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
            switch (selectedConsole){
                case "1":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D) is not available yet");
                    break;
                case "2":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (CL) is not available yet");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (iLive) is not available yet");
                    break;
                case "4":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage) is not available yet");
                    break;
                case "5":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (X32) is not available yet");
                    break;
                case "6":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico) is not available yet");
                    break;
                case "7":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D or CL) is not available yet");
                    break;
                case "8":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (PM5D or Rivage) is not available yet");
                    break;
                case "9":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (CL series) is not available yet");
                    break;
                case "10":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage or CL) is not available yet");
                    break;
                case "11":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or Rivage) is not available yet");
                    break;
                case "12":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or iLive) is not available yet");
                    break;
                case "13":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Digico or CL) is not available yet");
                    break;
                case "14":
                    JOptionPane.showMessageDialog(Consoles.this, "Selected Console (Rivage or iLive) is not available yet");
                    break;
            }
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
