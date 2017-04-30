/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zippy
 */
@Entity
@Table(name = "bajadeinventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bajadeinventario.findAll", query = "SELECT b FROM Bajadeinventario b")
    , @NamedQuery(name = "Bajadeinventario.findByIdBajaInventario", query = "SELECT b FROM Bajadeinventario b WHERE b.idBajaInventario = :idBajaInventario")
    , @NamedQuery(name = "Bajadeinventario.findByDescripcion", query = "SELECT b FROM Bajadeinventario b WHERE b.descripcion = :descripcion")
    , @NamedQuery(name = "Bajadeinventario.findByFecha", query = "SELECT b FROM Bajadeinventario b WHERE b.fecha = :fecha")
    , @NamedQuery(name = "Bajadeinventario.findByCantidad", query = "SELECT b FROM Bajadeinventario b WHERE b.cantidad = :cantidad")})
public class BajaDeInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idBajaInventario")
    private String idBajaInventario;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idTalla", referencedColumnName = "idTalla")
    @ManyToOne(optional = false)
    private Talla idTalla;

    public BajaDeInventario() {
    }

    public BajaDeInventario(String idBajaInventario) {
        this.idBajaInventario = idBajaInventario;
    }

    public BajaDeInventario(String idBajaInventario, String descripcion, Date fecha, int cantidad) {
        this.idBajaInventario = idBajaInventario;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getIdBajaInventario() {
        return idBajaInventario;
    }

    public void setIdBajaInventario(String idBajaInventario) {
        this.idBajaInventario = idBajaInventario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Talla getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Talla idTalla) {
        this.idTalla = idTalla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBajaInventario != null ? idBajaInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BajaDeInventario)) {
            return false;
        }
        BajaDeInventario other = (BajaDeInventario) object;
        if ((this.idBajaInventario == null && other.idBajaInventario != null) || (this.idBajaInventario != null && !this.idBajaInventario.equals(other.idBajaInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Bajadeinventario[ idBajaInventario=" + idBajaInventario + " ]";
    }
    
}
