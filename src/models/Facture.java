
package models;

import Base_de_données.db_Mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Facture {
    private int id_Facture;
    private String nom_Client,telephone,info;
        private Telephone idTELEPHONE;

    public Facture(int id_Facture, String nom_Client, String telephone, Telephone idTELEPHONE) {
        this.id_Facture = id_Facture;
        this.nom_Client = nom_Client;
        this.telephone = telephone;
        this.idTELEPHONE = idTELEPHONE;
    }

    public Facture(String nom_Client, String telephone, Telephone idPlat) {
        this.nom_Client = nom_Client;
        this.telephone = telephone;
        this.idTELEPHONE = idPlat;
    }

      public void enregistrer_Facture(){
         int i=db_Mysql.updateBD("insert into facture (nom_client,telephone,id_Phone) values('"+this.nom_Client+"','"+this.telephone+"',"+this.idTELEPHONE.getId_Telephone()+")");
         if(i>0)
         {
             this.info="FActure est enregistre ";
         }
         else this.info="Echec d'Enregistrement ";
         
     }

                   public static Facture[][] tableau_des_Factures(){
      List<Facture> listedeFactures=null;
      
      ResultSet result=db_Mysql.interrogerBD("select * from facture ");
    
      if(result!=null)
      { 
          listedeFactures=new ArrayList();
          try {
              
              while(result.next()){
                Facture facture = new Facture(result.getInt("id_Facture"),result.getString("nom_client"),
                         result.getString("telephone"), Telephone.get_TelePhone_ByID(result.getInt("id_Phone")));
                 listedeFactures.add(facture);
                
                  
              }
          } catch (SQLException ex) {
             
          }
               
          }
      
      Facture [][]donnees=null;
      
      if(listedeFactures!=null && listedeFactures.size()>0){
      
          donnees=new Facture[listedeFactures.size()][4];
          int  j=0;
          for(Facture fa:listedeFactures){
             
              for(int i=0;i<4;i++)
                  donnees[j][i]=fa;
              j++;
          
          }
          
      }
      return donnees;
  }  
    
    
    public int getId_Facture() {
        return id_Facture;
    }

    public String getNom_Client() {
        return nom_Client;
    }

    public void setNom_Client(String nom_Client) {
        this.nom_Client = nom_Client;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Telephone getIdTELEPHONE() {
        return idTELEPHONE;
    }

    public void setIdTELEPHONE(Telephone idTELEPHONE) {
        this.idTELEPHONE = idTELEPHONE;
    }

    public void setId_Facture(int id_Facture) {
        this.id_Facture = id_Facture;
    }
    
    
}
