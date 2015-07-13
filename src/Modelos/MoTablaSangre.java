/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Tablas.Tiposangre;
import java.util.ArrayList;
/**
 *
 * @author Cliente
 */
public class MoTablaSangre extends AbstractTableModel{

    private  ArrayList<Tiposangre> ListTipoSangre;
    private  String[] columna = {"ID","Tipo Sangre"};
    
    public Tiposangre getTiposangre(int rowIndex){
        return  this.ListTipoSangre.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return this.ListTipoSangre.size();
    }

    @Override
    public int getColumnCount() {
        return  columna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return this.ListTipoSangre.get(rowIndex).getId();
                
            case 1:
                return  this.ListTipoSangre.get(rowIndex).getTipo();
            
            default:
              return this.ListTipoSangre.get(rowIndex);
        }
    }

    public MoTablaSangre() {
        this.ListTipoSangre = new ArrayList<>();
    }

    @Override
    public  String getColumnName(int columnIndex){
        return  this.columna[columnIndex];
    }
}

