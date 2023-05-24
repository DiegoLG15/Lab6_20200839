package com.example.lab6_sol.repository;

import com.example.lab6_sol.entity.Curso;
import com.example.lab6_sol.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
