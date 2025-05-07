package main.java.com.sistemaMoeda.sistemamoeda.controller;

import main.java.com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import main.java.com.sistemaMoeda.sistemamoeda.services.EmpresaParceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaParceiraController {

    @Autowired
    private EmpresaParceiraService empresaParceiraService;

    @PostMapping("/criar")
    public ResponseEntity<EmpresaParceira> criarEmpresa(@RequestBody EmpresaParceira empresa) {
        if (empresa.getNome() == null || empresa.getVantagens() == null) {
            return ResponseEntity.badRequest().build();
        }
        EmpresaParceira novaEmpresa = empresaParceiraService.criarEmpresa(empresa);
        return ResponseEntity.ok(novaEmpresa);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<EmpresaParceira> buscarPorId(@PathVariable String id) {
        EmpresaParceira empresa = empresaParceiraService.buscarPorId(id);
        return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    @GetMapping("/listarTodas")
    public List<EmpresaParceira> listarTodas() {
        return empresaParceiraService.listarTodas();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EmpresaParceira> updateEmpresa(@PathVariable String id, @RequestBody EmpresaParceira empresa) {
        EmpresaParceira empresaAtualizada = empresaParceiraService.updateEmpresa(id, empresa);
        return empresaAtualizada != null ? ResponseEntity.ok(empresaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable String id) {
        empresaParceiraService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}