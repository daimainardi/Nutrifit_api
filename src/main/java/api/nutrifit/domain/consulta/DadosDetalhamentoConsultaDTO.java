package api.nutrifit.domain.consulta;

public record DadosDetalhamentoConsultaDTO(
        Long id,
        Long idPaciente,
        Long idNutricionista,
        String motivoDaConsulta) {

    public DadosDetalhamentoConsultaDTO(ConsultaEntity consulta){
        this(consulta.getId(), consulta.getPacienteId(), consulta.getNutricionistaId(), consulta.getMotivoDaConsulta());
    }
}
