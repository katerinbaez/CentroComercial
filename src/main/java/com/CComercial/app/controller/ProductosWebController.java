package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CComercial.app.variables.Empleado;
import com.CComercial.app.variables.Productos;
import com.CComercial.app.repository.ProductosRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/productos")
public class ProductosWebController {

    @Autowired
    private ProductosRepository productosRepository;

    // Mostrar todos los productos
    @GetMapping
    public String listProductos(Model model) {
        model.addAttribute("productos", productosRepository.findAll());
        return "dashboardempleado"; // Apunta a la vista Thymeleaf productos/list.html
    }
    

    // Mostrar lista de productos en formato tabla
    @GetMapping("/ver")
    public String viewProductos(Model model) {
        model.addAttribute("productos", productosRepository.findAll());
        return "listaproductos"; // Apunta a la vista Thymeleaf productos/listaproductos.html
    }

    // Mostrar formulario para agregar un nuevo producto
    @GetMapping("/nuevo")
    public String showNewProductoForm(Model model) {
        model.addAttribute("producto", new Productos());
        return "nuevo"; // Apunta a la vista Thymeleaf productos/nuevo.html
    }

    // Guardar un nuevo producto
    @PostMapping
    public String saveProducto(
            @ModelAttribute Productos producto,
            HttpSession session) {
        Empleado empleado = (Empleado) session.getAttribute("empleado");
        if (empleado != null) {
            producto.setTienda(empleado.getTienda()); // Asignar tienda del empleado
        }
        productosRepository.save(producto);
        return "dashboardempleado";
    }

    // Mostrar formulario para editar un producto
    @GetMapping("/editar/{id}")
    public String showEditProductoForm(@PathVariable String id, Model model) {
        Productos producto = productosRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "editar"; // Apunta a la vista Thymeleaf productos/editar.html
    }

    // Actualizar un producto
    @PostMapping("/editar/{id}")
    public String updateProducto(@PathVariable String id, @ModelAttribute Productos producto) {
        producto.setId(id);
        productosRepository.save(producto);
        return "redirect:/productos";
    }

    // Eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable String id) {
        productosRepository.deleteById(id);
        return "redirect:/productos";
    }
}
