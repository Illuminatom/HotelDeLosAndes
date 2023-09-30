package uniandes.edu.co.parranderos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.parranderos.modelo.TipoUsuario;
import uniandes.edu.co.parranderos.repositorio.TipoUsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tiposUsuarios")
    public String tiposUsuarios(Model model) {
        model.addAttribute("tiposUsuarios", tipoUsuarioRepository.darTiposUsuarios());
        return "tiposUsuarios";
    }

    @GetMapping("/tiposUsuarios/new")
    public String tipoUsuarioForm(Model model){
        model.addAttribute("tipoUsuario", new TipoUsuario());
        return "tipoUsuarioNuevo";
    }
    
    @PostMapping("/tiposUsuarios/new/save")
    public String tipoUsuarioGuardar(@ModelAttribute TipoUsuario tipoUsuario){
        tipoUsuarioRepository.insertarTipoUsuario(tipoUsuario.getId(), tipoUsuario.getNombre(), tipoUsuario.getDescripcion());
        return "redirect:/tiposUsuarios";
    }

    @GetMapping("/tiposUsuarios/{id}/edit")
    public String tipoUsuarioEditarForm(@PathVariable("id") int id, Model model){
        TipoUsuario tipoUsuario = tipoUsuarioRepository.darTipoUsuario(id);
        if(tipoUsuario!=null){
            model.addAttribute("tipoUsuario", tipoUsuario);
            return "tipoUsuarioEditar";
        }
        else{
            return "redirect:/tiposUsuarios";
        }
    }

    @PostMapping("/tiposUsuarios/{id}/edit/save")
    public String tipoUsuarioEditarGuardar(@PathVariable("id") int id, @ModelAttribute TipoUsuario tipoUsuario){
        tipoUsuarioRepository.actualizarTipoUsuario(id, tipoUsuario.getNombre(), tipoUsuario.getDescripcion());
        return "redirect:/tiposUsuarios";
    }

    @GetMapping("/tiposUsuarios/{id}/delete")
    public String tipoUsuarioEliminar(@PathVariable("id") int id){
        tipoUsuarioRepository.eliminarTipoUsuario(id);
        return "redirect:/tiposUsuarios";
    }
}
