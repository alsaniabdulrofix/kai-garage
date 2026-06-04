package com.bengkel.bengkel_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bengkel.bengkel_app.entity.Pelanggan;

public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
}