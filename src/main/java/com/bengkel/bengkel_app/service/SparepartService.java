package com.bengkel.bengkel_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.entity.Sparepart;
import com.bengkel.bengkel_app.repository.SparepartRepository;

@Service
public class SparepartService {

    private final SparepartRepository repository;

    public SparepartService(
            SparepartRepository repository) {

        this.repository = repository;
    }

    public List<Sparepart> getAll() {
        return repository.findAll();
    }

    public Sparepart save(
            Sparepart sparepart) {

        return repository.save(sparepart);
    }

    public Sparepart getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Sparepart tidak ditemukan"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}