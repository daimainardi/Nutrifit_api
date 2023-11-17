package api.nutrifit.domain.nutricionista;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoNutricionistaDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone) {
}
