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
@Table(name = "tallaapartado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tallaapartado.findAll", query = "SELECT t FROM Tallaapartado t")
    , @NamedQuery(name = "Tallaapartado.findByIdTallaApartado", query = "SELECT t FROM Tallaapartado t WHERE t.idTallaApartado = :idTallaApartado")
    , @NamedQuery(name = "Tallaapartado.findByPrecio", query = "SELECT t FROM Tallaapartado t WHERE t.precio = :precio")})
public class TallaApartado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTallaApartado")
    private String idTallaApartado;
    @Basic(optional = false)
    @Column(name = "Precio")
    private float precio;
    @JoinColumn(name = "idTalla", referencedColumnName = "idTalla")
    @ManyToOne(optional = false)
    private Talla idTalla;
    @JoinColumn(name = "idApartado", referencedColumnName = "idApartado")
    @ManyToOne(optional = false)
    private Apartado idApartado;

    public TallaApartado() {
    }

    public TallaApartado(String idTallaApartado) {
        this.idTallaApartado = idTallaApartado;
    }

    public TallaApartado(String idTallaApartado, float precio) {
        this.idTallaApartado = idTallaApartado;
        this.precio = precio;
    }

    public String getIdTallaApartado() {
        return idTallaApartado;
    }

    public void setIdTallaApartado(String idTallaApartado) {
        this.idTallaApartado = idTallaApartado;
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

    public Apartado getIdApartado() {
        return idApartado;
    }

    public void setIdApartado(Apartado idApartado) {
        this.idApartado = idApartado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTallaApartado != null ? idTallaApartado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TallaApartado)) {
            return false;
        }
        TallaApartado other = (TallaApartado) object;
        if ((this.idTallaApartado == null && other.idTallaApartado != null) || (this.idTallaApartado != null && !this.idTallaApartado.equals(other.idTallaApartado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Tallaapartado[ idTallaApartado=" + idTallaApartado + " ]";
    }
    
}
