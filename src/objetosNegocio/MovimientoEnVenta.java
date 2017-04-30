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
@Table(name = "movimientoenventa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientoenventa.findAll", query = "SELECT m FROM Movimientoenventa m")
    , @NamedQuery(name = "Movimientoenventa.findByIdMovimientoVenta", query = "SELECT m FROM Movimientoenventa m WHERE m.idMovimientoVenta = :idMovimientoVenta")
    , @NamedQuery(name = "Movimientoenventa.findByFecha", query = "SELECT m FROM Movimientoenventa m WHERE m.fecha = :fecha")
    , @NamedQuery(name = "Movimientoenventa.findByDescripcion", query = "SELECT m FROM Movimientoenventa m WHERE m.descripcion = :descripcion")
    , @NamedQuery(name = "Movimientoenventa.findByCantidadmovida", query = "SELECT m FROM Movimientoenventa m WHERE m.cantidadmovida = :cantidadmovida")})
public class MovimientoEnVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMovimientoVenta")
    private String idMovimientoVenta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cantidadmovida")
    private float cantidadmovida;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public MovimientoEnVenta() {
    }

    public MovimientoEnVenta(String idMovimientoVenta) {
        this.idMovimientoVenta = idMovimientoVenta;
    }

    public MovimientoEnVenta(String idMovimientoVenta, Date fecha, String descripcion, float cantidadmovida) {
        this.idMovimientoVenta = idMovimientoVenta;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidadmovida = cantidadmovida;
    }

    public String getIdMovimientoVenta() {
        return idMovimientoVenta;
    }

    public void setIdMovimientoVenta(String idMovimientoVenta) {
        this.idMovimientoVenta = idMovimientoVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCantidadmovida() {
        return cantidadmovida;
    }

    public void setCantidadmovida(float cantidadmovida) {
        this.cantidadmovida = cantidadmovida;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimientoVenta != null ? idMovimientoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoEnVenta)) {
            return false;
        }
        MovimientoEnVenta other = (MovimientoEnVenta) object;
        if ((this.idMovimientoVenta == null && other.idMovimientoVenta != null) || (this.idMovimientoVenta != null && !this.idMovimientoVenta.equals(other.idMovimientoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Movimientoenventa[ idMovimientoVenta=" + idMovimientoVenta + " ]";
    }
    
}
