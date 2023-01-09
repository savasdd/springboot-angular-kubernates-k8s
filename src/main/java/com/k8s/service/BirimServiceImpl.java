package com.k8s.service;

import com.k8s.model.Birim;
import com.k8s.repository.BirimRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class BirimServiceImpl {

    @Autowired
    private BirimRepository repository;

    public Birim create(Birim dto) {
        Birim newBirim = repository.save(dto);
        log.info("Create Birim!");
        return newBirim;
    }

    public List<Birim> getAll() {
        log.info("Get All Birim!");
        return repository.findAll();
    }


    public Birim update(String id, Birim dto) {
        log.info("Update Birim: " + id);
        Optional<Birim> birims=repository.findById(UUID.fromString(id));
        var updateBirim=birims.map(val->{
           val.setAd(dto.getAd());
           val.setYil(dto.getYil());
           val.setKod(dto.getKod());
           val.setCount(dto.getCount());
            return val;
        });

        return updateBirim.get();
    }

    public void delete(String id) {
        log.info("Delete Birim: " + id);
        repository.deleteById(UUID.fromString(id));
    }
}
