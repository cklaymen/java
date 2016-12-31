/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ryszard
 * @version 1.1
 */
public class ChristmasTreeSizeException extends Exception {
    ChristmasTreeSizeException () {
        
    }
    
    ChristmasTreeSizeException (String message) {
        super(message);
    }
}
