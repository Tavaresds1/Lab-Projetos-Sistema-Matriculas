package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.EmpresaParceira;
import com.sistemaMoeda.sistemamoeda.repository.EmpresaParceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaParceiraService {

    @Autowired
    private EmpresaParceiraRepository empresaParceiraRepository;

    public EmpresaParceira criarEmpresa(EmpresaParceira empresa) {
        return empresaParceiraRepository.save(empresa);
    }

    public EmpresaParceira buscarPorId(String id) {
        return empresaParceiraRepository.findById(id).orElse(null);
    }

    public List<EmpresaParceira> listarTodas() {
        return empresaParceiraRepository.findAll();
    }

    public EmpresaParceira updateEmpresa(String id, EmpresaParceira empresaAtualizada) {

        EmpresaParceira empresaExistente = empresaParceiraRepository.findById(id).orElse(null);
        if (empresaExistente == null) {
            return null;
        }

        empresaAtualizada.setId(id);
        return empresaParceiraRepository.save(empresaAtualizada);
    }


    public void deletarEmpresa(String id) {
        empresaParceiraRepository.deleteById(id);
    }
}