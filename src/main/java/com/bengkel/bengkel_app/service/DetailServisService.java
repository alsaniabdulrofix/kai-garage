package com.bengkel.bengkel_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.entity.DetailServis;
import com.bengkel.bengkel_app.entity.Sparepart;
import com.bengkel.bengkel_app.repository.DetailServisRepository;
import com.bengkel.bengkel_app.repository.SparepartRepository;

@Service
public class DetailServisService {

    private final DetailServisRepository repository;
    private final SparepartRepository sparepartRepository;

    public DetailServisService(
            DetailServisRepository repository,
            SparepartRepository sparepartRepository) {

        this.repository = repository;
        this.sparepartRepository = sparepartRepository;
    }

    public List<DetailServis> getAll() {
        return repository.findAll();
    }

    public DetailServis save(DetailServis detailServis) {

        Long sparepartId =
                detailServis.getSparepart().getId();

        Sparepart sparepart =
                sparepartRepository.findById(sparepartId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Sparepart tidak ditemukan"));

        Integer stokSaatIni =
                sparepart.getStok();

        Integer jumlahDipakai =
                detailServis.getJumlah();

        if (stokSaatIni < jumlahDipakai) {

            throw new RuntimeException(
                    "Stok sparepart tidak mencukupi");
        }

        sparepart.setStok(
                stokSaatIni - jumlahDipakai);

        sparepartRepository.save(sparepart);

        return repository.save(detailServis);
    }

    public DetailServis getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Detail servis tidak ditemukan"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}