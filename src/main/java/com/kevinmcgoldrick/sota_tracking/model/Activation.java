package com.kevinmcgoldrick.sota_tracking.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "activations")
public class Activation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "summit_ref", nullable = false, length = 50)
    private String summitRef;

    @Column(name = "activation_date", nullable = false)
    private LocalDate activationDate;

    @Column(name = "frequency_mhz", nullable = false)
    private Double frequencyMhz;

    @Enumerated(EnumType.STRING)
    @Column(name = "mode", nullable = false)
    private Mode mode;

    @Column(name = "rig")
    private String rig;

    @Column(name = "antenna")
    private String antenna;

    @Column(name = "notes", length = 2000)
    private String notes;

    // ----- getters & setters -----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
