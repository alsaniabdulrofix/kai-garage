package com.bengkel.bengkel_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.entity.Servis;
import com.bengkel.bengkel_app.service.ServisService;

@RestController
@RequestMapping("/api/servis")
public class ServisController {

    private final ServisService service;

    public ServisController(ServisService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servis> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Servis getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Servis create(@RequestBody Servis servis) {
        return service.save(servis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/kendaraan/{id}")
    public List<Servis> getRiwayatServis(
        @PathVariable Long id) {

        return service.getByKendaraanId(id);
    }
}