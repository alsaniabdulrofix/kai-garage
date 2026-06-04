package com.bengkel.bengkel_app.service;

import org.springframework.stereotype.Service;

import com.bengkel.bengkel_app.dto.DashboardResponse;
import com.bengkel.bengkel_app.repository.KendaraanRepository;
import com.bengkel.bengkel_app.repository.PelangganRepository;
import com.bengkel.bengkel_app.repository.ServisRepository;
import com.bengkel.bengkel_app.repository.SparepartRepository;

@Service
public class DashboardService {

    private final PelangganRepository pelangganRepository;
    private final KendaraanRepository kendaraanRepository;
    private final ServisRepository servisRepository;
    private final SparepartRepository sparepartRepository;

    public DashboardService(
            PelangganRepository pelangganRepository,
            KendaraanRepository kendaraanRepository,
            ServisRepository servisRepository,
            SparepartRepository sparepartRepository) {

        this.pelangganRepository = pelangganRepository;
        this.kendaraanRepository = kendaraanRepository;
        this.servisRepository = servisRepository;
        this.sparepartRepository = sparepartRepository;
    }

    public DashboardResponse getDashboard() {

        DashboardResponse response =
                new DashboardResponse();

        response.setTotalPelanggan(
                pelangganRepository.count());

        response.setTotalKendaraan(
                kendaraanRepository.count());

        response.setTotalServis(
                servisRepository.count());

        response.setTotalSparepart(
                sparepartRepository.count());

        return response;
    }
}