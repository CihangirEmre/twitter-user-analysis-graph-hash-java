package prolab;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class firstFrame extends JFrame{
    private JPanel fFrame;
    private JButton takipTakipçiListesiButton;
    private JButton ortakİlgiAlanıListesiButton;
    private JButton hashtagKelimeTrendleriButton;


    private ArrayList<String> kullanıcıListesi1;

    public ArrayList<String> getKullanıcıListesi1() {
        return kullanıcıListesi1;
    }

    public void setKullanıcıListesi1(ArrayList<String> kullanıcıListesi1) {
        this.kullanıcıListesi1 = kullanıcıListesi1;
    }

    public firstFrame(){
        add(fFrame);
        setSize(600,400);
        setTitle("Seçenekler");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        takipTakipçiListesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KullaniciArayuzu().setVisible(true);
            }
        });
    }
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                firstFrame f = new firstFrame();
                f.setVisible(true);

            }
        });
    }



}
