package api.nutrifit.domain.paciente;

import api.nutrifit.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public DadosDetalhamentoPacienteDTO salvar(DadosCadastroPacienteDTO dados) {
        var paciente = new PacienteEntity(dados);
        pacienteRepository.save(paciente);
        return new DadosDetalhamentoPacienteDTO(paciente);
    }

    public DadosDetalhamentoPacienteDTO atualizarPaciente(DadosAtualizacaoPacienteDTO dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        var pacienteAtualizado = atualizarInformacoes(paciente, dados);
        pacienteRepository.save(pacienteAtualizado);
        return new DadosDetalhamentoPacienteDTO(pacienteAtualizado);
    }

    public PacienteEntity atualizarInformacoes(PacienteEntity paciente, DadosAtualizacaoPacienteDTO dados) {
        if (dados.nome() != null) {
            paciente.setNome(dados.nome());
        }
        if (dados.email() != null) {
            paciente.setEmail(dados.email());
        }
        if (dados.telefone() != null) {
            paciente.setTelefone(dados.telefone());
        }
        return paciente;
    }

    public Boolean pacienteExiste(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }
        return pacienteRepository.existsById(id);
    }

}
