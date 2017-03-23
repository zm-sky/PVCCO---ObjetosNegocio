
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
 * @author Raul Karim Sabag Ballesteros
 */
@Entity
@Table(name = "movimientoenapartado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimientoEnApartado.findAll", query = "SELECT m FROM MovimientoEnApartado m"),
    @NamedQuery(name = "MovimientoEnApartado.findByIdMovimientoApartado", query = "SELECT m FROM MovimientoEnApartado m WHERE m.idMovimientoApartado = :idMovimientoApartado"),
    @NamedQuery(name = "MovimientoEnApartado.findByFecha", query = "SELECT m FROM MovimientoEnApartado m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "MovimientoEnApartado.findByCantidadAbonada", query = "SELECT m FROM MovimientoEnApartado m WHERE m.cantidadAbonada = :cantidadAbonada")})
public class MovimientoEnApartado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMovimientoApartado")
    private String idMovimientoApartado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cantidadAbonada")
    private float cantidadAbonada;
    @JoinColumn(name = "idApartado", referencedColumnName = "idApartado")
    @ManyToOne(optional = false)
    private Apartado idApartado;

    public MovimientoEnApartado() {
    }

    public MovimientoEnApartado(String idMovimientoApartado) {
        this.idMovimientoApartado = idMovimientoApartado;
    }

    public MovimientoEnApartado(String idMovimientoApartado, Date fecha, float cantidadAbonada) {
        this.idMovimientoApartado = idMovimientoApartado;
        this.fecha = fecha;
        this.cantidadAbonada = cantidadAbonada;
    }

    public String getIdMovimientoApartado() {
        return idMovimientoApartado;
    }

    public void setIdMovimientoApartado(String idMovimientoApartado) {
        this.idMovimientoApartado = idMovimientoApartado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidadAbonada() {
        return cantidadAbonada;
    }

    public void setCantidadAbonada(float cantidadAbonada) {
        this.cantidadAbonada = cantidadAbonada;
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
        hash += (idMovimientoApartado != null ? idMovimientoApartado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoEnApartado)) {
            return false;
        }
        MovimientoEnApartado other = (MovimientoEnApartado) object;
        if ((this.idMovimientoApartado == null && other.idMovimientoApartado != null) || (this.idMovimientoApartado != null && !this.idMovimientoApartado.equals(other.idMovimientoApartado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.MovimientoEnApartado[ idMovimientoApartado=" + idMovimientoApartado + " ]";
    }

}
