package ec.edu.espe.arquitectura.examen.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OfiEdificioPk implements Serializable {
    
    @Column(name = "COD_EDIFICIO", length = 8, nullable = false)
    private String codigoEdificio;
    @Column(name = "COD_SEDE", length = 8, nullable = false)
    private String codSede;

    public OfiEdificioPk() {
    }

    public OfiEdificioPk(String codigoEdificio, String codSede) {
        this.codigoEdificio = codigoEdificio;
        this.codSede = codSede;
    }

    public String getCodigoEdificio() {
        return codigoEdificio;
    }

    public void setCodigoEdificio(String codigoEdificio) {
        this.codigoEdificio = codigoEdificio;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoEdificio == null) ? 0 : codigoEdificio.hashCode());
        result = prime * result + ((codSede == null) ? 0 : codSede.hashCode());
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
        OfiEdificioPk other = (OfiEdificioPk) obj;
        if (codigoEdificio == null) {
            if (other.codigoEdificio != null)
                return false;
        } else if (!codigoEdificio.equals(other.codigoEdificio))
            return false;
        if (codSede == null) {
            if (other.codSede != null)
                return false;
        } else if (!codSede.equals(other.codSede))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "OfiEdificioPk [codigoEdificio=" + codigoEdificio + ", codSede=" + codSede + "]";
    }

    
    

    
}
