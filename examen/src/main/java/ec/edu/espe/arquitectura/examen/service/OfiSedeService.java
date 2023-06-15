package ec.edu.espe.arquitectura.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.model.OfiEdificio;
import ec.edu.espe.arquitectura.examen.model.OfiSede;
import ec.edu.espe.arquitectura.examen.repository.OfiSedeRepository;
import jakarta.transaction.Transactional;

@Service
public class OfiSedeService {
      private final OfiSedeRepository ofiSedeRepository;

    public OfiSedeService(OfiSedeRepository ofiSedeRepository) {
        this.ofiSedeRepository = ofiSedeRepository;
    }
     public Optional<OfiSede> obtainByCode(String code) {
        return this.ofiSedeRepository.findById(code);
    }

    public List<OfiSede> obtenerSedesPorCodigoInstitucion(String codigoInstitucion) {
        return ofiSedeRepository.findByCodigoInstitucion(codigoInstitucion);
    }

    @Transactional
    public OfiSede create(OfiSede ofiSede) {
        Optional<OfiSede> ofiTmp = this.ofiSedeRepository.findById(ofiSede.getId());
        if (ofiTmp == null) {
            return this.ofiSedeRepository.save(ofiSede);
        } else {
            throw new RuntimeException("Sede ya existe");
        }
    }

    @Transactional
    public OfiSede update(OfiSede ofiSede) {
        Optional<OfiSede> ofiOpt = this.ofiSedeRepository.findById(ofiSede.getId());
        if (ofiOpt.isPresent()) {
            OfiSede ofiTmp = ofiOpt.get();  //memoria del entity manager
            ofiTmp.setNombre(ofiSede.getNombre());
            ofiTmp.setDireccion(ofiSede.getDireccion());
            this.ofiSedeRepository.save(ofiTmp); //update
            return ofiTmp;
        } else {
            throw new RuntimeException("Sede que desea modificar no esta registrado");
        }
    }

    @Transactional
    public void delete(OfiSede ofiSede) {
        try {
            Optional<OfiSede> ofiOpt =  this.ofiSedeRepository.findById(ofiSede.getId());
            if (ofiOpt.isPresent()) {
                this.ofiSedeRepository.delete(ofiOpt.get());
            } else {
                throw new RuntimeException("La sede no esta registrado: "+ofiSede);
            }
        } catch (RuntimeException rte) {
            throw new RuntimeException("No se puede eliminar la sede con Codigo: "+ ofiSede, rte);
        }
    }
      


    
}
