package uz.soundEngineer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ChooseBandType extends JFrame {

    private JMenuBar jMenuBar = new JMenuBar();
    JMenu m1 = new JMenu("File");
    JMenu m2 = new JMenu("Help");
    private JButton buttonCancel = new JButton ("Cancel");
    private JButton buttonNext = new JButton("Next");

    private JRadioButton popRock = new JRadioButton("Pop or Rock");
    private JRadioButton symphOrc = new JRadioButton("Symphonic Orchestra");
    private JRadioButton rockOrch = new JRadioButton("Rock + Orchestra");
    private JRadioButton national = new JRadioButton("National");
    private JLabel choosaBand = new JLabel("Choose Band Type:");

    public ChooseBandType() throws HeadlessException {
        super("Sound Engineer");
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
                System.exit(0);
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

        Container container1 = new Container();
        container1.setLayout(new GridLayout(5, 1, 3, 10));
        container.add(container1);
        container1.setBounds(350, 100, 150, 150);
        container1.add(choosaBand);
        choosaBand.setBackground(Color.cyan);
        //choosaBand.setT(Color.green);
        container1.add(popRock);
        popRock.setSelected(true);
        container1.add(symphOrc);
        container1.add(rockOrch);
        container1.add(national);
        container1.setBackground(Color.green);

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
//Button next end
    }


}
