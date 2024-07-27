package br.senai.medico_api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(unique = true)
    private String crm;
    private LocalDate dataNascimento;
    private String telefone;
    private EspecialidadeEnum especialidade;

    // Construtor padrão
    public Medico() {
    }

    // Construtor com todos os campos
    public Medico(String nome, String crm, LocalDate dataNascimento, String telefone, EspecialidadeEnum especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.especialidade = especialidade;
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
