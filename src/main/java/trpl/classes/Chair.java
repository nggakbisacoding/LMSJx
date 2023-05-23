/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trpl.classes;

/**
 *
 * @author Fandead
 */

import java.io.Serializable;

public class Chair implements Serializable {
    private int chairNumber;
    
    public Chair(int chairNumber) {
        this.chairNumber = chairNumber;
    }
    
    public int getChairNumber() {
        return chairNumber;
    }
    
    @Override
    public String toString() {
        return " " + getChairNumber() + " ";
    }
}
