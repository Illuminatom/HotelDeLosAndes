package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.repositorios.HabitacionRepository;
import uniandes.edu.co.parranderos.modelo.Habitacion;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    
    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping
    public String habitaciones(Model model) {
        Collection<Habitacion> habitaciones = habitacionRepository.findAll();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }
}
