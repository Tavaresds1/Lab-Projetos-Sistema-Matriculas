package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.dto.VantagemDTO;
import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.services.EmpresaParceiraService;
import com.sistemaMoeda.sistemamoeda.services.VantagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vantagem")
public class VantagemController {

    private final VantagemService vantagemService;
    private final EmpresaParceiraService empresaParceiraService;

    @Autowired
    public VantagemController(VantagemService vantagemService, EmpresaParceiraService empresaParceiraService) {
        this.vantagemService = vantagemService;
        this.empresaParceiraService = empresaParceiraService;
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criarVantagem(@RequestBody @Valid VantagemDTO vantagemDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        try {
            Vantagem vantagem = convertToEntity(vantagemDTO);
            Vantagem novaVantagem = vantagemService.criarVantagem(vantagem);
            return ResponseEntity.ok(novaVantagem);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarVantagem(@PathVariable String id,
                                               @RequestBody @Valid VantagemDTO vantagemDTO,
                                               BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    result.getAllErrors()
                            .stream()
                            .map(e -> e.getDefaultMessage())
                            .collect(Collectors.toList())
            );
        }

        try {
            Vantagem vantagem = convertToEntity(vantagemDTO);
            Vantagem vantagemAtualizada = vantagemService.atualizarVantagem(id, vantagem);
            return vantagemAtualizada != null ?
                    ResponseEntity.ok(vantagemAtualizada) :
                    ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vantagem> buscarPorId(@PathVariable String id) {
        return vantagemService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listarTodas")
    public ResponseEntity<List<Vantagem>> listarTodas() {
        return ResponseEntity.ok(vantagemService.listarTodas());
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<Vantagem>> listarPorEmpresa(@PathVariable String empresaId) {
        return ResponseEntity.ok(vantagemService.listarPorEmpresaParceira(empresaId));
    }

    @GetMapping("/custo/{custoMaximo}")
    public ResponseEntity<List<Vantagem>> listarPorCustoMaximo(@PathVariable int custoMaximo) {
        return ResponseEntity.ok(vantagemService.listarPorCustoMaximo(custoMaximo));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletarVantagem(@PathVariable String id) {
        vantagemService.deletarVantagem(id);
        return ResponseEntity.noContent().build();
    }

    private Vantagem convertToEntity(VantagemDTO dto) {
        Vantagem vantagem = new Vantagem();
        vantagem.setDescricao(dto.getDescricao());
        vantagem.setFoto(dto.getFoto());
        vantagem.setCusto(dto.getCusto());

        Optional<EmpresaParceira> empresaOptional = empresaParceiraService.buscarPorId(dto.getEmpresaParceiraId());
        EmpresaParceira empresa = empresaOptional.orElseThrow(() ->
                new IllegalStateException("Empresa Parceira com ID " + dto.getEmpresaParceiraId() + " não encontrada"));

        vantagem.setEmpresaParceira(empresa);
        return vantagem;
    }
}