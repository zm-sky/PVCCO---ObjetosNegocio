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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t")
    , @NamedQuery(name = "Talla.findByIdTalla", query = "SELECT t FROM Talla t WHERE t.idTalla = :idTalla")
    , @NamedQuery(name = "Talla.findByTalla", query = "SELECT t FROM Talla t WHERE t.talla = :talla")
    , @NamedQuery(name = "Talla.findByModelo", query = "SELECT t FROM Talla t INNER JOIN Modelo m on m.idModelo = t.idModelo WHERE m.idModelo = :idModelo")
    , @NamedQuery(name = "Talla.findTallaByTalla", query = "SELECT t FROM Talla t WHERE t.talla = :talla AND t.idModelo = :idModelo")
    , @NamedQuery(name = "Talla.findByInventarioApartado", query = "SELECT t FROM Talla t WHERE t.inventarioApartado = :inventarioApartado")
    , @NamedQuery(name = "Talla.findByInventarioRegular", query = "SELECT t FROM Talla t WHERE t.inventarioRegular = :inventarioRegular")})
public class Talla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTalla")
    private String idTalla;
    @Basic(optional = false)
    @Column(name = "talla")
    private String talla;
    @Basic(optional = false)
    @Column(name = "inventarioApartado")
    private int inventarioApartado;
    @Basic(optional = false)
    @Column(name = "inventarioRegular")
    private int inventarioRegular;
    @JoinColumn(name = "idModelo", referencedColumnName = "idModelo")
    @ManyToOne(optional = false)
    private Modelo idModelo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla", fetch=FetchType.EAGER)
    private List<BajaDeInventario> bajaDeInventarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla", fetch=FetchType.EAGER)
    private List<VentaTalla> ventaTallaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla", fetch=FetchType.EAGER)
    private List<TallaApartado> tallaApartadoList;

    public Talla() {
    }

    public Talla(String idTalla) {
        this.idTalla = idTalla;
    }

    public Talla(String idTalla, String talla, int inventarioApartado, int inventarioRegular) {
        this.idTalla = idTalla;
        this.talla = talla;
        this.inventarioApartado = inventarioApartado;
        this.inventarioRegular = inventarioRegular;
    }

    public String getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(String idTalla) {
        this.idTalla = idTalla;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getInventarioApartado() {
        return inventarioApartado;
    }

    public void setInventarioApartado(int inventarioApartado) {
        this.inventarioApartado = inventarioApartado;
    }

    public int getInventarioRegular() {
        return inventarioRegular;
    }

    public void setInventarioRegular(int inventarioRegular) {
        this.inventarioRegular = inventarioRegular;
    }

    public Modelo getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelo idModelo) {
        this.idModelo = idModelo;
    }

    @XmlTransient
    public List<BajaDeInventario> getBajaDeInventarioList() {
        return bajaDeInventarioList;
    }

    public void setBajaDeInventarioList(List<BajaDeInventario> bajaDeInventarioList) {
        this.bajaDeInventarioList = bajaDeInventarioList;
    }

    @XmlTransient
    public List<VentaTalla> getVentaTallaList() {
        return ventaTallaList;
    }

    public void setVentaTallaList(List<VentaTalla> ventaTallaList) {
        this.ventaTallaList = ventaTallaList;
    }

    @XmlTransient
    public List<TallaApartado> getTallaApartadoList() {
        return tallaApartadoList;
    }

    public void setTallaApartadoList(List<TallaApartado> tallaApartadoList) {
        this.tallaApartadoList = tallaApartadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTalla != null ? idTalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.idTalla == null && other.idTalla != null) || (this.idTalla != null && !this.idTalla.equals(other.idTalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Talla[ idTalla=" + idTalla + " ]";
    }
    
}
