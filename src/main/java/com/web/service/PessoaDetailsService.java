package com.web.service;

import com.web.model.Pessoa;
import com.web.repository.PessoaRepository;
import com.web.security.PessoaSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PessoaDetailsService implements UserDetailsService {


    @Autowired
    private PessoaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Pessoa p = repository.findByLogin(login);

        if (p == null){
            throw new UsernameNotFoundException("");
        }

        return new PessoaSecurity(p.getId(), p.getLogin(), p.getSenha());
    }
}
