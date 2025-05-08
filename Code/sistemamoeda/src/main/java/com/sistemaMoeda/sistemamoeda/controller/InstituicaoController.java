package com.sistemaMoeda.sistemamoeda.controller;


import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.model.Instituicao;
import com.sistemaMoeda.sistemamoeda.services.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @PostMapping("/criar")
    public Instituicao criarInstituicao(@RequestBody Instituicao instituicao) {
        return instituicaoService.criarInstituicao(instituicao);
    }



    @PostMapping("/criarProfessor")
    public ResponseEntity<Professor> criarProfessor(@PathVariable String instituicaoId, @RequestBody Professor professor) {
        Professor novoProfessor = instituicaoService.criarProfessor(instituicaoId, professor);
        return novoProfessor != null ? ResponseEntity.ok(novoProfessor) : ResponseEntity.badRequest().build();
    }
}