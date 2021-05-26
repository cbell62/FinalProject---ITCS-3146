/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thediningphilosophers;

import javax.swing.*;

/**
 *
 * @author Robert Bryant, Devon Bovine, Calista Bell, Simran Bolla, and Nasr Alnasr
 */
public class TheDiningPhilosophers {
    public static final int KITCHEN_SIZE = 600;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Forks[] fork = new Forks[5];
        Philosopher[] philosopher = new Philosopher[5];
        
        JFrame f = new JFrame("The Dining Philosophers");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Table t = new Table(KITCHEN_SIZE);
        new UI(f, t);
        f.pack();
        f.setVisible(true);

//        for (int i = 0; i < fork.length; i++) {
//            fork[i] = new Forks(i);
//        }
//
//        for (int i = 0; i < philosopher.length; i++) {
//
//            if (i != philosopher.length - 1) {
//                philosopher[i] = new Philosopher(fork[i], fork[i + 1]);
//                philosopher[i].start();
//            } else {
//                philosopher[i] = new Philosopher(fork[0], fork[i]);
//                philosopher[i].start();
//            }
//        }
//
    }
}

class UI extends JPanel {
    private final Table t;
    
    public UI(RootPaneContainer pane, Table t) {
        this.t = t;
        add(this.t);
        pane.getContentPane().add(this);
    }
}
