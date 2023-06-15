package ec.edu.espe.arquitectura.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.arquitectura.examen.model.OfiEdificio;
@Repository
public interface OfiEdificioRepository extends JpaRepository<OfiEdificio, String> {
    List<OfiEdificio> findByCodigoInstitucion(Integer codigoInstitucion);

    List<OfiEdificio> findByCodigoInstitucionOrderBySuperficieDesc(Integer codigoInstitucion);
}

    
