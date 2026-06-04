package com.bengkel.bengkel_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.entity.Pelanggan;
import com.bengkel.bengkel_app.repository.PelangganRepository;

@Service
public class PelangganService {

    private final PelangganRepository repository;

    public PelangganService(PelangganRepository repository) {
        this.repository = repository;
    }

    public List<Pelanggan> getAll() {
        return repository.findAll();
    }

    public Pelanggan save(Pelanggan pelanggan) {
        return repository.save(pelanggan);
    }

    public Pelanggan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelanggan tidak ditemukan"));
    }

    public Pelanggan update(Long id, Pelanggan data) {

        Pelanggan pelanggan = getById(id);

        pelanggan.setNama(data.getNama());
        pelanggan.setNomorHp(data.getNomorHp());
        pelanggan.setAlamat(data.getAlamat());

        return repository.save(pelanggan);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    
}