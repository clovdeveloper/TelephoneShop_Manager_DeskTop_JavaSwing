
package models;


import javax.swing.table.AbstractTableModel;


public class Model_Telephone_Tableau extends AbstractTableModel {

    private String[] titre = new String[]{"ID","NUMERO SERIE", "MARQUE","MODELE","PRIX"};
    
    private Telephone[][] data;

    public String getColumnName(int col) {
        return titre[col];
    }

    public Model_Telephone_Tableau(Telephone[][] platsTableau) {
        data = platsTableau;

    }

    @Override
    public int getRowCount() {
   
        if (data != null) {
            return data.length;
       } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (data != null) {
             if (columnIndex == 0 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getId_Telephone();
             }
               else  if (columnIndex == 1 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getNumero_de_serie();
            } 
             else  if (columnIndex == 2 && rowIndex >= 0) {
                return data[rowIndex][columnIndex].getMarque();
            } 
             else if (columnIndex == 3&& rowIndex >= 0) {
                return data[rowIndex][columnIndex].getModele();
            } 
             else if (columnIndex == 4 && rowIndex >= 0) {
                return  data[rowIndex][columnIndex].getPrix();
            }
          
        }
        
        return null;
    
    }
}
