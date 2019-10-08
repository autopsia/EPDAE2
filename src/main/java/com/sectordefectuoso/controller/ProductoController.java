package com.sectordefectuoso.controller;

import com.sectordefectuoso.model.Producto;
import com.sectordefectuoso.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController implements GenericController<Producto, String> {
    @Autowired
    ProductoService productoService;

    @GetMapping("/productos")
    public String getList(Model model) {
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @PostMapping("/productos/save")
    public String save(Producto producto, Model model) {
        productoService.create(producto);
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/productos/add")
    public String add(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto-add";
    }

    @GetMapping("/productos/edit/{id}")
    public String getForUpdate(@PathVariable String id, Model model) {
        Producto currentObject = productoService.findById(id);
        model.addAttribute("producto", currentObject);
        return "producto-edit";
    }

    @PostMapping("/productos/update/{id}")
    public String update(@PathVariable String id, Producto producto, Model model) {
        //Update
        productoService.update(producto);

        //list
        List<Producto> objetos = productoService.findAll();
        model.addAttribute("productos", objetos);
        return "producto";
    }

    @GetMapping("/productos/delete/{id}")
    public String delete(@PathVariable String id, Model model) {
        Producto aBorrar = productoService.findById(id);
        productoService.delete(aBorrar);
        List<Producto> productos = productoService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }
}
