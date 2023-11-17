package api.nutrifit.domain.consulta;

import api.nutrifit.domain.ValidacaoException;
import api.nutrifit.domain.nutricionista.NutricionistaService;
import api.nutrifit.domain.paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private NutricionistaService nutricionistaService;
    @Autowired
    private PacienteService pacienteService;

    public DadosDetalhamentoConsultaDTO agendar(DadosAgendamentoConsultaDTO dados) {
        if (nutricionistaService.nutricionistaExiste(dados.idNutricionista()) && pacienteService.pacienteExiste(dados.idPaciente())) {
            var consulta = consultaRepository.save(new ConsultaEntity(dados));
            return new DadosDetalhamentoConsultaDTO(consulta);
        } else {
            throw new ValidacaoException("O nutricionista ou paciente informados não foram encontrados");
        }
    }
}
