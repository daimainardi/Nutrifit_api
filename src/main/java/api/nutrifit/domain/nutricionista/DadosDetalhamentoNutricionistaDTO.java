package api.nutrifit.domain.nutricionista;

import api.nutrifit.domain.endereco.Endereco;

public record DadosDetalhamentoNutricionistaDTO(Long id, String nome, String email, String telefone, String crn, String cpf, Endereco endereco) {

    public DadosDetalhamentoNutricionistaDTO(NutricionistaEntity nutricionista){
        this(nutricionista.getId(), nutricionista.getNome(), nutricionista.getEmail(), nutricionista.getTelefone(), nutricionista.getCrn(), nutricionista.getCpf(), nutricionista.getEnderecoAtendimento());
    }
}
