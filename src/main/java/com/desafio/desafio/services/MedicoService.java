package com.desafio.desafio.services;

import com.desafio.desafio.models.Medico;
import com.desafio.desafio.repositories.MedicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService implements BaseService<Medico, String>{

    private static final Logger loggerUtil = LoggerFactory.getLogger(MedicoService.class);
    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public Medico buscar(String id) {
        return medicoRepository.findOne(id);
    }

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }

    public Medico salvar(Medico medico){
        return medicoRepository.save(medico);
    }

    private Optional<Medico>buscarPorId(String idMedico) {
        loggerUtil.info("Consultado lançamento de id ", idMedico);
        return Optional.of(medicoRepository.findOne(idMedico));
    }

    @Override
    public Medico editar(String idMedico, Medico medico) {
        final Optional<Medico> optional = buscarPorId(idMedico);
        if (optional.isPresent()) {
            Medico medicoBanco = optional.get();
            BeanUtils.copyProperties(medico, medicoBanco , "id");
            return medicoRepository.save(medicoBanco);
        } else {
            return trataMedicoNaoEncontrado();
        }
    }

    private Medico trataMedicoNaoEncontrado() {
        loggerUtil.warn("Medico não encontrado.");
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public void remover(String idMedico) {
        Optional<Medico> lancamentoBanco = buscarPorId(idMedico);
        if (lancamentoBanco.isPresent()) {
            loggerUtil.info("Removendo medico de id ", idMedico);
            medicoRepository.delete(idMedico);
            loggerUtil.info("Medico removido como sucesso ");
        } else {
            trataMedicoNaoEncontrado();
        }
    }

}
