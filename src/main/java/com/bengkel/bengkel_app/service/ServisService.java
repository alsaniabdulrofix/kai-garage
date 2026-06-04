package com.bengkel.bengkel_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.entity.Servis;
import com.bengkel.bengkel_app.repository.ServisRepository;

@Service
public class ServisService {

    private final ServisRepository repository;

    public ServisService(ServisRepository repository) {
        this.repository = repository;
    }

    public List<Servis> getAll() {
        return repository.findAll();
    }

    public Servis save(Servis servis) {
        return repository.save(servis);
    }

    public Servis getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servis tidak ditemukan"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Servis> getByKendaraanId(Long kendaraanId) {
        return repository.findByKendaraanId(kendaraanId);
    }

}