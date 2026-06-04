package com.bengkel.bengkel_app.entity;

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
@Table(name = "kendaraan")
@Data
@NoArgsConstructor
public class Kendaraan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomorPolisi;
    private String merk;
    private String tipe;
    private Integer tahun;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id")
    private Pelanggan pelanggan;
}