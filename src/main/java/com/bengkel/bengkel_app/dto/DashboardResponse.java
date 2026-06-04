package com.bengkel.bengkel_app.dto;

import lombok.Data;

@Data
public class DashboardResponse {

    private Long totalPelanggan;

    private Long totalKendaraan;

    private Long totalServis;

    private Long totalSparepart;
}