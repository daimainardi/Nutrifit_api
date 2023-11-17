package api.nutrifit.controller;

import api.nutrifit.domain.consulta.ConsultaService;
import api.nutrifit.domain.consulta.DadosAgendamentoConsultaDTO;
import api.nutrifit.domain.consulta.DadosDetalhamentoConsultaDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public DadosDetalhamentoConsultaDTO agendarConsulta(@RequestBody @Valid DadosAgendamentoConsultaDTO dados) {
        return consultaService.agendar(dados);
    }
}
