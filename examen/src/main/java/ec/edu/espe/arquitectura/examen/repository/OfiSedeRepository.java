package ec.edu.espe.arquitectura.examen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import ec.edu.espe.arquitectura.examen.model.OfiSede;
@Repository
public interface OfiSedeRepository extends JpaRepository<OfiSede, String>  {
    
   
    List<OfiSede> findByCodigoInstitucion(String codigoInstitucion);
    Boolean existsByEsPrincipal(Boolean esPrincipal);
}
