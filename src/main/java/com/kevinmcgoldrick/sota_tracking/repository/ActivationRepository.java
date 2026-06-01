package com.kevinmcgoldrick.sota_tracking.repository;

import com.kevinmcgoldrick.sota_tracking.model.Activation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationRepository extends JpaRepository<Activation, Long> {
}
