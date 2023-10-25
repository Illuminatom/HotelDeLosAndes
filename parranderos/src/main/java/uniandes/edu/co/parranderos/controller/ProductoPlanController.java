package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.parranderos.modelo.ProductoPlan;
import uniandes.edu.co.parranderos.modelo.ProductoPlanPK;
import uniandes.edu.co.parranderos.modelo.ServicioPlan;
import uniandes.edu.co.parranderos.modelo.ServicioPlanPK;
import uniandes.edu.co.parranderos.repositorio.PlanRepository;
import uniandes.edu.co.parranderos.repositorio.ProductoPlanRepository;
import uniandes.edu.co.parranderos.repositorio.ProductoRepository;

@Controller
public class ProductoPlanController {

    @Autowired
    private ProductoPlanRepository productoPlanRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/planes/{planId}/productos")
    public String productosEnPlan(@PathVariable("planId") int planId, Model model) {
        model.addAttribute("productosEnPlan", productoPlanRepository.darProductosPlan(planId));
        model.addAttribute("plan", planRepository.darPlan(planId));
        return "productosPlanes";
    }

    @GetMapping("/planes/{planId}/productos/new")
    public String agregarProductoForm(@PathVariable("planId") int planId, Model model) {
        ServicioPlanPK pk = new ServicioPlanPK();
        ServicioPlan servicioPlan = new ServicioPlan();
        servicioPlan.setPk(pk);
        model.addAttribute("productoPlan", new ProductoPlan());
        model.addAttribute("planId", planId);
        model.addAttribute("productoDado", productoRepository.getReferenceById(1));
        model.addAttribute("productos", productoRepository.darProductos());
        return "productoPlanNuevo";
    }

    @PostMapping("/planes/{planId}/productos/new/save")
    public String agregarProducto(@PathVariable("planId") int planId, @ModelAttribute ProductoPlan productoPlan) {
        ProductoPlanPK pk = new ProductoPlanPK(productoPlan.getPk().getProducto_id(), planRepository.getReferenceById(planId));
        productoPlan.setPk(pk);
        productoPlanRepository.insertarProductoPlan(productoPlan.getPk().getProducto_id().getId(), productoPlan.getPk().getPlan_id().getId(), productoPlan.getCantidad(), productoPlan.getDescripcion());
        return "redirect:/planes/{planId}/productos";
    }

    @GetMapping("/planes/{planId}/productos/{productoId}/edit")
    public String editarProductoForm(@PathVariable("planId") int planId, @PathVariable("productoId") int productoId, Model model) {
        ProductoPlan productoPlan = productoPlanRepository.darProductoPlan(productoId, planId);
        if (productoPlan != null) {
            model.addAttribute("productoPlan", productoPlan);
            model.addAttribute("planId", planId);
            model.addAttribute("plan", planRepository.darPlan(planId));
            model.addAttribute("productoDado", productoRepository.getReferenceById(productoId));
            model.addAttribute("productos", productoRepository.darProductos());
            return "productoPlanEditar";
        } else {
            return "redirect:/planes/{planId}/productos";
        }
    }

    @PostMapping("/planes/{planId}/productos/{productoId}/edit/save")
    public String editarProducto(@PathVariable("planId") int planId, @PathVariable("productoId") int productoId, @ModelAttribute ProductoPlan productoPlan) {
        productoPlanRepository.actualizarProductoPlan(productoId, planId, productoPlan.getPk().getProducto_id().getId(), productoPlan.getPk().getPlan_id().getId(), productoPlan.getCantidad(), productoPlan.getDescripcion());
        return "redirect:/planes/{planId}/productos";
    }

    @GetMapping("/planes/{planId}/productos/{productoId}/delete")
    public String eliminarProducto(@PathVariable("planId") int planId, @PathVariable("productoId") int productoId) {
        productoPlanRepository.eliminarProductoPlan(productoId, planId);
        return "redirect:/planes/{planId}/productos";
    }
}