package com.gymManage.modules;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cad_Ficha")
public class FichaCadModels {


    private static final long serialVersionUid= 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    @Column(name = "nomeAln", length = 100)
    private String nome_aluno;


    @NotBlank
    @Column(name = "nome_prof", length = 50)
    private String nome_prof;

    public String getNome_prof() {
        return nome_prof;
    }

    public void setNome_prof(String nome_prof) {
        this.nome_prof = nome_prof;
    }

    @NotBlank
    @Column(name = "horario", length = 50)
    private String horario;


    @NotBlank
    @Column(name = "dropvalue")
    private String dropvalue;

    public Integer getId() {
        return id;
    }


    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDropvalue() {
        return dropvalue;
    }

    public void setDropvalue(String dropvalue) {
        this.dropvalue = dropvalue;
    }


}
