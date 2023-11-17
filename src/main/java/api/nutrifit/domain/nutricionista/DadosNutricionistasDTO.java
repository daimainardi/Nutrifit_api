package api.nutrifit.domain.nutricionista;

public record DadosNutricionistasDTO(Long id, String nome, String crn) {
    public DadosNutricionistasDTO(NutricionistaEntity nutricionista){
        this(nutricionista.getId(), nutricionista.getNome(), nutricionista.getCrn());
    }
}
