/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thediningphilosophers;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Robert Bryant, Devon Bovine, Calista Bell, Simran Bolla, and Nasr Alnasr */
public class Forks {
    
    public Semaphore fork = new Semaphore(1);
    public int id;
    private int x;
    private int y;
    private final Table T;
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private final int ORIGINX;
    private final int ORIGINY;
    
    
    public Forks( Table T, int x, int y) {
//        this.id = id;
        this.T = T;
        this.x = x;
        this.y = y;
        ORIGINX = x;
        ORIGINY = y;
    }
    
//    public int getId() {
//        return id;
//    }
    
    public boolean take(int x, int y) {
        boolean result = fork.tryAcquire();
        if (result) {
            clear();
            this.x = (ORIGINX + x)/2;
            this.y = (ORIGINY + y)/2;
            T.repaint();
        }
        return result;
    }
    
    public void putDown() {
        clear();
        x = ORIGINX;
        y = ORIGINY;
        T.repaint();
        fork.release();
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x-XSIZE/2, y-YSIZE/2, XSIZE, YSIZE);
    }
    
    private void clear() {
        Graphics g = T.getGraphics();
        g.setColor(Color.white);
        g.fillOval(x-XSIZE/2, y-YSIZE/2, XSIZE, YSIZE);
    }
}
