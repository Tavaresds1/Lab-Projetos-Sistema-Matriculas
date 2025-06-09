package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.TransacaoDTO;
import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarTransacao(@RequestBody @Valid TransacaoDTO transacaoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        Transacao transacao = new Transacao();
        transacao.setAlunoId(transacaoDTO.getAlunoId());
        transacao.setProfessorId(transacaoDTO.getProfessorId());
        transacao.setData(transacaoDTO.getData());
        transacao.setTipo(transacaoDTO.getTipo());
        transacao.setValor(transacaoDTO.getValor());
        transacao.setMensagem(transacaoDTO.getMensagem());
        transacao.setCodigoConfirmacao(transacaoDTO.getCodigoConfirmacao());

        return ResponseEntity.ok(transacaoService.criarTransacao(transacao));
    }

    @GetMapping("/listarPorAluno/{alunoId}")
    public ResponseEntity<List<Transacao>> listarPorAluno(@PathVariable String alunoId) {
        List<Transacao> transacoes = transacaoService.listarPorAluno(alunoId);
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/listarPorProfessor/{professorId}")
    public ResponseEntity<List<Transacao>> listarPorProfessor(@PathVariable String professorId) {
        List<Transacao> transacoes = transacaoService.listarPorProfessor(professorId);
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/listarTodas")
    public List<Transacao> listarTodas() {
        return transacaoService.listarTodas();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTrasacao(@PathVariable String id) {
        transacaoService.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }
}