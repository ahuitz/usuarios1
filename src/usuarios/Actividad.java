/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Cliente
 */
@Entity
@Table(name = "actividad", catalog = "PermisosUs", schema = "")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findById", query = "SELECT a FROM Actividad a WHERE a.id = :id"),
    @NamedQuery(name = "Actividad.findByTitulo", query = "SELECT a FROM Actividad a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Actividad.findByFechaEntrega", query = "SELECT a FROM Actividad a WHERE a.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Actividad.findByFechaPublicacion", query = "SELECT a FROM Actividad a WHERE a.fechaPublicacion = :fechaPublicacion"),
    @NamedQuery(name = "Actividad.findByPunteo", query = "SELECT a FROM Actividad a WHERE a.punteo = :punteo"),
    @NamedQuery(name = "Actividad.findByTiempoextra", query = "SELECT a FROM Actividad a WHERE a.tiempoextra = :tiempoextra"),
    @NamedQuery(name = "Actividad.findByFisica", query = "SELECT a FROM Actividad a WHERE a.fisica = :fisica"),
    @NamedQuery(name = "Actividad.findByVirtual", query = "SELECT a FROM Actividad a WHERE a.virtual = :virtual"),
    @NamedQuery(name = "Actividad.findBySeccionCursoid", query = "SELECT a FROM Actividad a WHERE a.seccionCursoid = :seccionCursoid"),
    @NamedQuery(name = "Actividad.findByTipoActividadid", query = "SELECT a FROM Actividad a WHERE a.tipoActividadid = :tipoActividadid")})
public class Actividad implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FechaEntrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "FechaPublicacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPublicacion;
    @Basic(optional = false)
    @Column(name = "Punteo")
    private double punteo;
    @Basic(optional = false)
    @Column(name = "Tiempo_extra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tiempoextra;
    @Basic(optional = false)
    @Column(name = "Fisica")
    private boolean fisica;
    @Basic(optional = false)
    @Column(name = "Virtual")
    private boolean virtual;
    @Basic(optional = false)
    @Column(name = "SeccionCurso_id")
    private int seccionCursoid;
    @Basic(optional = false)
    @Column(name = "TipoActividad_id")
    private int tipoActividadid;

    public Actividad() {
    }

    public Actividad(Integer id) {
        this.id = id;
    }

    public Actividad(Integer id, String titulo, String descripcion, Date fechaEntrega, Date fechaPublicacion, double punteo, Date tiempoextra, boolean fisica, boolean virtual, int seccionCursoid, int tipoActividadid) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.fechaPublicacion = fechaPublicacion;
        this.punteo = punteo;
        this.tiempoextra = tiempoextra;
        this.fisica = fisica;
        this.virtual = virtual;
        this.seccionCursoid = seccionCursoid;
        this.tipoActividadid = tipoActividadid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        changeSupport.firePropertyChange("titulo", oldTitulo, titulo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        Date oldFechaEntrega = this.fechaEntrega;
        this.fechaEntrega = fechaEntrega;
        changeSupport.firePropertyChange("fechaEntrega", oldFechaEntrega, fechaEntrega);
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        Date oldFechaPublicacion = this.fechaPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        changeSupport.firePropertyChange("fechaPublicacion", oldFechaPublicacion, fechaPublicacion);
    }

    public double getPunteo() {
        return punteo;
    }

    public void setPunteo(double punteo) {
        double oldPunteo = this.punteo;
        this.punteo = punteo;
        changeSupport.firePropertyChange("punteo", oldPunteo, punteo);
    }

    public Date getTiempoextra() {
        return tiempoextra;
    }

    public void setTiempoextra(Date tiempoextra) {
        Date oldTiempoextra = this.tiempoextra;
        this.tiempoextra = tiempoextra;
        changeSupport.firePropertyChange("tiempoextra", oldTiempoextra, tiempoextra);
    }

    public boolean getFisica() {
        return fisica;
    }

    public void setFisica(boolean fisica) {
        boolean oldFisica = this.fisica;
        this.fisica = fisica;
        changeSupport.firePropertyChange("fisica", oldFisica, fisica);
    }

    public boolean getVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        boolean oldVirtual = this.virtual;
        this.virtual = virtual;
        changeSupport.firePropertyChange("virtual", oldVirtual, virtual);
    }

    public int getSeccionCursoid() {
        return seccionCursoid;
    }

    public void setSeccionCursoid(int seccionCursoid) {
        int oldSeccionCursoid = this.seccionCursoid;
        this.seccionCursoid = seccionCursoid;
        changeSupport.firePropertyChange("seccionCursoid", oldSeccionCursoid, seccionCursoid);
    }

    public int getTipoActividadid() {
        return tipoActividadid;
    }

    public void setTipoActividadid(int tipoActividadid) {
        int oldTipoActividadid = this.tipoActividadid;
        this.tipoActividadid = tipoActividadid;
        changeSupport.firePropertyChange("tipoActividadid", oldTipoActividadid, tipoActividadid);
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
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuarios.Actividad[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
