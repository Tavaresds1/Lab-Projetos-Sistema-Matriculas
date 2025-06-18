package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.ProfessorDTO;
import com.sistemaMoeda.sistemamoeda.dto.TransacaoDTO;
import com.sistemaMoeda.sistemamoeda.model.Professor;
import com.sistemaMoeda.sistemamoeda.model.Transacao;
import com.sistemaMoeda.sistemamoeda.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarProfessor(@RequestBody @Valid ProfessorDTO professorDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }
        Professor professor = convertToEntity(professorDTO);
        Professor novoProfessor = professorService.criarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
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
    public ResponseEntity<?> updateProfessor(@PathVariable String id, @RequestBody @Valid ProfessorDTO professorDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }
        Professor professor = convertToEntity(professorDTO);
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
    public ResponseEntity<String> enviarMoeda(@Valid @RequestBody TransacaoDTO transacaoDTO) {

        professorService.enviarIMoeda(
                transacaoDTO.getProfessorId(),
                transacaoDTO.getAlunoId(),
                transacaoDTO.getValor().intValue(),
                transacaoDTO.getMensagem()
        );

        return ResponseEntity.ok("Moedas enviadas com sucesso!");
    }

    private Professor convertToEntity(ProfessorDTO dto) {
        Professor professor = new Professor();

        professor.setEmail(dto.getEmail());
        professor.setSenha(dto.getSenha());
        professor.setCpf(dto.getCpf());
        professor.setLogin(dto.getEmail());


        professor.setNome(dto.getNome());
        professor.setDepartamento(dto.getDepartamento());
        professor.setInstituicao(dto.getInstituicao());

        professor.setSaldo(1000);
        return professor;
    }
}