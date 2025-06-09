package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.repository.EmpresaParceiraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaParceiraService {

    private final EmpresaParceiraRepository empresaParceiraRepository;

    public EmpresaParceiraService(EmpresaParceiraRepository empresaParceiraRepository) {
        this.empresaParceiraRepository = empresaParceiraRepository;
    }

    public boolean existeEmpresa(String empresaId) {
        return empresaParceiraRepository.existsById(empresaId);
    }

    @Transactional
    public EmpresaParceira criarEmpresa(EmpresaParceira empresa) {
        return empresaParceiraRepository.save(empresa);
    }

    @Transactional(readOnly = true)
    public Optional<EmpresaParceira> buscarPorId(String id) {
        return empresaParceiraRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<EmpresaParceira> listarTodas() {
        return empresaParceiraRepository.findAll();
    }

    @Transactional
    public EmpresaParceira atualizarEmpresa(String id, EmpresaParceira empresa) {
        if (!empresaParceiraRepository.existsById(id)) {
            return null;
        }
        empresa.setId(id);
        return empresaParceiraRepository.save(empresa);
    }

    @Transactional
    public void deletarEmpresa(String id) {
        empresaParceiraRepository.deleteById(id);
    }
}