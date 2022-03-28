/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangwords;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ngoxu
 */


class AnotherClass implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("From Another Class!");
	}
}

class MyClass implements ActionListener
{
	MyClass(){}
	
	public void actionPerformed(ActionEvent e)
	{
            String strActionCommand = e.getActionCommand();
            if (strActionCommand.equals("OK"))
            {
        Toolkit.getDefaultToolkit().beep();
        System.out.println("BEEP");
                }
        else
        	System.out.println("Hello!");
	}
}

public class StartPage extends JPanel {
    
    JButton button;
    
    public StartPage () {
        super(new BorderLayout());
        
        button = new JButton("OK");
        button.setPreferredSize(new Dimension(200, 80));
        add(button, BorderLayout.NORTH);
        button.setActionCommand("OK");
        
        MyClass mc = new MyClass();
        button.addActionListener(mc);
        button.addActionListener(new AnotherClass());
        
        JButton button2 = new JButton("Hello");
        add(button2,BorderLayout.NORTH);
        button2.setActionCommand("HELLO");
        
        button2.addActionListener(mc);
    }
    
    public static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Beeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new StartPage();
        
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
