package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/criar")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        if (aluno.getNome() == null || aluno.getEmail() == null || aluno.getCpf() == null ||
                aluno.getRg() == null || aluno.getEndereco() == null ||
                aluno.getInstituicaoEnsino() == null || aluno.getCurso() == null) {
            return ResponseEntity.badRequest().build();
        }
        Aluno novoAluno = alunoService.criarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable String id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return aluno != null ? ResponseEntity.ok(aluno) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscarCpf/{cpf}")
    public ResponseEntity<Aluno> buscarPorCpf(@PathVariable String cpf) {
        Aluno aluno = alunoService.buscarPorCpf(cpf);
        return aluno != null ? ResponseEntity.ok(aluno) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listarTodos")
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable String id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.updateAluno(id, aluno);
        return alunoAtualizado != null ? ResponseEntity.ok(alunoAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable String id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultarExtrato/{id}")
    public ResponseEntity<List<Transacao>> consultarExtrato(@PathVariable String id) {
        List<Transacao> extrato = alunoService.consultarExtrato(id);
        return extrato != null ? ResponseEntity.ok(extrato) : ResponseEntity.notFound().build();
    }

    @PostMapping("/resgatarVantagem/{alunoId}/{idVantagem}")
    public ResponseEntity<String> resgatarVantagem(
            @PathVariable String alunoId,
            @PathVariable String idVantagem
    ) {
        alunoService.resgatarVantagem(alunoId, idVantagem);
        return ResponseEntity.ok("Vantagem resgatada com sucesso!");
    }
}