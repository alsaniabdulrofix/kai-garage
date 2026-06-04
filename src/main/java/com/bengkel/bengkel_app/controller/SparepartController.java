package com.bengkel.bengkel_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.entity.Sparepart;
import com.bengkel.bengkel_app.service.SparepartService;

@RestController
@RequestMapping("/api/sparepart")
public class SparepartController {

    private final SparepartService service;

    public SparepartController(
            SparepartService service) {

        this.service = service;
    }

    @GetMapping
    public List<Sparepart> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Sparepart getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @PostMapping
    public Sparepart create(
            @RequestBody Sparepart sparepart) {

        return service.save(sparepart);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}