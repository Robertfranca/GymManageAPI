package com.gymManage.modules;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cad_alunos")
public class AlunoCadModels {


    private static final long serialVersionUid= 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "nome", length = 100)
    private String nome;

    @NotBlank
    @Column(name = "sobrenome", length = 100)
    private String sobrenome;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @NotBlank
    @Column(name = "cpf", length = 100)
    private String cpf;

    @NotBlank
    @Column(name = "telefone", length = 100)
    private String telefone;

    @NotBlank
    @Column(name = "peso", length = 100)
    private String peso;

    @NotBlank
    @Column(name = "altura", length = 100)
    private String altura;

    @NotBlank
    @Column(name = "dropvalue")
    private String dropvalue;


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }


    public String getDropvalue() {
        return dropvalue;
    }

    public void setDropvalue(String dropvalue) {
        this.dropvalue = dropvalue;
    }


}
