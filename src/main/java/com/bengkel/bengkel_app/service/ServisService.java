package com.bengkel.bengkel_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.dto.InvoiceItemResponse;
import com.bengkel.bengkel_app.dto.InvoiceResponse;
import com.bengkel.bengkel_app.entity.DetailServis;
import com.bengkel.bengkel_app.entity.Servis;
import com.bengkel.bengkel_app.repository.DetailServisRepository;
import com.bengkel.bengkel_app.repository.ServisRepository;

@Service
public class ServisService {

    private final ServisRepository repository;
    private final DetailServisRepository detailRepository;

    public ServisService(
            ServisRepository repository,
            DetailServisRepository detailRepository) {

        this.repository = repository;
        this.detailRepository = detailRepository;
    }

    public List<Servis> getAll() {
        return repository.findAll();
    }

    public Servis save(Servis servis) {
        return repository.save(servis);
    }

    public Servis getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Servis tidak ditemukan"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Servis> getByKendaraanId(Long kendaraanId) {
        return repository.findByKendaraanId(kendaraanId);
    }

    public InvoiceResponse getInvoice(Long servisId) {

        Servis servis = getById(servisId);

        List<DetailServis> detailList =
                detailRepository.findByServisId(servisId);

        double totalSparepart = 0;

        List<InvoiceItemResponse> items =
                new ArrayList<>();

        for (DetailServis detail : detailList) {

            double subtotal =
                    detail.getJumlah()
                            * detail.getSparepart().getHarga();

            totalSparepart += subtotal;

            InvoiceItemResponse item =
                    new InvoiceItemResponse();

            item.setNama(
                    detail.getSparepart().getNama());

            item.setHarga(
                    detail.getSparepart().getHarga());

            item.setJumlah(
                    detail.getJumlah());

            item.setSubtotal(
                    subtotal);

            items.add(item);
        }

        InvoiceResponse response =
                new InvoiceResponse();

        response.setServisId(
                servis.getId());

        response.setPelanggan(
                servis.getKendaraan()
                        .getPelanggan()
                        .getNama());

        response.setKendaraan(
                servis.getKendaraan()
                        .getNomorPolisi());

        response.setBiayaJasa(
                servis.getBiayaJasa());

        response.setSpareparts(
                items);

        response.setTotalSparepart(
                totalSparepart);

        response.setGrandTotal(
                servis.getBiayaJasa()
                        + totalSparepart);

        return response;
    }
}