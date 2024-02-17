/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnaireEvenements;

import View.TelephoneGUI;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class Table_Telephone_gestionnaire_Event implements ListSelectionListener{
    
    TelephoneGUI screen;
   int  idselected=-1;

    public Table_Telephone_gestionnaire_Event(TelephoneGUI win) {
        this.screen = win;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
              idselected  = (int) screen.getjTable1().getValueAt(screen.getjTable1().getSelectedRow(), 0);

        } catch (Exception ex) {
        }
          String numero_de_serie = (String) screen.getjTable1().getValueAt(screen.getjTable1().getSelectedRow(), 1);
        String marque = (String) screen.getjTable1().getValueAt(screen.getjTable1().getSelectedRow(), 2);
     String modele = (String) screen.getjTable1().getValueAt(screen.getjTable1().getSelectedRow(), 3);
    Double prix =  (Double) screen.getjTable1().getValueAt(screen.getjTable1().getSelectedRow(), 4);
        

   
    screen.setSelectedId(idselected);
    //Mettre les données dans les zones de saisie
    screen.getNom().setText(marque);
    screen.getModele().setText(modele);
    screen.getNumero_de_Serie().setText(numero_de_serie);
        try {
             screen.getPrix().setText(prix.toString());
        } catch (Exception ex) {
        }
   
    
    }
}
