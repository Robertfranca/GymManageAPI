package com.gymManage.controller;

import com.gymManage.modules.AlunoCadModels;
import com.gymManage.modules.FichaCadModels;
import com.gymManage.repository.AlunoCadRepository;
import com.gymManage.repository.FichaCadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FichaCadController {

    @Autowired
    private FichaCadRepository fr;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/ficha/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return fr.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path = "/api/ficha_list")
    public List<FichaCadModels> listar(){
        return fr.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path = "/api/ficha/salvar")
    public FichaCadModels cadficha(@RequestBody FichaCadModels ficha) {

        System.out.println(ficha.getId());
        return fr.save(ficha);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path = "/api/ficha/{codigo}")
    public FichaCadModels alterar(@PathVariable  Integer codigo, @RequestBody FichaCadModels ficha) {
        FichaCadModels fichaEdit=  fr.findById(codigo).get();
        BeanUtils.copyProperties(ficha,fichaEdit,"codigo");

        return fr.save(fichaEdit);
    }

    @DeleteMapping(path = "/api/ficha/{codigo}")
    public void deletar(@PathVariable  Integer codigo) {
       fr.deleteById(codigo);
    }



}