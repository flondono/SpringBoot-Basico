package com.flondono.springbootbasico.controllers;

import com.flondono.springbootbasico.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/* una ruta base para todos lo métodos, una ruta genérica handler
 *  una forma muy común para mapear curds, listar,eliminar, actualizar*/
@RequestMapping("/app")
public class IndexController {

    //@RequestMapping(value="/index", method = RequestMethod.GET) // Por defecto con GET para el método
    //@GetMapping(value="/index") es más limpio pero es lo mismo
    //Un método puede estar mapeado a más de una ruta
    @GetMapping(value = {"/index", "/home", "/"})
    public String index(Model model) {

        //Pasar parametros a la vista
        model.addAttribute("titulo", "Hola Spring Framework desde model");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("Guerrero");
        usuario.setNombre("Yessica");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
        return "perfil";
    }
}
