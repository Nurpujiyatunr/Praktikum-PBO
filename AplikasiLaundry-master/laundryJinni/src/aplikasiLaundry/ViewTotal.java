/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiLaundry;

import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ViewTotal extends JFrame {
    
    JLabel lBayar = new JLabel("Total bayar  ");
  //  JLabel lTbayar = new JLabel(String.valueOf(dataTotal.HitungTotalbayar()));
    
    public ViewTotal(){
        setTitle("Laundry Kuyyy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(655, 650);
        
        
        add(lBayar);
        lBayar.setBounds(330, 120, 90, 20);
        
      //  add(lTbayar);
      //  lTbayar.setBounds(420, 120, 60, 20);
    }
    
}
