package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.EmpresaParceiraDTO;
import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.services.EmpresaParceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empresa")
public class EmpresaParceiraController {

    private final EmpresaParceiraService empresaParceiraService;

    @Autowired
    public EmpresaParceiraController(EmpresaParceiraService empresaParceiraService) {
        this.empresaParceiraService = empresaParceiraService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarEmpresa(@RequestBody @Valid EmpresaParceiraDTO empresaDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        EmpresaParceira empresa = convertToEntity(empresaDTO);
        EmpresaParceira novaEmpresa = empresaParceiraService.criarEmpresa(empresa);
        return ResponseEntity.ok(novaEmpresa);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarEmpresa(@PathVariable String id,
                                              @RequestBody @Valid EmpresaParceiraDTO empresaDTO,
                                              BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        EmpresaParceira empresa = convertToEntity(empresaDTO);
        EmpresaParceira empresaAtualizada = empresaParceiraService.atualizarEmpresa(id, empresa);

        return empresaAtualizada != null ?
                ResponseEntity.ok(empresaAtualizada) :
                ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaParceira> buscarPorId(@PathVariable String id) {
        return empresaParceiraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<EmpresaParceira>> listarTodas() {
        return ResponseEntity.ok(empresaParceiraService.listarTodas());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable String id) {
        empresaParceiraService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    private EmpresaParceira convertToEntity(EmpresaParceiraDTO dto) {
        EmpresaParceira empresa = new EmpresaParceira();
        empresa.setNome(dto.getNome());
        empresa.setDescricao(dto.getDescricao());
        // Aqui você precisaria converter as VantagensDTO para Vantagens
        // empresa.setVantagens(converterVantagens(dto.getVantagens()));
        return empresa;
    }
}