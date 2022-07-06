package com.gymManage.modules;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cad_professores")
public class ProfCadModels {


    private static final long serialVersionUid= 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "nome", length = 100)
    private String nome;

    @NotBlank
    @Column(name = "sobrenome", length = 50)
    private String sobrenome;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @NotBlank
    @Column(name = "telefone", length = 100)
    private String telefone;

    @NotBlank
    @Column(name = "cpf", length = 100)
    private String cpf;

    @NotBlank
    @Column(name = "cref", length = 100)
    private String cref;

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

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }

    public String getDropvalue() {
        return dropvalue;
    }

    public void setDropvalue(String dropvalue) {
        this.dropvalue = dropvalue;
    }

}
