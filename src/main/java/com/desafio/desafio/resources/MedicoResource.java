package com.desafio.desafio.resources;

import com.desafio.desafio.models.Medico;
import com.desafio.desafio.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("/medicos")
public class MedicoResource implements BaseResource<Medico, String> {

    private final MedicoService medicoService;

    @Autowired
    public MedicoResource(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Override
    public ResponseEntity<Medico> buscar(@PathVariable("id") String idMedico) {
        final Medico medico = medicoService.buscar(idMedico);
        if (medico == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medico);
    }

    @Override
    public ResponseEntity<List<Medico>> listar() {
        final List<Medico> listar = medicoService.listar();
        return ResponseEntity.ok(listar);
    }

    @Override
    public ResponseEntity<Medico> salvar(@RequestBody @Valid Medico medico) {
        Medico medicoBanco  = medicoService.salvar(medico);
        if (medicoBanco == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return new ResponseEntity<>(medicoBanco, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Medico> editar(@PathVariable("id") String idMedico, @RequestBody @Valid Medico medico) {
        Medico medicoBanco  = medicoService.editar(idMedico, medico);
        if (medicoBanco == null) {
            return ResponseEntity.unprocessableEntity().build();
        } else {
            return new ResponseEntity<>(medicoBanco, HttpStatus.CREATED);
        }
    }

    @Override
    public void remover(@PathVariable("id") String id) {
        medicoService.remover(id);
    }
}
