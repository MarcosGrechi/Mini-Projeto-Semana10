package br.senai.medico_api.service;

import br.senai.medico_api.model.EspecialidadeEnum;
import br.senai.medico_api.model.Medico;
import br.senai.medico_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public Medico addMedico(Medico medico) {
        if (medicoRepository.findByCrm(medico.getCrm()).isPresent()) {
            throw new DataIntegrityViolationException("CRM já cadastrado.");
        }
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico medico) {
        if (medicoRepository.findById(id).isEmpty()) {
            return null;
        }
        if (medicoRepository.findByCrm(medico.getCrm()).isPresent() && !medicoRepository.findByCrm(medico.getCrm()).get().getId().equals(id)) {
            throw new DataIntegrityViolationException("CRM já cadastrado.");
        }
        medico.setId(id);
        return medicoRepository.save(medico);
    }

    public Page<Medico> getAllMedicos(String nome, EspecialidadeEnum especialidade, LocalDate dataNascimento, Pageable pageable) {
        return medicoRepository.findAll(pageable);
    }

    public Optional<Medico> getMedicoById(Long id) {
        return medicoRepository.findById(id);
    }

    public boolean deleteMedico(Long id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
