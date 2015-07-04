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
    @NamedQuery(name = "Tformulario.findAll", query = "SELECT t FROM Tformulario t"),
    @NamedQuery(name = "Tformulario.findById", query = "SELECT t FROM Tformulario t WHERE t.id = :id"),
    @NamedQuery(name = "Tformulario.findByNombreFormulario", query = "SELECT t FROM Tformulario t WHERE t.nombreFormulario = :nombreFormulario"),
    @NamedQuery(name = "Tformulario.findByTModuloid", query = "SELECT t FROM Tformulario t WHERE t.tModuloid = :tModuloid")})
public class Tformulario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String nombreFormulario;
    @Basic(optional = false)
    @Column(name = "TModulo_id", nullable = false)
    private int tModuloid;

    public Tformulario() {
    }

    public Tformulario(Integer id) {
        this.id = id;
    }

    public Tformulario(Integer id, String nombreFormulario, int tModuloid) {
        this.id = id;
        this.nombreFormulario = nombreFormulario;
        this.tModuloid = tModuloid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreFormulario() {
        return nombreFormulario;
    }

    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    public int getTModuloid() {
        return tModuloid;
    }

    public void setTModuloid(int tModuloid) {
        this.tModuloid = tModuloid;
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
        if (!(object instanceof Tformulario)) {
            return false;
        }
        Tformulario other = (Tformulario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Tformulario[ id=" + id + " ]";
    }
    
}
