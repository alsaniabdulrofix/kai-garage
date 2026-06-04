package com.bengkel.bengkel_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.entity.Kendaraan;
import com.bengkel.bengkel_app.service.KendaraanService;

@RestController
@RequestMapping("/api/kendaraan")
public class KendaraanController {

    private final KendaraanService service;

    public KendaraanController(KendaraanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Kendaraan> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Kendaraan getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Kendaraan create(@RequestBody Kendaraan kendaraan) {
        return service.save(kendaraan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}