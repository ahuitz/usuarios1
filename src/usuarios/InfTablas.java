/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import Controladores.PersonaJpaController;
import Tablas.Persona;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rosario
 */
public class InfTablas extends AbstractTableModel {
    private List<Persona> persona;
    private String atributos[]={"Carné","Nombre","Apellido","Direccion","Telefono","Celular","DPI","Nacimiento","Genero","Tipo Sangre","Estado"};

    public InfTablas(List<Persona> persona) {
        this.persona = persona;
    }
    
    @Override
    public int getRowCount() {
        return persona.size();
    }

    @Override
    public int getColumnCount() {
        return atributos.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona p=this.persona.get(i);
        switch(i1){
            case 0:
                return p.getCarne();
            case 1:
                return p.getNombre();
            case 2:
                return p.getApellido();
            case 3:
                return p.getDireccion();
            case 4:
                return p.getTelefono();
            case 5:
                return p.getCelular();
            case 6: 
                return p.getDpi();
            case 7:
                return p.getFechaNac();
            case 8: 
                return p.getGenero();
            case 9:
                return p.getTipoSangreid();
            case 10:
                return p.getEstado();
        }
        return null;
    }  
    /*
    public void getValueAt(Object obj, int fila, int col) {        
        switch(col){
            case 0:
                persona.get(fila).setCarne((String) obj);
                break;
            case 1:
                persona.get(fila).setNombre((String) obj);
                break;
            case 2:
                persona.get(fila).setApellido((String) obj);
                break;
            case 3:
                persona.get(fila).setDireccion((String) obj);
                break;
            case 4:
                persona.get(fila).setTelefono((String) obj);
                break;
            case 5:
                persona.get(fila).setCelular((String) obj);
                break;
            case 6: 
                persona.get(fila).setDpi((String) obj);
                break;
            case 7:
                persona.get(fila).setFechaNac((String) obj);
                break;
            case 8: 
                persona.get(fila).setGenero((boolean) obj);
                break;
            case 9:
                persona.get(fila).setTipoSangreid((int) obj);
                break;
            case 10:
                persona.get(fila).setEstado((boolean) obj);
                break;
        }
        
    }  
*/    
}
