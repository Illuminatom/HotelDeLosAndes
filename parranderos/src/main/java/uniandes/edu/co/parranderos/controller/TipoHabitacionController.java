package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.parranderos.modelo.TipoHabitacion;
import uniandes.edu.co.parranderos.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitaciones")
    public String tiposHabitaciones(Model model) {
        model.addAttribute("tiposHabitaciones", tipoHabitacionRepository.darTiposHabitacion());
        return "tiposHabitaciones";
    } 

    @GetMapping("/tiposHabitaciones/new")
    public String tipoHabitacionForm(Model model){
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tiposHabitaciones/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion){
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getId(), tipoHabitacion.getNombre(), tipoHabitacion.getCapacidad(), tipoHabitacion.getPrecioNoche());
        return "redirect:/tiposHabitaciones";
    }

    @GetMapping("/tiposHabitaciones/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") int id, Model model){
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacionPorId(id);
        if(tipoHabitacion!=null){
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        }
        else{
            return "redirect:/tiposHabitaciones";
        }
    }

    @PostMapping("/tiposHabitaciones/{id}/edit/save")
    public String tipoHabitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoHabitacion tipoHabitacion){
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre(), tipoHabitacion.getCapacidad(), tipoHabitacion.getPrecioNoche());
        return "redirect:/tiposHabitaciones";
    }

    @GetMapping("/tiposHabitaciones/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") int id){
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tiposHabitaciones";
    }
}
