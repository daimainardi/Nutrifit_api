package api.nutrifit.domain.consulta;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "paciente_id")
    private Long pacienteId;

    @JoinColumn(name = "nutricionista_id")
    private Long nutricionistaId;

    @JoinColumn(name = "motivo_da_consulta")
    private String motivoDaConsulta;

    public ConsultaEntity(DadosAgendamentoConsultaDTO dados){
        this.pacienteId = dados.idPaciente();
        this.nutricionistaId = dados.idNutricionista();
        this.motivoDaConsulta = dados.motivoDaConsulta();
    }

}
