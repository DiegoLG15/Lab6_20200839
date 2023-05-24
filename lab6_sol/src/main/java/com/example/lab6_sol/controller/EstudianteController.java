package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listaUsuarios(Model model){
        List<Usuario> estudiantes = usuarioRepository.findByRolid(5);
        model.addAttribute("estudiantes", estudiantes);
        return "lista_usuarios";
    }
    @GetMapping("/new")
    public String nuevoEstudianteFrm(Model model, @ModelAttribute("estudiante") Usuario usuario) {
        return "estudiante/newFrm";
    }
    @PostMapping("/save")
    public String guardarEstudiante(RedirectAttributes attr,
                                  Model model,
                                  @ModelAttribute("estudiante") @Valid Usuario usuario,
                                  BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "estudiante/newFrm";
        }else{
            if (usuario.getId() == 0) {
                List<Usuario> usuarioList = usuarioRepository.findByCorreo(usuario.getCorreo());
                boolean existe = false;
                for (Usuario p : usuarioList) {
                    if (p.getCorreo().equals(usuario.getCorreo())) {
                        existe = true;
                        break;
                    }
                }
                if (existe) {
                    System.out.println("El estudiante existe");
                    return "estudiante/newFrm";
                } else {
                    attr.addFlashAttribute("msg", "Estudiante creado exitosamente");
                    usuarioRepository.save(usuario);
                    return "redirect:/estudiante/lista";
                }
            } else {
                attr.addFlashAttribute("msg", "Estudiante actualizado exitosamente");
                usuarioRepository.save(usuario);
                return "redirect:/estudiante/lista";
            }
        }
    }
    @GetMapping("/edit")
    public String editarEstudiante(Model model, @RequestParam("id") int id) {

        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            model.addAttribute("usuario", usuario);
            return "estudiante/newFrm";
        } else {
            return "redirect:/estudiante/lista";
        }
    }


}
