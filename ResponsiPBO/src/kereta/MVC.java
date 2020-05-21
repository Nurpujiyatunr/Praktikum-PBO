/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kereta;

/**
 *
 * @author Nurpujiyatun
 */
public class MVC {
    Model model = new Model();
    View view = new View();
    Controller controller = new Controller(model, view);
}