package api.nutrifit.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public void cadastrarUsuario(DadosAutenticacaoDTO dados) {
        var usuario = new UsuarioEntity(dados);
        repository.save(usuario);
    }

    public Boolean usuarioExiste(String username) {
        return repository.existsByLogin(username);
    }
}
