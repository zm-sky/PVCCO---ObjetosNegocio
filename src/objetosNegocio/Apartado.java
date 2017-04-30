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
@Table(name = "apartado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apartado.findAll", query = "SELECT a FROM Apartado a")
    , @NamedQuery(name = "Apartado.findByIdApartado", query = "SELECT a FROM Apartado a WHERE a.idApartado = :idApartado")
    , @NamedQuery(name = "Apartado.findByNombreCliente", query = "SELECT a FROM Apartado a WHERE a.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Apartado.findByTelefono", query = "SELECT a FROM Apartado a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Apartado.findByPrecioTotal", query = "SELECT a FROM Apartado a WHERE a.precioTotal = :precioTotal")
    , @NamedQuery(name = "Apartado.findByEstado", query = "SELECT a FROM Apartado a WHERE a.estado = :estado")
    , @NamedQuery(name = "Apartado.findByFechaInicio", query = "SELECT a FROM Apartado a WHERE a.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Apartado.findByFechaFin", query = "SELECT a FROM Apartado a WHERE a.fechaFin = :fechaFin")})
public class Apartado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idApartado")
    private String idApartado;
    @Basic(optional = false)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "precioTotal")
    private float precioTotal;
    @Basic(optional = false)
    @Column(name = "Estado")
    private Character estado;
    @Basic(optional = false)
    @Column(name = "fechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApartado")
    private List<MovimientoEnApartado> movimientoenapartadoList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idApartado")
    private List<TallaApartado> tallaapartadoList;

    public Apartado() {
    }

    public Apartado(String idApartado) {
        this.idApartado = idApartado;
    }

    public Apartado(String idApartado, String nombreCliente, String telefono, float precioTotal, Character estado, Date fechaInicio, Date fechaFin) {
        this.idApartado = idApartado;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getIdApartado() {
        return idApartado;
    }

    public void setIdApartado(String idApartado) {
        this.idApartado = idApartado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @XmlTransient
    public List<MovimientoEnApartado> getMovimientoenapartadoList() {
        return movimientoenapartadoList;
    }

    public void setMovimientoenapartadoList(List<MovimientoEnApartado> movimientoenapartadoList) {
        this.movimientoenapartadoList = movimientoenapartadoList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<TallaApartado> getTallaapartadoList() {
        return tallaapartadoList;
    }

    public void setTallaapartadoList(List<TallaApartado> tallaapartadoList) {
        this.tallaapartadoList = tallaapartadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApartado != null ? idApartado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apartado)) {
            return false;
        }
        Apartado other = (Apartado) object;
        if ((this.idApartado == null && other.idApartado != null) || (this.idApartado != null && !this.idApartado.equals(other.idApartado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Apartado[ idApartado=" + idApartado + " ]";
    }
    
}
