/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnaireEvenements;

import models.Telephone;
import View.FactureUI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ComboboxGE  implements ItemListener{
    
    FactureUI screen;

    public ComboboxGE(FactureUI win) {
        this.screen = win;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      
    
    Telephone p = (Telephone) e.getItem();
    screen.setSelectedPhone(p);
       JOptionPane.showMessageDialog(null, "ok");
    
    }   
}
