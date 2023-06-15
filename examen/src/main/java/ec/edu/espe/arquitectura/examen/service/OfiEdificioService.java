package ec.edu.espe.arquitectura.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examen.model.OfiEdificio;
import ec.edu.espe.arquitectura.examen.repository.OfiEdificioRepository;
import jakarta.transaction.Transactional;

@Service
public class OfiEdificioService {

    private final OfiEdificioRepository ofiEdificioRepository;

    public OfiEdificioService(OfiEdificioRepository ofiEdificioRepository) {
        this.ofiEdificioRepository = ofiEdificioRepository;
    }

    public Optional<OfiEdificio> obtainByCode(String code) {
        return this.ofiEdificioRepository.findById(code);
    }
     public List<OfiEdificio> obtenerEdificiosOrdenadosPorSuperficie(Integer codigoInstitucion) {
        return ofiEdificioRepository.findByCodigoInstitucionOrderBySuperficieDesc(codigoInstitucion);
    }
    
    @Transactional
    public OfiEdificio create(OfiEdificio ofiEdificio) {
        Optional<OfiEdificio> ofiTmp = this.ofiEdificioRepository.findById(ofiEdificio.getPk());
        if (ofiTmp == null) {
            return this.ofiEdificioRepository.save(ofiEdificio);
        } else {
            throw new RuntimeException("Edificio ya existe");
        }
    }

    @Transactional
    public OfiEdificio update(OfiEdificio ofiEdificio) {
        Optional<OfiEdificio> ofiOpt = this.ofiEdificioRepository.findById(ofiEdificio.getPk());
        if (ofiOpt.isPresent()) {
            OfiEdificio ofiTmp = ofiOpt.get();  //memoria del entity manager
            ofiTmp.setNombre(ofiEdificio.getNombre());
            this.ofiEdificioRepository.save(ofiTmp); //update
            return ofiTmp;
        } else {
            throw new RuntimeException("Edificio que desea modificar no esta registrado");
        }
    }

    @Transactional
    public void delete(OfiEdificio ofiEdificio) {
        try {
            Optional<OfiEdificio> ofiOpt =  this.ofiEdificioRepository.findById(ofiEdificio.getPk());
            if (ofiOpt.isPresent()) {
                this.ofiEdificioRepository.delete(ofiOpt.get());
            } else {
                throw new RuntimeException("El edificio no esta registrado: "+ofiEdificio);
            }
        } catch (RuntimeException rte) {
            throw new RuntimeException("No se puede eliminar el edificio con Codigo: "+ ofiEdificio, rte);
        }
    }
}
