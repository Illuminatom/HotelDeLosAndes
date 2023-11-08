package uniandes.edu.co.parranderos.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.parranderos.modelo.Cliente;
import uniandes.edu.co.parranderos.modelo.ClientePK;
import uniandes.edu.co.parranderos.modelo.Usuario;
import uniandes.edu.co.parranderos.repositorio.ClienteRepository;
import uniandes.edu.co.parranderos.repositorio.UsuarioRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/clientes")
    public String clientes(Model model){
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("clientes/buenos-clientes")
    public String clientesBuenos(Model model, @RequestParam(name = "limit", required = false) Integer limit){
        if (limit == null){
            limit = 100;
        }
        Collection<Cliente> clientes = clienteRepository.darClientesParcial(limit);
        model.addAttribute("clientes", clientes);

        Collection<Cliente> clientesBuenos = clienteRepository.darClientesParcial(limit);
        clientesBuenos.clear();
        
        Map<Integer, Integer> consumoServicios = new HashMap<>();
        Map<Integer, Integer> consumoProductos = new HashMap<>();
        Map<Integer, Integer> diasEstadia = new HashMap<>();

        for (Cliente cliente : clientes) {
            Integer clienteId = cliente.getPk().getDocumento().getDocumento();
            Integer consumoServicio = clienteRepository.darConsumoServiciosClienteUltimoAnio(clienteId);
            if (consumoServicio == null){
                consumoServicio = 0;
            }
            consumoServicios.put(clienteId, consumoServicio);
            
            Integer consumoProducto = clienteRepository.darConsumoProductoClienteUltimoAnio(clienteId);
            if (consumoProducto == null){
                consumoProducto = 0;
            }
            consumoProductos.put(clienteId, consumoProducto);

            Integer diasAlojado = clienteRepository.darDiasOcupadaUltimoAnio(clienteId);
            if (diasAlojado == null){
                diasAlojado = 0;
            }
            diasEstadia.put(clienteId, diasAlojado);

            if (consumoServicio + consumoProducto > 15000000 || diasAlojado >= 14){
                clientesBuenos.add(cliente);
            }
        }

        model.addAttribute("diasEstadia", diasEstadia);
        model.addAttribute("consumoProductos", consumoProductos);
        model.addAttribute("consumoServicios", consumoServicios);
        model.addAttribute("clientesBuenos", clientesBuenos);
        return "clientesBuenos";
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute("documento") int documento, @ModelAttribute("metodoPago") String metodoPago){

        Usuario usuario = usuarioRepository.darUsuario(documento);

        ClientePK pk = new ClientePK(usuario);
        Cliente cliente = new Cliente();
        cliente.setPk(pk);
        clienteRepository.insertarCliente(pk.getDocumento().getDocumento(), metodoPago);
        return "redirect:/clientes";
    }



}
