package clases;
import Controladores.PersonaJpaController;
import javax.persistence.EntityManagerFactory;

public class Creador extends PersonaJpaController{
    
    public TipoPersona persona;    

    public Creador(EntityManagerFactory emf) {
        super(emf);
    }

    /*public Creador(EntityManagerFactory emf) {
        super(emf);
    }*/
    
    public void crearPersona(){
        
    }
    
    

    
    

}
