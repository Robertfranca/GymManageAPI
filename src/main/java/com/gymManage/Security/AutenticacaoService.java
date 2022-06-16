package com.gymManage.Security;

import com.gymManage.modules.UserCadModels;
import com.gymManage.repository.UsuarioCadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioCadRepository user;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserCadModels> users = user.findByEmail(email);

        if (users.isPresent()){
            return users.get();
        }
        throw new UsernameNotFoundException("Dados invalidos");

    }
}
