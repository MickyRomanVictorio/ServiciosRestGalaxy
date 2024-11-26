package com.trabajo.galaxy.repository;

import com.trabajo.galaxy.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
