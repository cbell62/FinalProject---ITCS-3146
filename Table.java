/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thediningphilosophers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Robert Bryant, Devon Bovine, Calista Bell, Simran Bolla, and Nasr Alnasr
 */
class Table extends JPanel {
    private Forks[] forks;
    private Philosopher[] philosophers;
    
    public void paint (Graphics g) {
        super.paint(g);
        
        for (int i = 0; i < 5; i++) {
            forks[i].draw(g);
            philosophers[i].draw(g);
            
        }
        
        g.setColor(Color.black);
        g.drawString("Cyan = Thinking | Magenta = Waiting | Yellow = Eating", 2, 13);
        g.setColor(Color.GREEN);
        g.fillRect(225, 225, 150, 150);       
    }
    
    public Table(int size) {
        forks = new Forks[5];
        philosophers = new Philosopher[5];
        setPreferredSize(new Dimension(size, size));
        
        for (int i = 0; i < 5; i++) {
            double angle = Math.PI/2 + 2*Math.PI/5*(i-0.5);
            forks[i] = new Forks(this,
                (int) (size/2.0 + size/6.0 * Math.cos(angle)),
                (int) (size/2.0 - size/6.0 * Math.sin(angle)));
        }
        
        for (int i = 0; i < 5; i++) {
            double angle = Math.PI/2 + 2*Math.PI/5*i;
            philosophers[i] = new Philosopher(this,
                (int) (size/2.0 + size/3.0 * Math.cos(angle)),
                (int) (size/2.0 - size/3.0 * Math.sin(angle)),
                forks[i], forks[ (i+1) % 5]);
            philosophers[i].start();
        }
    }
}
