package com.bengkel.bengkel_app.dto;

import java.util.List;

import lombok.Data;

@Data
public class InvoiceResponse {

    private Long servisId;

    private String pelanggan;

    private String kendaraan;

    private Double biayaJasa;

    private List<InvoiceItemResponse> spareparts;

    private Double totalSparepart;

    private Double grandTotal;
}