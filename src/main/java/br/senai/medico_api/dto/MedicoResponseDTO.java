package br.senai.medico_api.dto;

import br.senai.medico_api.model.EspecialidadeEnum;
import java.time.LocalDate;

public class MedicoResponseDTO {
    private Long id;
    private String nome;
    private String crm;
    private LocalDate dataNascimento;
    private String telefone;
    private EspecialidadeEnum especialidade;

    public MedicoResponseDTO(Long id, String nome, String crm, LocalDate dataNascimento, String telefone, EspecialidadeEnum especialidade) {
    }

    public MedicoResponseDTO() {

    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
