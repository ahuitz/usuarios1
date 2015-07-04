/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rosario
 */
@Entity
@Table(catalog = "permisosus", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tacciones.findAll", query = "SELECT t FROM Tacciones t"),
    @NamedQuery(name = "Tacciones.findById", query = "SELECT t FROM Tacciones t WHERE t.id = :id"),
    @NamedQuery(name = "Tacciones.findByAsignar", query = "SELECT t FROM Tacciones t WHERE t.asignar = :asignar"),
    @NamedQuery(name = "Tacciones.findByConfigurar", query = "SELECT t FROM Tacciones t WHERE t.configurar = :configurar"),
    @NamedQuery(name = "Tacciones.findByCargar", query = "SELECT t FROM Tacciones t WHERE t.cargar = :cargar"),
    @NamedQuery(name = "Tacciones.findByDescargar", query = "SELECT t FROM Tacciones t WHERE t.descargar = :descargar"),
    @NamedQuery(name = "Tacciones.findByTFormularioid", query = "SELECT t FROM Tacciones t WHERE t.tFormularioid = :tFormularioid")})
public class Tacciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean asignar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean configurar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean cargar;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean descargar;
    @Basic(optional = false)
    @Column(name = "TFormulario_id", nullable = false)
    private int tFormularioid;

    public Tacciones() {
    }

    public Tacciones(Integer id) {
        this.id = id;
    }

    public Tacciones(Integer id, boolean asignar, boolean configurar, boolean cargar, boolean descargar, int tFormularioid) {
        this.id = id;
        this.asignar = asignar;
        this.configurar = configurar;
        this.cargar = cargar;
        this.descargar = descargar;
        this.tFormularioid = tFormularioid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getAsignar() {
        return asignar;
    }

    public void setAsignar(boolean asignar) {
        this.asignar = asignar;
    }

    public boolean getConfigurar() {
        return configurar;
    }

    public void setConfigurar(boolean configurar) {
        this.configurar = configurar;
    }

    public boolean getCargar() {
        return cargar;
    }

    public void setCargar(boolean cargar) {
        this.cargar = cargar;
    }

    public boolean getDescargar() {
        return descargar;
    }

    public void setDescargar(boolean descargar) {
        this.descargar = descargar;
    }

    public int getTFormularioid() {
        return tFormularioid;
    }

    public void setTFormularioid(int tFormularioid) {
        this.tFormularioid = tFormularioid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tacciones)) {
            return false;
        }
        Tacciones other = (Tacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tacciones[ id=" + id + " ]";
    }
    
}
