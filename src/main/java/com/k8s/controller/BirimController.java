package com.k8s.controller;

import com.k8s.model.Birim;
import com.k8s.service.BirimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BirimController {

    @Autowired
    private BirimService service;

    @GetMapping(value = "/messages")
    public ResponseEntity<String> getMessage() {
        System.out.println("Load Kubernates Success!");
        return new ResponseEntity<String>("Load Kubernates Success!", HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/birims")
    public ResponseEntity<Birim> create(@RequestBody Birim dto) {
        return new ResponseEntity<>(service.getBirim().create(dto), HttpStatus.CREATED);
    }

    @GetMapping("/birims")
    public ResponseEntity<List<Birim>> getAll() {
        return new ResponseEntity<>(service.getBirim().getAll(), HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/birims/{id}")
    public ResponseEntity<Birim> updateProcedure(@PathVariable String id, @RequestBody Birim dto) {
        return new ResponseEntity<>(service.getBirim().update(id, dto),HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/birims/{id}")
    public ResponseEntity<?> deleteProcedure(@PathVariable String id) {
        service.getBirim().delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
