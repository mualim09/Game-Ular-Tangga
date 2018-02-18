import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ROOM2 extends JFrame {
    private JPanel contentPane;
    private JTextField player2;
    private JTextField player1;

    JButton btnNewButton = new JButton();
    JButton roll1 = new JButton();
    JButton stop1 = new JButton();
    JButton ok1 = new JButton();
    JButton roll2 = new JButton();
    JButton stop2 = new JButton();
    JButton ok2 = new JButton();

    acakdadu dadu = new acakdadu();
    pemain main1 = new pemain("nama");
    pemain main2 = new pemain("nama");
    Pertanyaan tanyakan = new Pertanyaan();

    JLabel pemain1 = new JLabel();
    JLabel pemain2 = new JLabel();

    private int x = 468;
    private int y = 379;

    public ROOM2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 666, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton.setIcon(new ImageIcon("menugame.png"));
        btnNewButton.setBounds(487, 563, 153, 36);
        contentPane.add(btnNewButton);

        player1 = new JTextField();
        player1.setColumns(10);
        player1.setBounds(290, 569, 86, 20);
        contentPane.add(player1);

        player2 = new JTextField();
        player2.setBounds(92, 569, 86, 20);
        contentPane.add(player2);
        player2.setColumns(10);

        roll1.setIcon(new ImageIcon("roll.png"));
        roll1.setBounds(383, 484, 86, 26);
        contentPane.add(roll1);
        roll1.setEnabled(false);

        stop1.setIcon(new ImageIcon("stop.png"));
        stop1.setBounds(383, 526, 86, 26);
        contentPane.add(stop1);
        stop1.setEnabled(false);

        ok1.setIcon(new ImageIcon("ok.png"));
        ok1.setBounds(408, 563, 61, 37);
        contentPane.add(ok1);

        roll2.setIcon(new ImageIcon("roll.png"));
        roll2.setBounds(10, 484, 86, 26);
        contentPane.add(roll2);
        roll2.setEnabled(false);

        stop2.setIcon(new ImageIcon("stop.png"));
        stop2.setBounds(10, 526, 86, 26);
        contentPane.add(stop2);
        stop2.setEnabled(false);

        ok2.setIcon(new ImageIcon("ok.png"));
        ok2.setBounds(10, 562, 61, 37);
        contentPane.add(ok2);

        JLabel labelplay1 = new JLabel();
        labelplay1.setBounds(290, 563, 86, 26);
        labelplay1.setForeground(Color.WHITE);
        contentPane.add(labelplay1);

        JLabel labelplay2 = new JLabel();
        labelplay2.setBounds(92, 563, 86, 26);
        labelplay2.setForeground(Color.WHITE);
        contentPane.add(labelplay2);

        dadu.tampilkan.setBounds(217, 495, 43, 45);
        contentPane.add(dadu.tampilkan);

        pemain2.setIcon(new ImageIcon("player2.gif"));
        pemain2.setBounds(x+98, y, 70, 76);
        contentPane.add(pemain2);

        pemain1.setIcon(new ImageIcon("player1.gif"));
        pemain1.setBounds(x, y, 52, 76);
        contentPane.add(pemain1);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon("background2.jpg"));
        background.setBounds(0, 0, 654, 611);
        contentPane.add(background);

        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    leafAndBranch2 utama = new leafAndBranch2();
                    utama.setVisible(true);
                    dispose();
                }
            });

        roll1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dadu.acak();
                    roll1.setEnabled(false);
                    stop1.setEnabled(true);
                }
            });

        stop1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dadu.stop();
                    main1.setNilai(dadu.getSisi());
                    if(main1.getNilai() > 25){
                        main1.setNilai(-dadu.getSisi());
                    }
                    posisi(1,main1.getNilai());
                    tranfor(1, main1.getNilai());
                    posisi(1, main1.getNilai());
                    sekak(1, main1.getNilai());
                    roll2.setEnabled(true);
                    stop2.setEnabled(false);
                    roll1.setEnabled(false);
                    stop1.setEnabled(false);

                    if(main1.getNilai() == 25){//syarat/kondisi untuk menang
                        roll2.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Selamat Anda MENANG " +labelplay1.getText());
                    }
                }
            });

        ok1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    player1.setVisible(false);
                    labelplay1.setText(player1.getText());
                    labelplay1.setVisible(true);
                    if(!labelplay1.getText().isEmpty() && !labelplay2.getText().isEmpty()){
                        roll1.setEnabled(true);
                    }
                }
            });

        roll2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dadu.acak();
                    roll2.setEnabled(false);
                    stop2.setEnabled(true);
                }
            });

        stop2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dadu.stop();
                    main2.setNilai(dadu.getSisi());

                    if(main2.getNilai() > 25){//kondisi/syarat ketika dadu melebihi angka untuk menang maka akan di set nilai dadu kembali ke koordinatnya
                        main2.setNilai(-dadu.getSisi());
                    }

                    posisi(2,main2.getNilai());
                    tranfor(2, main2.getNilai());
                    posisi(2, main2.getNilai());
                    sekak(2, main2.getNilai());
                    roll1.setEnabled(true);
                    stop1.setEnabled(false);
                    roll2.setEnabled(false);
                    stop2.setEnabled(false);

                    if(main2.getNilai() == 25){//syarat/kondisi untuk menang
                        roll1.setEnabled(false);
                        JOptionPane.showMessageDialog(null,"Selamat Anda MENANG " +labelplay2.getText());
                    }
                }
            });

        ok2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    player2.setVisible(false);
                    labelplay2.setText(player2.getText());
                    labelplay2.setVisible(true);
                    if(!labelplay1.getText().isEmpty() && !labelplay2.getText().isEmpty()){
                        roll1.setEnabled(true);
                    }
                }
            });
    }
    
    //set posisi pemain setelah acak dadu selesai
    public void posisi(int main, int pos){
        int koorX = pos % 5;
        int koorY = pos / 5;
        if(koorX == 0){
            koorX=5;
            koorY=koorY-1;
        }
        if(koorY % 2 != 0){
            koorX = 6-koorX;
        }

        if(main==1){
            koorX = 468-(koorX * 84);
            koorY = 379-(koorY * 90);
            pemain1.setLocation(koorX, koorY);
        }
        else{
            koorX = 468-(koorX * 84);
            koorY = 379-(koorY * 90);
            pemain2.setLocation(koorX, koorY);
        }
    }
    
    //kondisi ketika koordinat pemain sama dan aturannya pemain yang datang akan mengeluarkan pemain sebelumnya ke kotak 1
    public void sekak(int main, int pos){    
        if(main == 1){
            if(main1.getNilai()== main2.getNilai()){
                main2.setNilai(-(main2.getNilai()-1));
                posisi(2, main2.getNilai());
            }
        }
        else{
            if(main1.getNilai()== main2.getNilai()){
                main1.setNilai(-(main1.getNilai()-1));
                posisi(1, main1.getNilai());
            }
        }
    }
    
    //method untuk mengkondisikan atau syarat ketika pemain bertemu dengan salah satu atribut dalam papan main sperti daun dan ranting pohon
    public void tranfor(int main, int pos){
        //kondisi bermain pemain 1 
        if(main == 1){
            if(main1.getNilai() == 3){
                main1.setNilai(5);

            }
            else if(main1.getNilai() == 10){
                tanyakan.tanya1();
                if(tanyakan.periksa(1)){
                    main1.setNilai(9);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                }
            }

            else if(main1.getNilai() == 14){
                tanyakan.tanya2();
                if(tanyakan.periksa(2)){
                    main1.setNilai(4);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                }
            }

            else if(main1.getNilai() == 16){
                tanyakan.tanya3();
                if(tanyakan.periksa(3)){
                    main1.setNilai(8);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                    main1.setNilai(-15);

                }

            }

            if(main1.getNilai() == 9){
                tanyakan.tanya4();
                if(!tanyakan.periksa(3)){
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                    main1.setNilai(-8);

                }
            }

            else if(main1.getNilai() == 6){
                main1.setNilai(-1);

            }

            else if(main1.getNilai() == 13){
                main1.setNilai(-6);

            }

            else if(main1.getNilai() == 17){
                main1.setNilai(-2);

            }

            else if(main1.getNilai() == 22){
                main1.setNilai(-2);

            }
        }

        //kondisi bermain pemain2
        else{
            if(main2.getNilai() == 3){
                main2.setNilai(5);
            }
            else if(main2.getNilai() == 10){
                tanyakan.tanya1();
                if(tanyakan.periksa(1)){
                    main2.setNilai(9);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                }

            }

            else if(main2.getNilai() == 14){
                tanyakan.tanya2();
                if(tanyakan.periksa(2)){
                    main2.setNilai(4);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                }

            }

            else if(main2.getNilai() == 16){
                tanyakan.tanya3();
                if(tanyakan.periksa(3)){
                    main2.setNilai(8);

                }
                else{
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                    main2.setNilai(-15);

                }
            }

            if(main2.getNilai() == 9){
                tanyakan.tanya4();
                if(!tanyakan.periksa(3)){
                    JOptionPane.showMessageDialog(null, "Anda Salah");
                    main1.setNilai(-8);

                }

            }

            else if(main2.getNilai() == 6){
                main2.setNilai(-1);

            }

            else if(main2.getNilai() == 13){
                main2.setNilai(-6);

            }

            else if(main2.getNilai() == 17){
                main2.setNilai(-2);

            }

            else if(main2.getNilai() == 22){
                main2.setNilai(-2);

            }   
        }    
    }
}
