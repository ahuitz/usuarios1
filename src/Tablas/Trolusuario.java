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
    @NamedQuery(name = "Trolusuario.findAll", query = "SELECT t FROM Trolusuario t"),
    @NamedQuery(name = "Trolusuario.findById", query = "SELECT t FROM Trolusuario t WHERE t.id = :id"),
    @NamedQuery(name = "Trolusuario.findByRol", query = "SELECT t FROM Trolusuario t WHERE t.rol = :rol"),
    @NamedQuery(name = "Trolusuario.findByTPermisosid", query = "SELECT t FROM Trolusuario t WHERE t.tPermisosid = :tPermisosid"),
    @NamedQuery(name = "Trolusuario.findByTPermCarreraid", query = "SELECT t FROM Trolusuario t WHERE t.tPermCarreraid = :tPermCarreraid"),
    @NamedQuery(name = "Trolusuario.findByTPermPuestoid", query = "SELECT t FROM Trolusuario t WHERE t.tPermPuestoid = :tPermPuestoid")})
public class Trolusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String rol;
    @Basic(optional = false)
    @Column(name = "TPermisos_id", nullable = false)
    private int tPermisosid;
    @Basic(optional = false)
    @Column(name = "TPermCarrera_id", nullable = false)
    private int tPermCarreraid;
    @Basic(optional = false)
    @Column(name = "TPermPuesto_id", nullable = false)
    private int tPermPuestoid;

    public Trolusuario() {
    }

    public Trolusuario(Integer id) {
        this.id = id;
    }

    public Trolusuario(Integer id, String rol, int tPermisosid, int tPermCarreraid, int tPermPuestoid) {
        this.id = id;
        this.rol = rol;
        this.tPermisosid = tPermisosid;
        this.tPermCarreraid = tPermCarreraid;
        this.tPermPuestoid = tPermPuestoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getTPermisosid() {
        return tPermisosid;
    }

    public void setTPermisosid(int tPermisosid) {
        this.tPermisosid = tPermisosid;
    }

    public int getTPermCarreraid() {
        return tPermCarreraid;
    }

    public void setTPermCarreraid(int tPermCarreraid) {
        this.tPermCarreraid = tPermCarreraid;
    }

    public int getTPermPuestoid() {
        return tPermPuestoid;
    }

    public void setTPermPuestoid(int tPermPuestoid) {
        this.tPermPuestoid = tPermPuestoid;
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
        if (!(object instanceof Trolusuario)) {
            return false;
        }
        Trolusuario other = (Trolusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablas.Trolusuario[ id=" + id + " ]";
    }
    
}
