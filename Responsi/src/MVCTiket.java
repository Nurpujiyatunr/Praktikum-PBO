/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nurpujiyatun
 */
public class MVCTiket {
    MenuView menuview = new MenuView();
    ViewTiket viewTiket = new ViewTiket();
    ViewKereta viewKereta = new ViewKereta();
    Model model = new Model();
    Controller controller = new Controller ( model , viewTiket, viewKereta);
            
           

}
