package api.nutrifit.controller;

import api.nutrifit.domain.nutricionista.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nutricionistas")
@SecurityRequirement(name = "bearer-key")
public class NutricionistaController {
    @Autowired
    private NutricionistaService nutricionistaService;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DadosDetalhamentoNutricionistaDTO cadastrar(@RequestBody @Valid DadosCadastroNutricionistaDTO dados) {
        return nutricionistaService.salvar(dados);
    }

    @Transactional
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public DadosDetalhamentoNutricionistaDTO atualizar(@RequestBody @Valid DadosAtualizacaoNutricionistaDTO dados) {
        return nutricionistaService.atualizarNutricionista(dados);
    }

    @GetMapping
    @Transactional
    public List<DadosNutricionistasDTO> listar() {
        return nutricionistaService.buscarNutricionistas();
    }
}
