package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.AlunoDTO;
import com.sistemaMoeda.sistemamoeda.model.Aluno;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarAluno(@RequestBody @Valid AlunoDTO alunoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        Aluno aluno = convertToEntity(alunoDTO);
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
    public ResponseEntity<?> updateAluno(@PathVariable String id, @RequestBody @Valid AlunoDTO alunoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }
        Aluno aluno = convertToEntity(alunoDTO);
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

    private Aluno convertToEntity(AlunoDTO dto) {
        Aluno aluno = new Aluno();

        aluno.setLogin(dto.getLogin());
        aluno.setSenha(dto.getSenha());
        aluno.setCpf(dto.getCpf());


        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setRg(dto.getRg());
        aluno.setEndereco(dto.getEndereco());
        aluno.setInstituicaoEnsino(dto.getInstituicaoEnsino());
        aluno.setCurso(dto.getCurso());
        aluno.setSaldo(0);
        return aluno;
    }
}