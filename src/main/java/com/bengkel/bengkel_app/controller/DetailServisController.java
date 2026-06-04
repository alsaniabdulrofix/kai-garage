package com.bengkel.bengkel_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.entity.DetailServis;
import com.bengkel.bengkel_app.service.DetailServisService;

@RestController
@RequestMapping("/api/detail-servis")
public class DetailServisController {

    private final DetailServisService service;

    public DetailServisController(
            DetailServisService service) {

        this.service = service;
    }

    @GetMapping
    public List<DetailServis> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DetailServis getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @PostMapping
    public DetailServis create(
            @RequestBody DetailServis detailServis) {

        return service.save(detailServis);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        service.delete(id);
    }
}