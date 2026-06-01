package com.kevinmcgoldrick.sota_tracking.controller;

import com.kevinmcgoldrick.sota_tracking.model.Activation;
import com.kevinmcgoldrick.sota_tracking.service.ActivationService;
import org.springframework.web.bind.annotation.*;
import com.kevinmcgoldrick.sota_tracking.dto.ActivationRequest;
import com.kevinmcgoldrick.sota_tracking.dto.ActivationResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/activations")
public class ActivationsController {

    private final ActivationService activationService;

    public ActivationsController(ActivationService activationService) {
        this.activationService = activationService;
    }

    @GetMapping
    public List<Activation> getAll() {
        return activationService.getAllActivations();
    }

    @PostMapping
    public ResponseEntity<ActivationResponse> create(@Valid @RequestBody ActivationRequest request) {
        Activation created = activationService.createActivation(request);
        return ResponseEntity.ok(ActivationResponse.fromEntity(created));
    }
}