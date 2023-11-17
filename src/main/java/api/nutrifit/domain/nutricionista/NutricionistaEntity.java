package api.nutrifit.domain.nutricionista;

import api.nutrifit.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "nutricionistas")
@Entity(name = "Nutricionista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NutricionistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crn;
    private String cpf;
    @Embedded
    private Endereco enderecoAtendimento;

    public NutricionistaEntity(DadosCadastroNutricionistaDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crn = dados.crn();
        this.cpf = dados.cpf();
        this.enderecoAtendimento = new Endereco(dados.endereco());
    }
}
