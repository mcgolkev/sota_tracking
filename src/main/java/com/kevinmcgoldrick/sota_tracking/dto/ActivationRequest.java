package com.kevinmcgoldrick.sota_tracking.dto;

import com.kevinmcgoldrick.sota_tracking.model.Mode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class ActivationRequest {

    @NotBlank
    @Size(max = 50)
    private String summitRef;

    @NotNull
    private LocalDate activationDate;

    @NotNull(message = "Frequency is required")
    @Positive(message = "Frequency must be positive")
    private Double frequencyMhz;

    @NotNull(message = "Mode is required")
    private Mode mode;

    @Size(max = 100)
    private String rig;

    @Size(max = 100)
    private String antenna;

    @Size(max = 2000)
    private String notes;


    public String getSummitRef() {
        return summitRef;
    }

    public void setSummitRef(String summitRef) {
        this.summitRef = summitRef;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public Double getFrequencyMhz() {
        return frequencyMhz;
    }

    public void setFrequencyMhz(Double frequencyMhz) {
        this.frequencyMhz = frequencyMhz;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public String getRig() {
        return rig;
    }

    public void setRig(String rig) {
        this.rig = rig;
    }

    public String getAntenna() {
        return antenna;
    }

    public void setAntenna(String antenna) {
        this.antenna = antenna;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
