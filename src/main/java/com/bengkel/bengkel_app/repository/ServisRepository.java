package com.bengkel.bengkel_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.Servis;

public interface ServisRepository
        extends JpaRepository<Servis, Long> {

    List<Servis> findByKendaraanId(Long kendaraanId);

}