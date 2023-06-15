package ec.edu.espe.arquitectura.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "OFI_INSTITUCION")

public class OfiInstitucion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_INSTITUCION", nullable = false)
    private Integer id;
    @Column(name = "RUC", nullable = false, length = 13)
    private String ruc;
    @Column(name = "RAZON_SOCIAL", nullable = false, length = 250)
    private String razonSocial;
    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    public OfiInstitucion() {
    }

    public OfiInstitucion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OfiInstitucion other = (OfiInstitucion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiInstitucion [id=" + id + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", version=" + version
                + "]";
    }

}
