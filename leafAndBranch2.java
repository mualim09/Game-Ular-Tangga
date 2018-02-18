import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class leafAndBranch2 extends JFrame {
    private JPanel contentPane;
    
    JLabel start = new JLabel();
    JLabel help = new JLabel();
    JLabel exit = new JLabel();
    music playMusic = new music();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        leafAndBranch2 frame = new leafAndBranch2();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public leafAndBranch2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 653, 639);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        playMusic.musicStartGame();
        
        start.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    try {
                        ROOM2 frame = new ROOM2();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                    setVisible(false);
                }
            });
        start.setIcon(new ImageIcon("start.png"));
        start.setBounds(392, 271, 127, 44);
        contentPane.add(start);

        
        help.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    JOptionPane.showMessageDialog(null, "gak ada petunjuk mainkan saja");
                }
            });
        help.setIcon(new ImageIcon("help.png"));
        help.setBounds(294, 394, 127, 44);
        contentPane.add(help);

        
        exit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent arg0) {
                    int pilihan = JOptionPane.showConfirmDialog(null,"Apakah kamu yakin ?");
                    if(pilihan == JOptionPane.YES_OPTION){
                        System.exit(0);
                        playMusic.stopMusic();
                        return;                     
                    }
                }
            });
        exit.setIcon(new ImageIcon("exit.png"));
        exit.setBounds(178, 514, 127, 44);
        contentPane.add(exit);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("background1.jpg"));
        label.setBounds(0, 0, 637, 600);
        contentPane.add(label);
    }
}
