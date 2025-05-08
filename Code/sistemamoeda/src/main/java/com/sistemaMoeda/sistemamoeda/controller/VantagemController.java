package com.sistemaMoeda.sistemamoeda.controller;

import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.services.VantagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vantagem")
public class VantagemController {

    @Autowired
    private VantagemService vantagemService;

    @PostMapping("/criar")
    public Vantagem criarVantagem(@RequestBody Vantagem vantagem) {
        return vantagemService.criarVantagem(vantagem);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<Vantagem> buscarPorId(@PathVariable String id) {
        Vantagem vantagem = vantagemService.buscarPorId(id);
        return vantagem != null ? ResponseEntity.ok(vantagem) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listarTodas")
    public List<Vantagem> listarTodas() {
        return vantagemService.listarTodas();
    }

    @GetMapping("/listarPorCusto/{custoMaximo}")
    public List<Vantagem> listarPorCustoMaximo(@PathVariable int custoMaximo) {
        return vantagemService.listarPorCustoMaximo(custoMaximo);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Vantagem> updateVantagem(@PathVariable String id, @RequestBody Vantagem vantagem) {
        Vantagem vantagemAtualizada = vantagemService.updateVantagem(id, vantagem);
        return vantagemAtualizada != null ? ResponseEntity.ok(vantagemAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarVantagem(@PathVariable String id) {
        vantagemService.deletarVantagem(id);
        return ResponseEntity.noContent().build();
    }
}