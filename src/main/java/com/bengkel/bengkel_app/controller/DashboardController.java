package com.bengkel.bengkel_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bengkel.bengkel_app.dto.DashboardResponse;
import com.bengkel.bengkel_app.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(
            DashboardService service) {

        this.service = service;
    }

    @GetMapping
    public DashboardResponse getDashboard() {

        return service.getDashboard();
    }
}