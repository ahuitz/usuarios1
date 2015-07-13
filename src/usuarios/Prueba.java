/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import Controladores.PersonaJpaController;
import Controladores.TiposangreJpaController;
import Tablas.Persona;
import Tablas.Tiposangre;
import java.util.List;

/**
 *
 * @author Rosario
 */
public class Prueba {
 
    public void insertarPersona(Persona persona,String tipo){        
        //int id;
        TiposangreJpaController ctrlSangre=new TiposangreJpaController(Conexion.getIntance());
        List<Tiposangre> sangre=ctrlSangre.findTiposangreEntities();
        for(Tiposangre t:sangre){
            if(t.getTipo().equals(tipo)){
               persona.setTipoSangreid(t.getId());
            }
        }
        PersonaJpaController ctrlPersona=new PersonaJpaController(Conexion.getIntance());
        ctrlPersona.create(persona);
        
        
    }
}
