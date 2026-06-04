package com.bengkel.bengkel_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.Kendaraan;

public interface KendaraanRepository
        extends JpaRepository<Kendaraan, Long> {
}