package com.kevinmcgoldrick.sota_tracking.dto;

import com.kevinmcgoldrick.sota_tracking.model.Activation;

import java.time.LocalDate;

public class ActivationResponse {

    private Long id;
    private String summitRef;
    private LocalDate activationDate;
    private Double frequencyMhz;
    private String mode;
    private String rig;
    private String antenna;
    private String notes;

    public static ActivationResponse fromEntity(Activation activation) {
        ActivationResponse dto = new ActivationResponse();
        dto.id = activation.getId();
        dto.summitRef = activation.getSummitRef();
        dto.activationDate = activation.getActivationDate();
        dto.frequencyMhz = activation.getFrequencyMhz();
        dto.mode = activation.getMode().name();
        dto.rig = activation.getRig();
        dto.antenna = activation.getAntenna();
        dto.notes = activation.getNotes();
        return dto;
    }


    public Long getId() {
        return id;
    }

    public String getSummitRef() {
        return summitRef;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public Double getFrequencyMhz() {
        return frequencyMhz;
    }

    public String getMode() {
        return mode;
    }

    public String getRig() {
        return rig;
    }

    public String getAntenna() {
        return antenna;
    }

    public String getNotes() {
        return notes;
    }
}
