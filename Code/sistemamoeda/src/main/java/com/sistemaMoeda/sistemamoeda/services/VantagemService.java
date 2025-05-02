package com.sistemaMoeda.sistemamoeda.services;

import com.sistemaMoeda.sistemamoeda.model.Vantagem;
import com.sistemaMoeda.sistemamoeda.repository.VantagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VantagemService {

    @Autowired
    private VantagemRepository vantagemRepository;

    public Vantagem criarVantagem(Vantagem vantagem) {
        return vantagemRepository.save(vantagem);
    }

    public Vantagem buscarPorId(String id) {
        return vantagemRepository.findById(id).orElse(null);
    }

    public List<Vantagem> listarTodas() {
        return vantagemRepository.findAll();
    }

    public List<Vantagem> listarPorCustoMaximo(int custoMaximo) {
        return vantagemRepository.findByCustoLessThanEqual(custoMaximo);
    }

    public Vantagem updateVantagem(String id, Vantagem vantagemAtualizada) {

        Vantagem vantagemExistente = vantagemRepository.findById(id).orElse(null);
        if (vantagemExistente == null) {
            return null;
        }

        vantagemAtualizada.setId(id);
        return vantagemRepository.save(vantagemAtualizada);
    }


    public void deletarVantagem(String id) {
        vantagemRepository.deleteById(id);
    }
}