package com.CComercial.app.controller;

import com.CComercial.app.repository.*; // Añadir la referencia al repositorio de tiendas
import com.CComercial.app.variables.Cliente;
import com.CComercial.app.repository.ClienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.CComercial.app.variables.*;
@Controller
@RequestMapping("/clientes")
public class ClienteWebController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TiendaRepository tiendaRepository; // Inyectamos el repositorio de tiendas
    
    @Autowired
    private ProductosRepository productosRepository;

    // Mostrar todos los clientes
    @GetMapping
    public String showClientes(Model model) {
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes"; // Vista para mostrar los clientes
    }

    // Mostrar todas las tiendas para los clientes
    @GetMapping("/tiendasCliente")
    public String showTiendas(Model model) {
        model.addAttribute("tiendas", tiendaRepository.findAll()); // Añadimos la lista de tiendas al modelo
        return "listadeTiendas"; 
    }
    
    @GetMapping("/tiendas/{id}")
    public String showTiendaDetails(@PathVariable String id, Model model) {
        // Buscar la tienda por su ID
        Tienda tienda = tiendaRepository.findById(id).orElse(null);
        if (tienda == null) {
            model.addAttribute("error", "La tienda no existe.");
            return "error"; // Página de error
        }

        // Agregar la tienda al modelo
        model.addAttribute("tienda", tienda);

        // Obtener todos los productos sin filtrar
        List<Productos> productos = productosRepository.findAll();

        // Agregar productos al modelo
        model.addAttribute("productos", productos);

        return "detallesTienda"; // Vista de los detalles de la tienda
    }

    // Mostrar formulario para crear un nuevo cliente
    @GetMapping("/nuevo")
    public String showCreateClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registroCliente";
    }

    // Guardar nuevo cliente
    @PostMapping("/guardar")
    public String saveCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/cliente-login";
    }

    // Mostrar formulario para editar cliente
    @GetMapping("/editar/{id}")
    public String showEditClienteForm(@PathVariable String id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "clienteeditar";
    }

    // Actualizar cliente
    @PostMapping("/actualizar/{id}")
    public String updateCliente(@PathVariable String id, @ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String deleteCliente(@PathVariable String id) {
        clienteRepository.deleteById(id);
        return "redirect:/clientes";
    }
}
