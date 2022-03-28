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
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonDemo extends JPanel implements ActionListener{
    
    protected JButton b1, b2, b3;
    public ButtonDemo() {
        b1 = new JButton("Disable middle button");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");
        
        b2 = new JButton("Middle button");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("call");
        
        b3 = new JButton("Enable middle button");
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("enable");
        b3.setEnabled(false);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        b1.setToolTipText("Click this button to disable the middle button.");
        b2.setToolTipText("This middle butoon does notthing when you kick it.");
        b3.setToolTipText("Click this button to enable the middle button.");
        
        add(b1);
        add(b2);
        add(b3);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
