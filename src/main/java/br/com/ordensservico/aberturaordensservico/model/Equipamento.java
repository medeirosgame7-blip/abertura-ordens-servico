package br.com.ordensservico.aberturaordensservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "equipamento")
public class Equipamento {
 
    private int id; 
    private String nome;
    private String numeroPatrimonio;
    
    @ManyToOne 
    private Setor setor;
} 
