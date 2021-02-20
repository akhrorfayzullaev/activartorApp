package UI;


import Ecryption.EncryptionClass;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivatorGUI {
    public static void main(String[] args) {
        new MainFrame();
    }
}

class MainFrame extends JFrame implements ActionListener {
    private JTextField blockOne, blockTwo, blockThree, blockFour, inputKey;
    private JButton applyButton;
    private final JLabel emptyLabel = new JLabel(" ");
    private final JLabel inputLabel = new JLabel("Input key :");
    private EncryptionClass encryptionClass;
    private String finalCode;
    private String finalCodePro;
    private ImageIcon imageIcon, backIcon;
    private JLabel hypenLabel1;




    public MainFrame() {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        setTitle("LIS Activator");
        setFont(font);
        setSize(600, 400);
        setLocation(200, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("src/img/icon.png").getScaledInstance(15, 15, Image.SCALE_SMOOTH));
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        initialize();
        setBackground(Color.CYAN);
        setSymbolsTo(blockOne);
        setSymbolsTo(blockTwo);
        setSymbolsTo(blockThree);
        setSymbolsTo(blockFour);
        finalCode = encryptionClass.decryptionInfo(blockOne.getText(), blockTwo.getText(), blockThree.getText(), blockFour.getText());
        finalCodePro = encryptionClass.decryptionInfoPro(blockOne.getText(),blockTwo.getText(),blockThree.getText(),blockFour.getText());

        setVisible(true);
        System.out.println("Activation KEY : " + finalCode);       //<<<------- This is Activation Key -------//
        System.out.println("Activation KEY pro : "+finalCodePro);  //<<<------- This is Activation Key PRO ----//
    }

    public void initialize() {
        encryptionClass = new EncryptionClass();

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 25);
        inputLabel.setFont(font);
        blockOne = new JTextField(4);
        blockOne.setPreferredSize(new Dimension(500, 40));
        blockOne.setColumns(4);
        blockOne.setFont(font);
        blockOne.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        blockOne.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        blockOne.setEditable(false);


        blockTwo = new JTextField(4);
        blockTwo.setPreferredSize(new Dimension(500, 40));
        blockTwo.setColumns(4);
        blockTwo.setFont(font);
        blockTwo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        blockTwo.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        blockTwo.setEditable(false);


        blockThree = new JTextField(4);
        blockThree.setPreferredSize(new Dimension(500, 40));
        blockThree.setColumns(4);
        blockThree.setFont(font);
        blockThree.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        blockThree.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        blockThree.setEditable(false);

        blockFour = new JTextField(4);
        blockFour.setPreferredSize(new Dimension(500, 40));
        blockFour.setColumns(4);
        blockFour.setFont(font);
        blockFour.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        blockFour.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        blockFour.setEditable(false);

        inputKey = new JTextField();
        inputKey.setPreferredSize(new Dimension(300, 30));
        inputKey.setFont(font);
        inputKey.setColumns(12);
        inputKey.setBorder(new LineBorder(Color.DARK_GRAY, 2));

        applyButton = new JButton("check");
        applyButton.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        applyButton.setForeground(Color.white);
        applyButton.setBackground(Color.decode("#BE0000"));
        applyButton.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        applyButton.setPreferredSize(new Dimension(75, 30));
        applyButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        applyButton.setFocusPainted(false);

        applyButton.addActionListener(this);

        Font hypenFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
        hypenLabel1 = new JLabel("-");
        JLabel hypenLabel2 = new JLabel("-");
        JLabel hypenLabel3 = new JLabel("-");
        hypenLabel1.setFont(hypenFont);
        hypenLabel2.setFont(hypenFont);
        hypenLabel3.setFont(hypenFont);

        JPanel blockPanel = new JPanel(new FlowLayout());
        blockPanel.add(blockOne);
        blockPanel.add(hypenLabel1);
        blockPanel.add(blockTwo);
        blockPanel.add(hypenLabel2);
        blockPanel.add(blockThree);
        blockPanel.add(hypenLabel3);
        blockPanel.add(blockFour);

        JPanel northPanel = new JPanel(new GridLayout(3, 1));
        JPanel p = new JPanel(new FlowLayout());
        p.add(emptyLabel);
        northPanel.add(p);
        northPanel.add(p);
        northPanel.add(blockPanel);

        JPanel itemsPanel = new JPanel(new FlowLayout());
        itemsPanel.add(inputLabel);
        itemsPanel.add(inputKey);
        itemsPanel.add(applyButton);    //-------------

        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        southPanel.add(itemsPanel);
        southPanel.add(emptyLabel);

        /*JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.add(northPanel,BorderLayout.NORTH);
        finalPanel.add(southPanel,BorderLayout.SOUTH);*/

        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);


    }

    public JTextField setSymbolsTo(JTextField textField) {
        List<String> character = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char i = 'A'; i <= 'Z'; i++) {
            character.add(String.valueOf(i));
        }
        for (int i = 0; i < 10; i++) {
            character.add(String.valueOf(i));
        }
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * character.size());
            stringBuilder.append(character.get(random));
        }
        textField.setText(stringBuilder.toString());

        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(applyButton)) {
            if (inputKey.getText().isEmpty()) {

            } else {
                if (inputKey.getText().equals(finalCode)) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(null, "LIS installed successfully");
                }else if (inputKey.getText().equals(finalCodePro)){
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(null,"LIS PRO version installed successfully");
                }else   {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Incorrect Key");
                }
            }
        }

    }
}