package com.bengkel.bengkel_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.Servis;

public interface ServisRepository
        extends JpaRepository<Servis, Long> {
}