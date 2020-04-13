/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasprak_6;

/**
 *
 * @author Asus
 */
class MVC_Praktikum {
    View viewPraktikum = new View();
    Model modelPraktikum = new Model();
    Controller controllerPraktikum = new Controller(modelPraktikum, viewPraktikum);
}
