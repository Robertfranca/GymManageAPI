package com.gymManage.controller;

import com.gymManage.modules.AlunoCadModels;
import com.gymManage.repository.AlunoCadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoCadController {

    @Autowired
    private AlunoCadRepository ar;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/aluno/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return ar.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/aluno")
    public List<AlunoCadModels> listar(){
        return ar.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/api/aluno/salvar")
    public AlunoCadModels salvar(@RequestBody AlunoCadModels aluno) {

        System.out.println(aluno.getNome());
        return ar.save(aluno);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/api/aluno/{codigo}")
    public AlunoCadModels alterar(@PathVariable  Integer codigo, @RequestBody AlunoCadModels aluno) {
        AlunoCadModels alunoEdit=  ar.findById(codigo).get();
        BeanUtils.copyProperties(aluno,alunoEdit,"codigo");

        return ar.save(alunoEdit);
    }

    @DeleteMapping(path = "/api/aluno/{codigo}")
    public void deletar(@PathVariable  Integer codigo) {
       ar.deleteById(codigo);
    }



}