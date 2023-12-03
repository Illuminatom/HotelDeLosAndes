package uniandes.edu.co.parranderos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.TipoHabitacion;
import uniandes.edu.co.parranderos.repositorios.TipoHabitacionRepository;
import java.util.Collection;

@Controller
@RequestMapping("/tiposHabitaciones")
public class TipoHabitacionController {
     
    @Autowired
    private TipoHabitacionRepository tipohabitacionRepository;

    @GetMapping 
    public String tiposhabitaciones(Model model) {
        Collection<TipoHabitacion> tiposhabitaciones = tipohabitacionRepository.findAll();
        model.addAttribute("tiposHabitaciones", tiposhabitaciones);
        return "tiposhabitaciones";
    }

    @GetMapping("/new")
    public String NuevoTipoHabitacion(Model model) {
    TipoHabitacion tipoHabitacionNuevo = new TipoHabitacion();
    model.addAttribute("tipoHabitacion", tipoHabitacionNuevo);
    return "tipoHabitacionNuevo";
    }  

    @PostMapping("/save")
    public String guardarTipoHabitacion(@ModelAttribute("tipoHabitacion") TipoHabitacion tipoHabitacion) {
    tipohabitacionRepository.save(tipoHabitacion);
    return "redirect:/tiposHabitaciones";
}
    




    
    
}
