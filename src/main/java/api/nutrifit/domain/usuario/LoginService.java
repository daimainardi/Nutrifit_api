package api.nutrifit.domain.usuario;

import api.nutrifit.infra.security.DadosTokenJWTDTO;
import api.nutrifit.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DadosTokenJWTDTO login(DadosAutenticacaoDTO dados) {
        var usuario = dados.login();
        if (!autenticacaoService.usuarioExiste(usuario)) {
            String encoded = passwordEncoder.encode(dados.senha());
            var auth = new DadosAutenticacaoDTO(dados.login(), encoded);
            autenticacaoService.cadastrarUsuario(auth);
        }

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((UsuarioEntity) authentication.getPrincipal());

        return new DadosTokenJWTDTO(tokenJWT);
    }
}
