package com.trabajo.galaxy.service;

import com.trabajo.galaxy.entity.Persona;
import java.util.List;

public interface PersonaService {
    Persona guardarPersona(Persona persona);
    Persona obtenerPersonaPorId(Long id);
    List<Persona> listarPersonas();
    Persona actualizarPersona(Long id, Persona persona);
    void eliminarPersona(Long id);
}
