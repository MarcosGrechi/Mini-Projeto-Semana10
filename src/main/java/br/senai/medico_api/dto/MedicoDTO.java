package br.senai.medico_api.dto;

import br.senai.medico_api.model.EspecialidadeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

public class MedicoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,6}", message = "CRM deve ter entre 4 e 6 dígitos")
    private String crm;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    @NotNull(message = "Especialidade é obrigatória")
    private EspecialidadeEnum especialidade;

    // Getters e setters


    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "CRM é obrigatório") @Pattern(regexp = "\\d{4,6}", message = "CRM deve ter entre 4 e 6 dígitos") String getCrm() {
        return crm;
    }

    public void setCrm(@NotBlank(message = "CRM é obrigatório") @Pattern(regexp = "\\d{4,6}", message = "CRM deve ter entre 4 e 6 dígitos") String crm) {
        this.crm = crm;
    }

    public @NotNull(message = "Data de nascimento é obrigatória") LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull(message = "Data de nascimento é obrigatória") LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank(message = "Telefone é obrigatório") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Telefone é obrigatório") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "Especialidade é obrigatória") EspecialidadeEnum getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@NotNull(message = "Especialidade é obrigatória") EspecialidadeEnum especialidade) {
        this.especialidade = especialidade;
    }
}
