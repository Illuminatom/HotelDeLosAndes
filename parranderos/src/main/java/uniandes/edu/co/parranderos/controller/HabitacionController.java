package uniandes.edu.co.parranderos.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.parranderos.repositorios.HabitacionRepository;
import uniandes.edu.co.parranderos.repositorios.HotelRepository;
import uniandes.edu.co.parranderos.repositorios.TipoHabitacionRepository;
import uniandes.edu.co.parranderos.modelo.Habitacion;
import uniandes.edu.co.parranderos.modelo.Hotel;
import uniandes.edu.co.parranderos.modelo.TipoHabitacion;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionController {
    
    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping
    public String habitaciones(Model model) {
        Collection<Habitacion> habitaciones = habitacionRepository.findAll();
        model.addAttribute("habitaciones", habitaciones);
        return "habitaciones";
    }

    @GetMapping("/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("hoteles", hotelRepository.findAll());
        model.addAttribute("tiposHabitaciones", tipoHabitacionRepository.findAll());
        return "habitacionNuevo";
    }

    @PostMapping("/new/save")
    public String saveHabitacion(@ModelAttribute Habitacion habitacion) {
        Hotel hotel = hotelRepository.findById(habitacion.getHotelId());
        habitacion.setHotel(hotel);

        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(habitacion.getTipoHabitacionId());
        habitacion.setTipoHabitacion(tipoHabitacion);
        
        habitacionRepository.save(habitacion);
        return "redirect:/habitaciones";
    }    
}
