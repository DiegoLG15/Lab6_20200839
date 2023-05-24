package com.example.lab6_sol.controller;

import com.example.lab6_sol.entity.Curso;
import com.example.lab6_sol.entity.Usuario;
import com.example.lab6_sol.repository.CursoRepository;
import com.example.lab6_sol.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping("/lista")
    public String listaCurso(Model model){
        List<Curso> cursos = cursoRepository.findAll();
        model.addAttribute("cursos", cursos);
        return "lista_cursos";
    }
}
