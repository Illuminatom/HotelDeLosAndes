package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.Habitacion;
import uniandes.edu.co.parranderos.modelo.Reserva;
import uniandes.edu.co.parranderos.repositorios.ClienteRepository;
import uniandes.edu.co.parranderos.repositorios.HabitacionRepository;
import uniandes.edu.co.parranderos.repositorios.ReservaRepository;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
     
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "fechaEntrada", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
        binder.registerCustomEditor(Date.class, "fechaSalida", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @GetMapping 
    public String listarReservas(Model model) {
        Collection<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "reservas";
    }

    @GetMapping("/new")
    public String nuevaReserva(Model model) {
        Reserva nuevaReserva = new Reserva();
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        model.addAttribute("reserva", nuevaReserva);
        return "reservaNuevo";
    }

    @PostMapping("/new/save")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {

        Cliente cliente = clienteRepository.findByDocumento(reserva.getIdCliente());
        reserva.setCliente(cliente);
        
        Habitacion habitacion = habitacionRepository.findById(reserva.getIdHabitacion());
        reserva.setHabitacion(habitacion);
        
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/{id}/edit")
    public String editarReserva(@PathVariable("id") String id, Model model) {
        Reserva reserva = reservaRepository.findById(id);
        reserva.setIdCliente(reserva.getCliente().getDocumento());
        reserva.setIdHabitacion(reserva.getHabitacion().getId());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        model.addAttribute("reserva", reserva);
        return "reservaEditar";
    }

    @PostMapping("/{id}/edit/save")
    public String guardarReservaEditada(@ModelAttribute("reserva") Reserva reserva) {
        Cliente cliente = clienteRepository.findByDocumento(reserva.getIdCliente());
        reserva.setCliente(cliente);
        
        Habitacion habitacion = habitacionRepository.findById(reserva.getIdHabitacion());
        reserva.setHabitacion(habitacion);
        
        reservaRepository.deleteById(reserva.getId());
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/{id}/delete")
    public String eliminarReserva(@PathVariable("id") String id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }
}

