package uniandes.edu.co.parranderos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/{id}/edit")
    public String editarTipoHabitacion(@PathVariable("id") String id, Model model) {
        TipoHabitacion tipoHabitacion = tipohabitacionRepository.findById(id);
        model.addAttribute("tipoHabitacion", tipoHabitacion);
        return "tipoHabitacionEditar"; 
    }

    
    @PostMapping("/{id}/edit/save")
    public String actualizarTipoHabitacion(@ModelAttribute("tipoHabitacion") TipoHabitacion tipoHabitacion, @PathVariable("id") String id) {
        // Asumiendo que la lógica de negocio no requiere borrar la entrada actual antes de guardar
        tipohabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitaciones"; 
    }

    
    @GetMapping("/{id}/delete")
    public String eliminarTipoHabitacion(@PathVariable("id") String id) {
        tipohabitacionRepository.deleteById(id);
        return "redirect:/tiposHabitaciones"; 
    }
}



   




    




    



   