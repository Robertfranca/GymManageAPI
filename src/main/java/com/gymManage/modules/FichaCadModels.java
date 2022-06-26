package com.gymManage.modules;

import javax.persistence.*;

@Entity
@Table(name = "Cad_Ficha")
public class FichaCadModels {


    private static final long serialVersionUid= 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nomeAln", length = 100)
    private String nome_aluno;

    @Column(name = "nomePrf", length = 100)
    private String nome_prof;

    @Column(name = "horario", length = 50)
    private String horario;

    @Column(name = "dropvalue")
    private String dropvalue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getNome_prf() {
        return nome_prof;
    }

    public void setNome_prf(String nome_prof) {
        this.nome_prof = nome_prof;
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
