package com.bengkel.bengkel_app.dto;

import lombok.Data;

@Data
public class InvoiceItemResponse {

    private String nama;

    private Double harga;

    private Integer jumlah;

    private Double subtotal;
}