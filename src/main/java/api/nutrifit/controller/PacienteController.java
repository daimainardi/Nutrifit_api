package api.nutrifit.controller;

import api.nutrifit.domain.paciente.DadosAtualizacaoPacienteDTO;
import api.nutrifit.domain.paciente.DadosCadastroPacienteDTO;
import api.nutrifit.domain.paciente.DadosDetalhamentoPacienteDTO;
import api.nutrifit.domain.paciente.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DadosDetalhamentoPacienteDTO cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados) {
        return pacienteService.salvar(dados);
    }

    @Transactional
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DadosDetalhamentoPacienteDTO atualizar(@RequestBody @Valid DadosAtualizacaoPacienteDTO dados) {
        return pacienteService.atualizarPaciente(dados);
    }

}
