package com.gymManage.controller;

import com.gymManage.modules.ProfCadModels;
import com.gymManage.repository.ProfCadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfCadController {

    @Autowired
    private ProfCadRepository pr;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/professor/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return pr.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/professor")
    public List<ProfCadModels> listar(){
        return pr.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/api/professor/salvar")
    public ProfCadModels salvar(@RequestBody ProfCadModels prof) {

        System.out.println(prof.getNome());
        return pr.save(prof);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/api/professor/{codigo}")
    public ProfCadModels alterar(@PathVariable  Integer codigo, @RequestBody ProfCadModels prof) {
        ProfCadModels profEdit=  pr.findById(codigo).get();
        BeanUtils.copyProperties(prof,profEdit,"codigo");

        return pr.save(profEdit);
    }

    @DeleteMapping(path = "/api/professor/{codigo}")
    public void deletar(@PathVariable  Integer codigo) {
       pr.deleteById(codigo);
    }



}