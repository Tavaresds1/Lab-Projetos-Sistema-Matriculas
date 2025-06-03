package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.InstituicaoDTO;
import com.sistemaMoeda.sistemamoeda.dto.ProfessorDTO;
import com.sistemaMoeda.sistemamoeda.model.Instituicao;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.services.InstituicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/instituicao")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarInstituicao(@RequestBody @Valid InstituicaoDTO instituicaoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }
        Instituicao instituicao = convertToEntity(instituicaoDTO);
        Instituicao novaInstituicao = instituicaoService.criarInstituicao(instituicao);
        return ResponseEntity.ok(novaInstituicao);
    }


    @PostMapping("/{instituicaoId}/criarProfessor")
    public ResponseEntity<?> criarProfessor(@PathVariable String instituicaoId, @RequestBody @Valid ProfessorDTO professorDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        Professor professor = convertProfessorDTOToEntity(professorDTO);
        Professor novoProfessor = instituicaoService.criarProfessor(instituicaoId, professor);
        return novoProfessor != null ? ResponseEntity.ok(novoProfessor) : ResponseEntity.badRequest().build();
    }

    private Instituicao convertToEntity(InstituicaoDTO dto) {
        Instituicao instituicao = new Instituicao();
        instituicao.setNome(dto.getNome());
        instituicao.setEndereco(dto.getEndereco());
        return instituicao;
    }


    private Professor convertProfessorDTOToEntity(ProfessorDTO dto) {
        Professor professor = new Professor();
        professor.setLogin(dto.getLogin());
        professor.setSenha(dto.getSenha());
        professor.setCpf(dto.getCpf());
        professor.setNome(dto.getNome());
        professor.setDepartamento(dto.getDepartamento());
        professor.setSaldo(0);
        return professor;
    }
}