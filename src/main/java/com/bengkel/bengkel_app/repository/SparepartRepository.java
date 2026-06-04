package com.bengkel.bengkel_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.Sparepart;

public interface SparepartRepository
        extends JpaRepository<Sparepart, Long> {

}