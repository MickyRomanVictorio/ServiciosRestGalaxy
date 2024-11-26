package com.trabajo.galaxy.service;

import com.trabajo.galaxy.entity.Persona;
import com.trabajo.galaxy.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona existente = obtenerPersonaPorId(id);
        existente.setNombre(persona.getNombre());
        existente.setApellido(persona.getApellido());
        existente.setEdad(persona.getEdad());
        existente.setCorreo(persona.getCorreo());
        return personaRepository.save(existente);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

}
