package com.gymManage.controller;

import com.gymManage.modules.AlunoCadModels;
import com.gymManage.modules.FichaCadModels;
import com.gymManage.repository.AlunoCadRepository;
import com.gymManage.repository.FichaCadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FichaCadController {

    @Autowired
    private FichaCadRepository fr;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/ficha/{codigo}")
    @Cacheable("api/ficha_list")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        System.out.println("Cache ativo");
        return fr.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/ficha_list")
    @Cacheable("api/ficha_list")
    public List<FichaCadModels> listar(){
        return fr.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/api/ficha/salvar")
    @CacheEvict(value = "api/ficha_list", allEntries = true)
    public FichaCadModels cadficha(@RequestBody @Valid FichaCadModels ficha) {
        System.out.println("Cache ativo");
        return fr.save(ficha);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/api/ficha/{codigo}")
    @CacheEvict(value = "api/ficha_list", allEntries = true)
    public FichaCadModels alterar(@PathVariable  Integer codigo, @RequestBody @Valid FichaCadModels ficha) {
        FichaCadModels fichaEdit=  fr.findById(codigo).get();
        BeanUtils.copyProperties(ficha,fichaEdit,"codigo");
        System.out.println("Cache ativo");

        return fr.save(fichaEdit);
    }

    @DeleteMapping(path = "/api/ficha/{codigo}")
    @CacheEvict(value = "api/ficha_list", allEntries = true)
    public void deletar(@PathVariable  Integer codigo) {
        System.out.println("Cache ativo");
       fr.deleteById(codigo);
    }



}