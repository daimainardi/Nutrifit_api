package api.nutrifit.domain.nutricionista;

import api.nutrifit.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutricionistaService {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public DadosDetalhamentoNutricionistaDTO salvar(DadosCadastroNutricionistaDTO dados) {
        var nutricionista = new NutricionistaEntity(dados);
        nutricionistaRepository.save(nutricionista);
        return new DadosDetalhamentoNutricionistaDTO(nutricionista);
    }

    public DadosDetalhamentoNutricionistaDTO atualizarNutricionista(DadosAtualizacaoNutricionistaDTO dados) {
        var nutricionista = nutricionistaRepository.getReferenceById(dados.id());
        var nutricionistaAtualizado = atualizarInformacoes(nutricionista, dados);
        nutricionistaRepository.save(nutricionistaAtualizado);
        return new DadosDetalhamentoNutricionistaDTO(nutricionistaAtualizado);
    }

    public NutricionistaEntity atualizarInformacoes(NutricionistaEntity nutricionista, DadosAtualizacaoNutricionistaDTO dados) {
        if (dados.nome() != null) {
            nutricionista.setNome(dados.nome());
        }
        if (dados.email() != null) {
            nutricionista.setEmail(dados.email());
        }
        if (dados.telefone() != null) {
            nutricionista.setTelefone(dados.telefone());
        }
        return nutricionista;
    }

    public Boolean nutricionistaExiste(Long id) {
        if (!nutricionistaRepository.existsById(id)) {
            throw new ValidacaoException("Id do nutricionista informado não existe!");
        }
        return nutricionistaRepository.existsById(id);
    }

    public List<DadosNutricionistasDTO> buscarNutricionistas(){
        return nutricionistaRepository.findAll().stream().map(DadosNutricionistasDTO::new).toList();
    }
}

