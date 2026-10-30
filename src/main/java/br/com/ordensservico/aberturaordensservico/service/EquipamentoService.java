package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;

@Service 
public class EquipamentoService {

     private final EquipamentoRepository equipamentosRepository;

    public EquipamentoService(EquipamentoRepository equipamentosRepository) {
        this.equipamentosRepository = equipamentosRepository;
    }

    public Equipamento cadastrar (Equipamento equipamentos) {
        return equipamentosRepository.save(equipamentos);
    }

    public List<Equipamento> Listar() {
        return equipamentosRepository.findAll();
    }
    public Optional<Equipamento> buscarPorid(Integer id) {
        return equipamentosRepository.findById(id);
    }
    public Optional<Equipamento> atualizar(
        Integer id, Equipamento novosDados) {
      
      Optional<Equipamento> equipamentosEncontrado = equipamentosRepository.findById(id);      
      
      if (equipamentosEncontrado.isEmpty()){
        return Optional.empty();
      }

       Equipamento equipamentos = equipamentosEncontrado.get();
       
       equipamentos.setNome(novosDados.getNome());
       equipamentos.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
       equipamentos.setSetor(novosDados.getSetor());
    
      return Optional.of(equipamentosRepository.save(equipamentos));    
    }

    public boolean excluir(Integer id)  {
      
        if (!equipamentosRepository.existsById(id)) {
            return false;
        }

        equipamentosRepository.deleteById(id);
        return true;
    }
}
