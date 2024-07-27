package br.senai.medico_api.mapper;

import br.senai.medico_api.dto.MedicoDTO;
import br.senai.medico_api.dto.MedicoResponseDTO;
import br.senai.medico_api.model.Medico;
import org.springframework.stereotype.Component;

@Component
public class MedicoMapper {

    public Medico toEntity(MedicoDTO dto) {
        return new Medico(
                dto.getNome(),
                dto.getCrm(),
                dto.getDataNascimento(),
                dto.getTelefone(),
                dto.getEspecialidade()
        );
    }

    public MedicoResponseDTO toResponseDTO(Medico medico) {
        MedicoResponseDTO responseDTO = new MedicoResponseDTO();
        responseDTO.setId(medico.getId());
        responseDTO.setNome(medico.getNome());
        responseDTO.setCrm(medico.getCrm());
        responseDTO.setDataNascimento(medico.getDataNascimento());
        responseDTO.setTelefone(medico.getTelefone());
        responseDTO.setEspecialidade(medico.getEspecialidade());
        return responseDTO;
    }
}
