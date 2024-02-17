/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionnaireEvenements;


import models.Facture;
import models.Model_Facture_Tableau;
import models.Telephone;
import View.FactureUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class FactureGE  implements ActionListener{
  private FactureUI screen;

    public FactureGE(FactureUI screen) {
        this.screen = screen;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
   
        String nom = screen.getNom().getText();
        String telephone = screen.getTelephone().getText();
        
        Telephone phone = FactureUI.getSelectedPhone();
     Facture facture = new Facture(nom, telephone, phone);
     facture.enregistrer_Facture();
        JOptionPane.showMessageDialog(null, facture.getInfo());
        screen.getjTable1().setModel(new Model_Facture_Tableau(Facture.tableau_des_Factures()));
        
   
    }
    
    
}
