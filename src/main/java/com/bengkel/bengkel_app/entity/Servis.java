package com.bengkel.bengkel_app.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servis")
@Data
@NoArgsConstructor
public class Servis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate tanggalServis;

    private String keluhan;

    private String tindakan;

    private Double biayaJasa;

    private String status;

    @ManyToOne
    @JoinColumn(name = "kendaraan_id")
    private Kendaraan kendaraan;
}