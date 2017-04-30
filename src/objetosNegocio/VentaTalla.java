/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zippy
 */
@Entity
@Table(name = "ventatalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventatalla.findAll", query = "SELECT v FROM Ventatalla v")
    , @NamedQuery(name = "Ventatalla.findByIdVentaTalla", query = "SELECT v FROM Ventatalla v WHERE v.idVentaTalla = :idVentaTalla")
    , @NamedQuery(name = "Ventatalla.findByPrecio", query = "SELECT v FROM Ventatalla v WHERE v.precio = :precio")})
public class VentaTalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVentaTalla")
    private String idVentaTalla;
    @Basic(optional = false)
    @Column(name = "Precio")
    private float precio;
    @JoinColumn(name = "idTalla", referencedColumnName = "idTalla")
    @ManyToOne(optional = false)
    private Talla idTalla;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVenta")
    @ManyToOne(optional = false)
    private Venta idVenta;

    public VentaTalla() {
    }

    public VentaTalla(String idVentaTalla) {
        this.idVentaTalla = idVentaTalla;
    }

    public VentaTalla(String idVentaTalla, float precio) {
        this.idVentaTalla = idVentaTalla;
        this.precio = precio;
    }

    public String getIdVentaTalla() {
        return idVentaTalla;
    }

    public void setIdVentaTalla(String idVentaTalla) {
        this.idVentaTalla = idVentaTalla;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Talla getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(Talla idTalla) {
        this.idTalla = idTalla;
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
        hash += (idVentaTalla != null ? idVentaTalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaTalla)) {
            return false;
        }
        VentaTalla other = (VentaTalla) object;
        if ((this.idVentaTalla == null && other.idVentaTalla != null) || (this.idVentaTalla != null && !this.idVentaTalla.equals(other.idVentaTalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Ventatalla[ idVentaTalla=" + idVentaTalla + " ]";
    }
    
}
