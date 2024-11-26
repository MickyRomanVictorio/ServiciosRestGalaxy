package com.trabajo.galaxy.controller;

import com.trabajo.galaxy.entity.Persona;
import com.trabajo.galaxy.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping
    public Persona crearPersona(@Valid @RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {
        return personaService.obtenerPersonaPorId(id);
    }

    @GetMapping
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }

    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @Valid @RequestBody Persona persona) {
        return personaService.actualizarPersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
    }

}
