package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

@Service 
public class EquipamentoService {

     private final EquipamentoRepository equipamentoRepository;
     private final SetorRepository setorRepository;


    public EquipamentoService(
            EquipamentoRepository equipamentoRepository,   
            SetorRepository setorRepository) {

        this.equipamentoRepository = equipamentoRepository;
        this.setorRepository = setorRepository;
    }

    public Equipamento cadastrar (Equipamento equipamento) {
       
        Integer setorId = equipamento.getSetor().getId();
       
       Setor setor = setorRepository.findById(setorId)
                .orElseThrow(() ->
                        new RuntimeException("Setor não encontrado"));
       
        equipamento.setSetor(setor);                

        return equipamentoRepository.save(equipamento);

        
    }

    public List<Equipamento> Listar() {
        return equipamentoRepository.findAll();
    }
    public Optional<Equipamento> buscarPorid(Integer id) {
        return equipamentoRepository.findById(id);
    } 
    public Optional<Equipamento> atualizar(
        Integer id, Equipamento novosDados) {
      
      Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(id);      
      
      if (equipamentoEncontrado.isEmpty()){
        return Optional.empty();
      }

       Equipamento equipamento = equipamentoEncontrado.get();
       
       equipamento.setNome(novosDados.getNome());
       equipamento.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
       equipamento.setSetor(novosDados.getSetor());
    
      return Optional.of(equipamentoRepository.save(equipamento));    
    }

    public boolean excluir(Integer id)  {
      
        if (!equipamentoRepository.existsById(id)) {
            return false;
        }

        equipamentoRepository.deleteById(id);
        return true;
    }
}
