/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import Tablas.Tiposangre;
/**
 *
 * @author Cliente
 */
public class MoTablaSangre extends AbstractTableModel{

    private List <Tiposangre> tiposangre;
    private String columnas[] = {"ID","Tipo"};
    
    public MoTablaSangre(List<Tiposangre> tiposangre){
        this.tiposangre = tiposangre;
    }
    @Override
    public int getRowCount() {
        return tiposangre.size();
    }

    @Override
    public int getColumnCount() {
        return  columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tiposangre tsangre = this.tiposangre.get(rowIndex);
        switch(columnIndex){
            case 0:
                return  tsangre.getId();
            case 1:
                return tsangre.getTipo();
        }
        return null;
    }
    public String getColumnName(int i){
        return  null;
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return  true;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        
        switch (columnIndex)
        {
            case 0:
                tiposangre.get(rowIndex).setId((int) aValue);
                break;
            case 1:
                tiposangre.get(rowIndex).setTipo((String) aValue);
                break;
        }}
}

