/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import com.mysql.jdbc.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rosario
 */
public class Conexion {
    private static Conexion con;
    
/*    
    static{
        try{
            emf=Persistence.createEntityManagerFactory("JPAusuario");            
                    
        }catch(Throwable t){
            System.out.println("Error al iniciar el EntityManagerFactory"+t);
            t.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }*/
    public static EntityManagerFactory getIntance(){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("usuariosJPA");
        EntityManager em=emf.createEntityManager();
        return emf;
    }
    private Conexion(){
        
    }
            
}
