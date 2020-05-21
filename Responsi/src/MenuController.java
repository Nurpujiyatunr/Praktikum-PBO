/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    
  MenuView mv;
    //JFrame frame = new JFrame();

    public MenuController(MenuView menuView) {
        this.mv = menuView;
        
        
        // input data ==========================================================
        
        
        
        
        
        
        
        // lihat data ==========================================================
        menuView.btnLihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewTiket viewtiket = new ViewTiket();
                Model model = new Model();
                Controller controller;
                controller = new Controller(model,viewtiket);
            }
        });
    
        menuView.btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewKereta viewkereta = new ViewKereta();
                Model model = new Model();
                Controller controller;
                controller = new Controller(model, viewkereta);
            }
        });
    }
}
