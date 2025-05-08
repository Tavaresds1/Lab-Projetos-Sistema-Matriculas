package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/criar")
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.criarTransacao(transacao);
    }

    @GetMapping("/listarPorAluno/{alunoId}")
    public List<Transacao> listarPorAluno(@PathVariable String alunoId) {
        return transacaoService.listarPorAluno(alunoId);
    }

    @GetMapping("/listarPorProfessor/{professorId}")
    public List<Transacao> listarPorProfessor(@PathVariable String professorId) {
        return transacaoService.listarPorProfessor(professorId);
    }

    @GetMapping("/listarTodas")
    public List<Transacao> listarTodas() {
        return transacaoService.listarTodas();
    }
}