package br.com.ordensservico.aberturaordensservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ordensservico.aberturaordensservico.model.Setor;

@Repository 
public interface SetorRepository 
        extends JpaRepository<Setor, Integer>{
    
}
