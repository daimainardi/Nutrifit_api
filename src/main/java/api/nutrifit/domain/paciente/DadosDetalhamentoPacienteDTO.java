package api.nutrifit.domain.paciente;

public record DadosDetalhamentoPacienteDTO(Long id, String nome, String email,String telefone,String cpf) {

        public DadosDetalhamentoPacienteDTO(PacienteEntity paciente){
            this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
        }

}
