package br.com.ordensservico.aberturaordensservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordensservico.aberturaordensservico.model.Equipamento;

@Repository 
public interface EquipamentoRepository 
        extends JpaRepository<Equipamento, Integer> {

    
}
