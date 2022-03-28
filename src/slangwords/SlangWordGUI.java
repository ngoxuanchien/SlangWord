/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangwords;

/**
 *
 * @author ngoxu
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class MyClass implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("Ok");
    }
    
}


public class SlangWordGUI {
    
    public static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        JFrame frame = new JFrame("Slang Word");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ButtonDemo  newContentPane = new ButtonDemo();
        
        newContentPane.setOpaque(true);
        
        frame.setContentPane(newContentPane);
        
        frame.pack();
        frame.setVisible(true);
    }
}
