package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.parranderos.modelo.Reserva;
import uniandes.edu.co.parranderos.repositorios.ReservaRepository;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ReservaController {
     
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping 
    public String listarReservas(Model model) {
        Collection<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "reservas";
    }

    @GetMapping("/new")
    public String nuevaReserva(Model model) {
        Reserva nuevaReserva = new Reserva();
        model.addAttribute("reserva", nuevaReserva);
        return "reservaNuevo";
    }

    @PostMapping("/save")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }


}

