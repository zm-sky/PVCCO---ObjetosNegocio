/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zippy
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByPagoLiquidacionApartado", query = "SELECT v FROM Venta v WHERE v.pagoLiquidacionApartado = :pagoLiquidacionApartado")
    , @NamedQuery(name = "Venta.findByPrecioTotal", query = "SELECT v FROM Venta v WHERE v.precioTotal = :precioTotal")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVenta")
    private String idVenta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "pagoLiquidacionApartado")
    private float pagoLiquidacionApartado;
    @Basic(optional = false)
    @Column(name = "precioTotal")
    private float precioTotal;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<MovimientoEnVenta> movimientoenventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenta")
    private List<VentaTalla> ventatallaList;

    public Venta() {
    }

    public Venta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(String idVenta, Date fecha, float pagoLiquidacionApartado, float precioTotal) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.pagoLiquidacionApartado = pagoLiquidacionApartado;
        this.precioTotal = precioTotal;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getPagoLiquidacionApartado() {
        return pagoLiquidacionApartado;
    }

    public void setPagoLiquidacionApartado(float pagoLiquidacionApartado) {
        this.pagoLiquidacionApartado = pagoLiquidacionApartado;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<MovimientoEnVenta> getMovimientoenventaList() {
        return movimientoenventaList;
    }

    public void setMovimientoenventaList(List<MovimientoEnVenta> movimientoenventaList) {
        this.movimientoenventaList = movimientoenventaList;
    }

    @XmlTransient
    public List<VentaTalla> getVentatallaList() {
        return ventatallaList;
    }

    public void setVentatallaList(List<VentaTalla> ventatallaList) {
        this.ventatallaList = ventatallaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
