package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/criar")
    public Professor criarProfessor(@RequestBody Professor professor) {
        return professorService.criarProfessor(professor);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable String id) {
        Professor professor = professorService.buscarPorId(id);
        return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarCpf/{cpf}")
    public ResponseEntity<Professor> buscarPorCpf(@PathVariable String cpf) {
        Professor professor = professorService.buscarPorCpf(cpf);
        return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listarTodos")
    public List<Professor> listarTodos() {
        return professorService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable String id, @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.updateProfessor(id, professor);
        return professorAtualizado != null ? ResponseEntity.ok(professorAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable String id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultarExtrato/{id}")
    public ResponseEntity<List<Transacao>> consultarExtrato(@PathVariable String id) {
        List<Transacao> extrato = professorService.consultarExtrato(id);
        return extrato != null ? ResponseEntity.ok(extrato) : ResponseEntity.notFound().build();
    }

    @PostMapping("/enviarMoeda/{professorId}/{alunoId}")
    public ResponseEntity<Void> enviarIMoeda(
            @PathVariable String professorId,
            @PathVariable String alunoId,
            @RequestParam int valor,
            @RequestParam String mensagem) {

        professorService.enviarIMoeda(professorId, alunoId, valor, mensagem);
        return ResponseEntity.ok().build();
    }
}