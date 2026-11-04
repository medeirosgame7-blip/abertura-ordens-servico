package br.com.ordensservico.aberturaordensservico.dto;


import jakarta.validation.constraints.NotNull;

public class EquipamentoRequest {
      @NotNull (message = "O nome é obrigatório")
    private String nome;

    @NotNull(message = "O número do patrimonio é obrigatório")
    private String numeroPatrimonio;
    
    @NotNull(message = "A data prevista é obrigatória")
    private Integer setorId;

    public EquipamentoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }
    
    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }
    
    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(
            Integer setorId) {

        this.setorId = setorId;
    }
}
