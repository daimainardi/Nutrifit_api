package api.nutrifit.domain.nutricionista;

import api.nutrifit.domain.endereco.DadosEnderecoDTO;
import api.nutrifit.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroNutricionistaDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Email(message = "Formato do email é inválido")
        @NotBlank(message = "Email é obrigatório")
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotBlank(message = "CRN é obrigatório")
        @Pattern(regexp = "\\d{4,6}",message = "Formato do CRN é inválido")
        String crn,
        @NotBlank(message = "CPF é obrigatório")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "Formato do CPF é inválido")
        String cpf,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid
        DadosEnderecoDTO endereco) {
}

