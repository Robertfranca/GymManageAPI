package com.gymManage.controller;

import com.gymManage.modules.ProfCadModels;
import com.gymManage.repository.ProfCadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfCadController {

    @Autowired
    private ProfCadRepository pr;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/professor/{codigo}")
    @Cacheable("api/professor")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {

        System.out.println("Cache ativo");
        return pr.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/professor")
    @Cacheable("api/professor")
    public List<ProfCadModels> listar(){
        System.out.println("Cache ativo");
        return pr.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/api/professor/salvar")
    @CacheEvict(value = "api/professor", allEntries = true)
    public ProfCadModels salvar(@RequestBody ProfCadModels prof) {

        System.out.println(prof.getNome());
        System.out.println("limpando o cache");
        return pr.save(prof);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/api/professor/{codigo}")
    @CacheEvict(value = "api/professor", allEntries = true)
    public ProfCadModels alterar(@PathVariable  Integer codigo, @RequestBody ProfCadModels prof) {

        ProfCadModels profEdit=  pr.findById(codigo).get();
        BeanUtils.copyProperties(prof,profEdit,"codigo");
        System.out.println("limpando o cache");

        return pr.save(profEdit);
    }

    @DeleteMapping(path = "/api/professor/{codigo}")
    @CacheEvict(value = "api/professor", allEntries = true)
    public void deletar(@PathVariable  Integer codigo) {
        System.out.println("limpando o cache");
        pr.deleteById(codigo);
    }



}