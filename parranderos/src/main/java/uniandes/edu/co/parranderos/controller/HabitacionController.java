package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Habitacion;
import uniandes.edu.co.parranderos.modelo.Hotel;
import uniandes.edu.co.parranderos.modelo.TipoHabitacion;
import uniandes.edu.co.parranderos.repositorio.HabitacionRepository;
import uniandes.edu.co.parranderos.repositorio.HotelRepository;
import uniandes.edu.co.parranderos.repositorio.TipoHabitacionRepository;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model, @RequestParam(name = "piso", required = false) Integer piso, @RequestParam(name = "techo", required = false) Integer techo) {
        
        if (piso == null) {
            piso = 0;
        }

        if (techo == null) {
            techo = 50;
        }
        
        Collection<Habitacion> habitaciones = habitacionRepository.darHabitacionesEnIntervalo(piso, techo);
        
        model.addAttribute("habitaciones", habitaciones);

        Map<Integer, Integer> costosProductos = new HashMap<>();
        Map<Integer, Integer> costosServicios = new HashMap<>();

        for (Habitacion habitacion : habitaciones) {
            int idHabitacion = habitacion.getId();
            Integer costoProductos = habitacionRepository.darCostoTotalProductosPorHabitacion(idHabitacion);
            Integer costoServicios = habitacionRepository.darCostoTotalServiciosPorHabitacion(idHabitacion);
            
            if(costoProductos == null) {
                costoProductos = 0;
            }
            if(costoServicios == null) {
                costoServicios = 0;
            }
            costosProductos.put(idHabitacion, costoProductos);
            costosServicios.put(idHabitacion, costoServicios);
        }

        DecimalFormat df = new DecimalFormat("#.##");
        Map<Integer, Double> porcentajesOcupacion = new HashMap<>();
        for (Habitacion habitacion : habitaciones){
            int idHabitacion = habitacion.getId();
            Double duracionReserva = habitacionRepository.darDuracionReservaPorHabitacionEnElUltimoAnio(idHabitacion);
            if(duracionReserva == null) {
                duracionReserva = 0.0;
            }
            double porcentajeRedondeado = Double.parseDouble(df.format((duracionReserva / 365) * 100));
            porcentajesOcupacion.put(idHabitacion, porcentajeRedondeado);
        }

        model.addAttribute("porcentajesOcupacion", porcentajesOcupacion);
        model.addAttribute("costosProductos", costosProductos);
        model.addAttribute("costosServicios", costosServicios);

        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        Collection<Hotel> hoteles = hotelRepository.darHoteles();
        Collection<TipoHabitacion> tiposHabitaciones= tipoHabitacionRepository.darTiposHabitacion();
        model.addAttribute("habitacion", new Habitacion());
        model.addAttribute("hoteles", hoteles);
        model.addAttribute("tiposHabitaciones", tiposHabitaciones);
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getId(),habitacion.getDisponible(), habitacion.getHotel_id().getId(), habitacion.getTipoHabitacion_id().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        Collection<Hotel> hoteles = hotelRepository.darHoteles();
        Collection<TipoHabitacion> tiposHabitaciones= tipoHabitacionRepository.darTiposHabitacion();

        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            model.addAttribute("hoteles", hoteles);
            model.addAttribute("tiposHabitaciones", tiposHabitaciones);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(id, habitacion.getDisponible(), habitacion.getHotel_id().getId(), habitacion.getTipoHabitacion_id().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionBorrar(@PathVariable("id") int id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
}
