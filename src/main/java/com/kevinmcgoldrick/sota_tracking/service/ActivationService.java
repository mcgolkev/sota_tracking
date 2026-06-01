package com.kevinmcgoldrick.sota_tracking.service;

import com.kevinmcgoldrick.sota_tracking.dto.ActivationRequest;
import com.kevinmcgoldrick.sota_tracking.model.Activation;
import com.kevinmcgoldrick.sota_tracking.repository.ActivationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActivationService {

    private final ActivationRepository activationRepository;

    public ActivationService(ActivationRepository activationRepository) {
        this.activationRepository = activationRepository;
    }

    public List<Activation> getAllActivations() {
        return activationRepository.findAll();
    }

    public Activation createActivation(ActivationRequest request) {
        Activation activation = new Activation();
        activation.setSummitRef(request.getSummitRef());
        activation.setActivationDate(request.getActivationDate());
        activation.setFrequencyMhz(request.getFrequencyMhz());
        activation.setMode(request.getMode());
        activation.setRig(request.getRig());
        activation.setAntenna(request.getAntenna());
        activation.setNotes(request.getNotes());

        return activationRepository.save(activation);
    }
}
