/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zippy
 */
@Entity
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findByIdModelo", query = "SELECT m FROM Modelo m WHERE m.idModelo = :idModelo")
    , @NamedQuery(name = "Modelo.findByNombre", query = "SELECT m FROM Modelo m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Modelo.findByPrecio", query = "SELECT m FROM Modelo m WHERE m.precio = :precio")
    , @NamedQuery(name = "Modelo.findByNoCodigoDeBarras", query = "SELECT m FROM Modelo m WHERE m.noCodigoDeBarras = :noCodigoDeBarras")})
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idModelo")
    private String idModelo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @Column(name = "noCodigoDeBarras")
    private String noCodigoDeBarras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModelo", fetch=FetchType.EAGER)
    
    private List<Talla> tallaList;

    public Modelo() {
    }

    public Modelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public Modelo(String idModelo, String nombre, float precio, String noCodigoDeBarras) {
        this.idModelo = idModelo;
        this.nombre = nombre;
        this.precio = precio;
        this.noCodigoDeBarras = noCodigoDeBarras;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNoCodigoDeBarras() {
        return noCodigoDeBarras;
    }

    public void setNoCodigoDeBarras(String noCodigoDeBarras) {
        this.noCodigoDeBarras = noCodigoDeBarras;
    }

    @XmlTransient
    public List<Talla> getTallaList() {
        return tallaList;
    }

    public void setTallaList(List<Talla> tallaList) {
        this.tallaList = tallaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModelo != null ? idModelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.idModelo == null && other.idModelo != null) || (this.idModelo != null && !this.idModelo.equals(other.idModelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Modelo[ idModelo=" + idModelo + " ]";
    }
    
}
