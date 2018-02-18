import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acakdadu {
    private int sisi;
    
    JLabel tampilkan = new JLabel(new ImageIcon("1.png"));
        
    public int getSisi(){
        return sisi;
    }
    
    Timer acak = new Timer(60, new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    sisi = (int) (Math.random()*6)+1;
                    tampilkan.setIcon(new ImageIcon(sisi+".png"));
          }});
                
    public void acak(){
        acak.start();
    }
    
    public void stop(){
        acak.stop();
    }
}