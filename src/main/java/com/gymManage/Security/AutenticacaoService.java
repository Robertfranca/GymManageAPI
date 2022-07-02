package com.gymManage.Security;

import com.gymManage.data.DetalhesUsuarioData;
import com.gymManage.modules.UserCadModels;
import com.gymManage.repository.UsuarioCadRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioCadRepository user;

    public AutenticacaoService(UsuarioCadRepository user) {
        this.user = user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserCadModels> users = user.findByEmail(email);

        if (users.isEmpty()){
            throw new UsernameNotFoundException("Dados invalidos");
        }
        return new DetalhesUsuarioData(users);

    }
}
