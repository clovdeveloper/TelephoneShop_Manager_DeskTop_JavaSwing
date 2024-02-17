
package models;


import javax.swing.table.AbstractTableModel;


public class Model_Facture_Tableau extends AbstractTableModel {

    private String[] titre = new String[]{"ID", "NOM","TEL CLIENT","TELEPHONE"};
    
    private Facture[][] donnees;

    public String getColumnName(int col) {
        return titre[col];
    }

    public Model_Facture_Tableau(Facture[][] FactureTableau) {
        donnees = FactureTableau;

    }

    @Override
    public int getRowCount() {
   
        if (donnees != null) {
            return donnees.length;
       } else {
            return -1;
        }
    }

    @Override
    public int getColumnCount() {
     
        if (titre == null) {
            return -1;
        }
        return titre.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        if (donnees != null) {
             if (columnIndex == 0 && rowIndex >= 0) {
                return donnees[rowIndex][columnIndex].getId_Facture();
             }
             else  if (columnIndex == 1 && rowIndex >= 0) {
                return donnees[rowIndex][columnIndex].getNom_Client();
            } 
             else if (columnIndex == 2&& rowIndex >= 0) {
                return donnees[rowIndex][columnIndex].getTelephone();
            } 
             else if (columnIndex == 3 && rowIndex >= 0) {
                return donnees[rowIndex][columnIndex].getIdTELEPHONE();
            }
          
        }
        
        return null;
    
    }
}
