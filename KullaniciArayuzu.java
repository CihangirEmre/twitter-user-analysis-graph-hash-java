package prolab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KullaniciArayuzu extends JFrame {

    private JTextField textField;
    private JButton buton;

    public KullaniciArayuzu() {

        super("Kullanıcı Adı Girişi");
        setLayout(new java.awt.FlowLayout());


        textField = new JTextField("", 20);
        add(textField);


        buton = new JButton("Giriş");
        add(buton);


        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String kullaniciAdi = textField.getText();

                User secili = null;

                for (int i = 0; i < Main.kullanicilar.size(); i++) {
                    User aa = Main.kullanicilar.get(i);
                    if (aa.getUserInfo().getUsername().equals(kullaniciAdi)) {
                        secili = aa;
                        break;
                    }
                }
                Main.seciliuser=secili;
                new takiptakiçigraf().setVisible(true);
                //setVisible(false);


            }
        });


        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KullaniciArayuzu();
            }
        });
    }
}
