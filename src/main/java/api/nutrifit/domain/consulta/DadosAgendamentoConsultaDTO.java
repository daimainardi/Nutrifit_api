package api.nutrifit.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosAgendamentoConsultaDTO(

        @NotNull
        Long idPaciente,
        @NotNull
        Long idNutricionista,
        @NotNull
        String motivoDaConsulta) {
}
