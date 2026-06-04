package com.bengkel.bengkel_app.controller;

import java.util.List; // <-- tambahkan ini

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.entity.Pelanggan;
import com.bengkel.bengkel_app.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

    private final PelangganService service;

    public PelangganController(PelangganService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelanggan> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Pelanggan create(@RequestBody Pelanggan pelanggan) {
        return service.save(pelanggan);
    }

    @GetMapping("/{id}")
    public Pelanggan getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Pelanggan update(
        @PathVariable Long id,
        @RequestBody Pelanggan pelanggan) {

        return service.update(id, pelanggan);
    
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}