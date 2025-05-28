package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.repository.VantagemRepository;
import com.sistemaMoeda.sistemamoeda.services.EmpresaParceiraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VantagemService {

    private final VantagemRepository vantagemRepository;
    private final EmpresaParceiraService empresaParceiraService;

    public VantagemService(VantagemRepository vantagemRepository,
                           EmpresaParceiraService empresaParceiraService) {
        this.vantagemRepository = vantagemRepository;
        this.empresaParceiraService = empresaParceiraService;
    }

    @Transactional
    public Vantagem criarVantagem(Vantagem vantagem) throws IllegalStateException {
        // Verifica se a empresa existe antes de criar a vantagem
        if (vantagem.getEmpresaParceira() == null ||
                vantagem.getEmpresaParceira().getId() == null) {
            throw new IllegalStateException("Empresa Parceira é obrigatória");
        }

        boolean empresaExiste = empresaParceiraService.existeEmpresa(vantagem.getEmpresaParceira().getId());

        if (!empresaExiste) {
            throw new IllegalStateException("Empresa Parceira não encontrada com ID: " +
                    vantagem.getEmpresaParceira().getId());
        }

        return vantagemRepository.save(vantagem);
    }

    // ... outros métodos permanecem iguais ...


    @Transactional(readOnly = true)
    public Optional<Vantagem> buscarPorId(String id) {
        return vantagemRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Vantagem> listarTodas() {
        return vantagemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Vantagem> listarPorEmpresaParceira(String empresaId) {
        return vantagemRepository.findByEmpresaParceiraId(empresaId);
    }

    @Transactional(readOnly = true)
    public List<Vantagem> listarPorCustoMaximo(int custoMaximo) {
        return vantagemRepository.findByCustoLessThanEqual(custoMaximo);
    }

    @Transactional
    public Vantagem atualizarVantagem(String id, Vantagem vantagem) {
        if (!vantagemRepository.existsById(id)) {
            return null;
        }
        vantagem.setId(id);
        return vantagemRepository.save(vantagem);
    }

    @Transactional
    public void deletarVantagem(String id) {
        vantagemRepository.deleteById(id);
    }
}