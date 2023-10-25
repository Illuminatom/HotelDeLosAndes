package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.parranderos.modelo.ServicioPlan;
import uniandes.edu.co.parranderos.modelo.ServicioPlanPK;
import uniandes.edu.co.parranderos.repositorio.PlanRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioBasicoRepository;
import uniandes.edu.co.parranderos.repositorio.ServicioPlanRepository;

@Controller
public class ServicioPlanController {

    @Autowired
    private ServicioPlanRepository servicioPlanRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ServicioBasicoRepository servicioBasicoRepository;

    @GetMapping("/planes/{planId}/servicios")
    public String serviciosEnPlan(@PathVariable("planId") int planId, Model model) {
        model.addAttribute("serviciosEnPlan", servicioPlanRepository.darServiciosPlan(planId));
        model.addAttribute("plan", planRepository.darPlan(planId));
        return "serviciosPlanes";
    }

    @GetMapping("/planes/{planId}/servicios/new")
    public String agregarServicioForm(@PathVariable("planId") int planId, Model model) {
        ServicioPlanPK pk = new ServicioPlanPK();
        ServicioPlan servicioPlan = new ServicioPlan();
        servicioPlan.setPk(pk);
        model.addAttribute("servicioPlan", servicioPlan);
        model.addAttribute("planId", planId);
        model.addAttribute("servicioDado", servicioBasicoRepository.getReferenceById(1));
        model.addAttribute("serviciosBasicos", servicioBasicoRepository.darServiciosBasicos());
        return "servicioPlanNuevo";
    }

    @PostMapping("/planes/{planId}/servicios/new/save")
    public String agregarServicio(@ModelAttribute ServicioPlan servicioPlan) {
        servicioPlanRepository.insertarServicioPlan(servicioPlan.getPk().getPlan_id().getId(), servicioPlan.getPk().getServicioBasico_id().getId(), servicioPlan.getDescuento());
        return "redirect:/planes/{planId}/servicios";
    }
    

    // Editar un servicio en un plan
    @GetMapping("/planes/{planId}/servicios/{servicioBasicoId}/edit")
    public String editarServicioForm(@PathVariable("planId") int planId, @PathVariable("servicioBasicoId") int servicioBasicoId, Model model) {
        ServicioPlan servicioPlan = servicioPlanRepository.darServicioPlan(planId, servicioBasicoId);
        if (servicioPlan != null) {
            model.addAttribute("servicioPlan", servicioPlan);
            model.addAttribute("planId", planId);
            model.addAttribute("plan", planRepository.darPlan(planId));
            model.addAttribute("servicioDado", servicioBasicoRepository.getReferenceById(servicioBasicoId));
            model.addAttribute("serviciosBasicos", servicioBasicoRepository.darServiciosBasicos());
            return "servicioPlanEditar";
        } else {
            return "redirect:/planes/{planId}/servicios";
        }
    }

    @PostMapping("/planes/{planId}/servicios/{servicioBasicoId}/edit/save")
    public String editarServicio(@PathVariable("planId") int planId, @PathVariable("servicioBasicoId") int servicioBasicoId, @ModelAttribute ServicioPlan servicioPlan) {
        servicioPlanRepository.actualizarServicioPlan(planId, servicioBasicoId, planRepository.getReferenceById(planId).getId(), servicioBasicoRepository.getReferenceById(servicioBasicoId).getId(), servicioPlan.getDescuento());
        return "redirect:/planes/{planId}/servicios";
    }

    // Eliminar un servicio de un plan
    @GetMapping("/planes/{planId}/servicios/{servicioBasicoId}/delete")
    public String eliminarServicio(@PathVariable("planId") int planId, @PathVariable("servicioBasicoId") int servicioBasicoId) {
        servicioPlanRepository.eliminarServicioPlan(planId, servicioBasicoId);
        return "redirect:/planes/{planId}/servicios";
    }
}
