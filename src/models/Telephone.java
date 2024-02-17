
package models;

import Base_de_données.db_Mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Telephone {
    private int id_Telephone;
    private String numero_de_serie,marque,modele,info;
    private double prix;

    @Override
    public String toString() {
        return ""+numero_de_serie+"," + marque + " ," + modele + ", prix :" + prix + "";
    }

    public Telephone(int id_Telephone, String numero_de_serie, String marque, String modele, double prix) {
        this.id_Telephone = id_Telephone;
        this.numero_de_serie = numero_de_serie;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
    }

    public Telephone(String numero_de_serie, String marque, String modele, double prix) {
        this.numero_de_serie = numero_de_serie;
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
    }

    
    
    

    public Telephone() {
        
        id_Telephone=-1;
    }

  
  public void enregistrer_Phone(){
      String requete ="insert into telephone (numero_de_serie,marque,modele,prix) values('"+this.numero_de_serie+"','"+this.marque+"','"+this.modele+"',"+this.prix+")";
         int i=db_Mysql.updateBD(requete);
         if(i>0)
         {
             this.info="Telephone est enregistre ";
         }
         else this.info="Echec d'Enregistrement ";
         
     }
  public void modifier_Phone(){
         int i=db_Mysql.updateBD("update telephone set numero_de_serie='"+numero_de_serie+"', marque='"+marque+"',modele='"+modele+"' ,prix="+prix+"  where id="+this.id_Telephone+"");
	
          if(i>0)
          {
             this.info="Le Telephone est  Modifie";
         }
          else this.info="Echec de Mofification  ";
         
     }
             public void supprimer_Phone(){
         int i=db_Mysql.updateBD("delete from telephone  where id='"+this.id_Telephone+"'");
           if(i>0)
           {
             this.info="Le Telephone  est supprime ";
         }
           else this.info="Echec de Suppression";
         
     }
    
             
                 public static Telephone[][] tableau_des_Telephones_pour_le_modele_table(){
      List<Telephone> liste_De_Telephone=null;
      
      ResultSet result=db_Mysql.interrogerBD("select * from telephone ");
    
      if(result!=null)
      { 
          liste_De_Telephone=new ArrayList();
          try {
              
              while(result.next()){
                Telephone telephone = new Telephone(result.getInt("id"),result.getString("numero_de_serie"),result.getString("marque"),
                         result.getString("modele"),  result.getFloat("prix"));
                 liste_De_Telephone.add(telephone);
                
                  
              }
          } catch (SQLException ex) {
              
          }
               
          }
      
      Telephone [][]data=null;
      
      if(liste_De_Telephone!=null && liste_De_Telephone.size()>0){
      
          data=new Telephone[liste_De_Telephone.size()][5];
          int  j=0;
          for(Telephone telephone:liste_De_Telephone){
             
              for(int i=0;i<5;i++)
                  data[j][i]=telephone;
              j++;
          
          }
          
      }
      
      
      return data;
  }  
    
                 public static void ComboBox_Pour_les_plats(javax.swing.JComboBox comboBox){
        
        ResultSet result=db_Mysql.interrogerBD("select * from telephone");
        
        comboBox.removeAllItems();
        comboBox.addItem(new Telephone());
        if(result!=null)
        {
            try {
                while(result.next())
                {
                       Telephone tel = new Telephone(result.getInt("id"),result.getString("numero_de_serie"),result.getString("marque"),
                         result.getString("modele"),  result.getFloat("prix"));
                 comboBox.addItem(tel);
                }
            } catch (SQLException ex) {
               
            }
            
        }
    }
         public static Telephone get_TelePhone_ByID(int id){
      
       ResultSet result=db_Mysql.interrogerBD("select * from telephone where id='"+id+"'");
       
       if(result!=null)
           try {
               if(result.next())
                   return new Telephone(result.getInt("id"),result.getString("numero_de_serie"),result.getString("marque"),
                         result.getString("modele"),  result.getFloat("prix"));
              
               result.close();
       } catch (SQLException ex) {
           
        
       }
          return null;
         }
    public int getId_Telephone() {
        return id_Telephone;
    }

    public void setId_Telephone(int id_Telephone) {
        this.id_Telephone = id_Telephone;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(String numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }
    
    
    
}
