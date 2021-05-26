/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thediningphilosophers;

import java.awt.*;
import java.util.*;

/**
 *
 * @author Robert Bryant, Devon Bovine, Calista Bell, Simran Bolla, and Nasr Alnasr
 */
public class Philosopher extends Thread {
    
    private Table T;
    private static final int X = 75;
    private static final int Y = 75;
    private int x;
    private int y;
    private Forks left;
    private Forks right;
    private Color color;
//    private int num = (int)(Math.random())*10000;
    
    Philosopher(Table t, int x, int y, Forks left, Forks right) {
        T = t;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
    
    public void run() {
        
        
        
        while (true) {
            try {
                color = Color.CYAN;
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
            }
            color = Color.MAGENTA;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
            eat();
        }
    }
    
    private void eat(){
        
        if(left.take(x, y))
            if(right.take(x, y)) {
                try {
                    color = Color.YELLOW;
                    Thread.sleep(2000);
                }catch (InterruptedException ex) {}
                
                right.putDown();
                left.putDown();
            }
            
            else {
                left.putDown();
            }
        }
    
        
    
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x-X/2, y-Y/2, X, Y);
    }
}

