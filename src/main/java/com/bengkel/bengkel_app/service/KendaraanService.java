package com.bengkel.bengkel_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.entity.Kendaraan;
import com.bengkel.bengkel_app.repository.KendaraanRepository;

@Service
public class KendaraanService {

    private final KendaraanRepository repository;

    public KendaraanService(KendaraanRepository repository) {
        this.repository = repository;
    }

    public List<Kendaraan> getAll() {
        return repository.findAll();
    }

    public Kendaraan save(Kendaraan kendaraan) {
        return repository.save(kendaraan);
    }

    public Kendaraan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Kendaraan tidak ditemukan"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}