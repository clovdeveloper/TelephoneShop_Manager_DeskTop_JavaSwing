
package GestionnaireEvenements;


import models.Model_Telephone_Tableau;
import models.Telephone;
import View.TelephoneGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TelephoneGestionnaireEvent  implements ActionListener{
  private TelephoneGUI screen;

    public TelephoneGestionnaireEvent(TelephoneGUI scr) {
        this.screen = scr;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
        
        if (e.getActionCommand().equals("ENREGISTRER")){
            
            //Recuperation des données venant de l'intrface graphique
                String numero_de_Serie = screen.getNumero_de_Serie().getText();
                String nom = screen.getNom().getText();
                String description = screen.getModele().getText();
                String prix = screen.getPrix().getText();
                Double prixxx= Double.valueOf(prix);
                
                
                //passer les données vers le model
                Telephone phone = new Telephone(numero_de_Serie,nom, description, prixxx);
                 phone.enregistrer_Phone();
                 
                 //Afficher le meessage
                JOptionPane.showMessageDialog(null, phone.getInfo());
                //Actualiser le tableau
                screen.getjTable1().setModel(new Model_Telephone_Tableau(Telephone.tableau_des_Telephones_pour_le_modele_table()));

        }
         else if(e.getActionCommand().equals("MODIFIER")){
    
             int idselected = screen.getSelectedId();
             
             
              String numero_de_Serie = screen.getNumero_de_Serie().getText();
              String nom = screen.getNom().getText();
            String description = screen.getModele().getText();
            String prix = screen.getPrix().getText();
            Double prixxx= Double.valueOf(prix);
            Telephone telephone = new Telephone(idselected,numero_de_Serie,nom, description, prixxx);
             telephone.modifier_Phone();
            JOptionPane.showMessageDialog(null, telephone.getInfo());
            screen.getjTable1().setModel(new Model_Telephone_Tableau(Telephone.tableau_des_Telephones_pour_le_modele_table()));

    
    }
    else if(e.getActionCommand().equals("SUPPRIMER")){
       int idselected = screen.getSelectedId();
      Telephone telephone = new Telephone();
      telephone.setId_Telephone(idselected);
         telephone.supprimer_Phone();
        JOptionPane.showMessageDialog(null, telephone.getInfo());
        screen.getjTable1().setModel(new Model_Telephone_Tableau(Telephone.tableau_des_Telephones_pour_le_modele_table()));
    }
    }
    
    
}
