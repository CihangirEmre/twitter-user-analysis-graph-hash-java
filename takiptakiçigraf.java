package prolab;

import javax.swing.*;
import java.awt.event.*;

public class takiptakiçigraf extends JFrame{
    DefaultListModel AA1= new DefaultListModel();
    DefaultListModel AA2 = new DefaultListModel<>();
    private JPanel takiptakipci;
    private JList Text1;
    private JList Text2;
    private JButton button1;
    private JScrollPane scrollPane;
    private JScrollPane scrollPane2;


    public takiptakiçigraf(){
        add(takiptakipci);
        setSize(800,800);
        setTitle("Takip-Takipçi Listesi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Text1.setModel(AA1);
        Text2.setModel(AA2);


        scrollPane.setViewportView(Text1);

        scrollPane2.setViewportView(Text2);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<Main.seciliuser.getUserInfo().getFollowingCount();i++){
                    AA1.addElement(Main.seciliuser.getFollowerRelationship().getFollowing().get(i));
                }
                for(int i=0;i<Main.seciliuser.getUserInfo().getFollowersCount();i++){
                    AA2.addElement(Main.seciliuser.getFollowerRelationship().getFollowers().get(i));

                }
            }
        });
    }

    public  static void main(String args[]){
        takiptakiçigraf takip = new takiptakiçigraf();
        takip.setVisible(true);
    }



}
