package com.bengkel.bengkel_app.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detail_servis")
@Data
@NoArgsConstructor
public class DetailServis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer jumlah;

    @ManyToOne
    @JoinColumn(name = "servis_id")
    private Servis servis;

    @ManyToOne
    @JoinColumn(name = "sparepart_id")
    private Sparepart sparepart;
}