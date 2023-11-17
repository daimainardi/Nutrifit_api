package api.nutrifit.controller;

import api.nutrifit.domain.usuario.DadosAutenticacaoDTO;
import api.nutrifit.domain.usuario.LoginService;
import api.nutrifit.infra.security.DadosTokenJWTDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private LoginService service;

    @PostMapping
    public DadosTokenJWTDTO efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados) {
        return service.login(dados);
    }
}
