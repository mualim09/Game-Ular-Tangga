import javax.swing.*;

public class Pertanyaan {

    String jwb;

    public void tanya1(){
        jwb  = JOptionPane.showInputDialog("Siapakah nama saudara kembar Nabi Yakub ?");
    }

    public void tanya2(){
        jwb = JOptionPane.showInputDialog("Siapakah Musuh terbesar Nabi Musa ?");
    }

    public void tanya3(){
        jwb = JOptionPane.showInputDialog("Pada masanya Nabi Zulkifli dinobatkan sebagai raja bagi kaum ?");
    }

    public void tanya4(){
        jwb = JOptionPane.showInputDialog("Siapakah ayah Nabi Ishaq ?");
    }

    public void tanya5(){
        jwb = JOptionPane.showInputDialog("Nama kaum nabi syu'aib ?");
    }

    public boolean periksa(int soal){
        if(soal==1){
            if(jwb.equalsIgnoreCase("ishu")){
                JOptionPane.showMessageDialog(null, "Anda Benar");

                return true;
            }
        }
        else if(soal==2){
            if(jwb.equalsIgnoreCase("firaun")){
                JOptionPane.showMessageDialog(null, "Anda Benar");

                return true;
            }
        }
        else if(soal==3){
            if(jwb.equalsIgnoreCase("kaum room")){
                JOptionPane.showMessageDialog(null, "Anda Benar");

                return true;
            }
        }
        else if(soal==4){
            if(jwb.equalsIgnoreCase("ibrahim as")){
                JOptionPane.showMessageDialog(null, "Anda Benar");

                return true;
            }
        }
        else if(soal==5){
            if(jwb.equalsIgnoreCase("kaum madyan")){
                JOptionPane.showMessageDialog(null, "Anda Benar");

                return true;
            }
        }
        return false;
    } 
}