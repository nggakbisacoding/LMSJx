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
import java.time.LocalDate;

public class Chair implements Serializable {
    private int chairNumber;
    private boolean chairBooked;
    private LocalDate resDate;
    private LocalDate dueDate;
    private Member member;
    
    public Chair(int chairNumber, boolean chairBooked) {
        this.chairNumber = chairNumber;
        this.chairBooked = chairBooked;
    }
    
    public Chair(int chairNumber, Member member, LocalDate resDate) {
        this.chairNumber = chairNumber;
        this.member = member;
        this.resDate = resDate;
        this.dueDate = resDate.plusDays(1);
    }
    
        public Chair(int chairNumber, boolean chairBooked, LocalDate resDate) {
        this.chairNumber = chairNumber;
        this.chairBooked = chairBooked;
        this.resDate = resDate;
        this.dueDate = resDate.plusDays(1);
    }
    
    public int getChairNumber() {
        return chairNumber;
    }
    
    public boolean getChairBooked() {
        return chairBooked;
    }
    
    public Member getMember() {
	return member;
    }
    
    public void setChairBooked(boolean chairBooked) {
        this.chairBooked = chairBooked;
    }
    
    private String isChairBooked() {
        if(this.getChairBooked()) {
            return "Yes";
        }
        return "No";
    }
    
    private Member memberBooked() {
        if(this.getChairBooked()) {
            return this.getMember();
        }
        return null;
    }
    
    @Override
    public String toString() {
        return " Chair No: " + this.getChairNumber() + ", Booked Status: " + this.isChairBooked() + ", Member Booked: " + this.memberBooked();
    }
}
