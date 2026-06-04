package com.bengkel.bengkel_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.DetailServis;

public interface DetailServisRepository
        extends JpaRepository<DetailServis, Long> {

    List<DetailServis> findByServisId(Long servisId);

}