package com.bengkel.bengkel_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bengkel.bengkel_app.entity.Kendaraan;

public interface KendaraanRepository
                extends JpaRepository<Kendaraan, Long> {

        List<Kendaraan> findByNomorPolisiContaining(String nomorPolisi);


}