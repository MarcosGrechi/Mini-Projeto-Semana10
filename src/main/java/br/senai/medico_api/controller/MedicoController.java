package br.senai.medico_api.controller;

import br.senai.medico_api.dto.MedicoDTO;
import br.senai.medico_api.dto.MedicoResponseDTO;
import br.senai.medico_api.mapper.MedicoMapper;
import br.senai.medico_api.model.EspecialidadeEnum;
import br.senai.medico_api.model.Medico;
import br.senai.medico_api.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicoMapper medicoMapper;

    @PostMapping
    public ResponseEntity<?> addMedico(@Valid @RequestBody MedicoDTO medicoDTO) {
        Medico medico = medicoMapper.toEntity(medicoDTO);
        Medico savedMedico = medicoService.addMedico(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoMapper.toResponseDTO(savedMedico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMedico(@PathVariable Long id, @Valid @RequestBody MedicoDTO medicoDTO) {
        Optional<Medico> existingMedico = medicoService.getMedicoById(id);
        if (!existingMedico.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Medico medico = medicoMapper.toEntity(medicoDTO);
        medico.setId(id);
        Medico updatedMedico = medicoService.updateMedico(id, medico);

        if (updatedMedico != null) {
            return ResponseEntity.ok(medicoMapper.toResponseDTO(updatedMedico));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar o médico");
        }
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDTO>> getAllMedicos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) EspecialidadeEnum especialidade,
            @RequestParam(required = false) LocalDate dataNascimento,
            Pageable pageable
    ) {
        Page<Medico> medicos = medicoService.getAllMedicos(nome, especialidade, dataNascimento, pageable);
        Page<MedicoResponseDTO> medicoDTOs = medicos.map(medicoMapper::toResponseDTO);
        return ResponseEntity.ok(medicoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponseDTO> getMedicoById(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.getMedicoById(id);
        return medico.map(value -> ResponseEntity.ok(medicoMapper.toResponseDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        boolean deleted = medicoService.deleteMedico(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
