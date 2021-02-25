package com.web.service;

import com.web.model.Comanda;
import com.web.model.Pessoa;
import com.web.model.PessoaUser;
import com.web.model.Produto;
import com.web.repository.ComandaRepository;
import com.web.repository.PessoaUserRepository;
import com.web.repository.PessoaRepository;
import com.web.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/RestAPIFurb")
public class Service {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private PessoaUserRepository pessoaUserRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @RequestMapping(value = "/auth/sign-up", method = RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody Pessoa pessoa){

        pessoa.setSenha(encoder.encode(pessoa.getSenha()));

        PessoaUser pessoaUser = new PessoaUser(pessoa.getNomeUsuario(),pessoa.getTelefoneUsuario());
        try {
            repository.save(pessoa);
            pessoaUserRepository.save(pessoaUser);
        }catch (Exception e){
            return ResponseEntity.status(500).body("erro ao persistir pessoa: "+e);
        }
        return ResponseEntity.ok("Registrado com sucesso");
    }


    @RequestMapping(value = "/comandas", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Comanda comanda){

        try{
            comandaRepository.save(comanda);
        }catch (Exception e){
            return ResponseEntity.status(500).body("erro ao persistir comanda: "+e);
        }

        return ResponseEntity.ok(comanda);
    }

    @RequestMapping(value = "/comandas", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(pessoaUserRepository.findAll());
    }

    @RequestMapping(value = "/comandas/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getComandaByid(@PathVariable("id") Long id){

        return ResponseEntity.ok(comandaRepository.findById(id));
    }

    @RequestMapping(value = "/comandas/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> alter(@PathVariable("id") Long id, @RequestBody Comanda comanda){


        try {
            comanda.setId(id);
            comandaRepository.save(comanda);
        }catch (Exception e){
            return ResponseEntity.status(500).body("erro ao tentar persistir: "+e);
        }

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/comandas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id){

        try {
            comandaRepository.deleteById(id);
        }catch (Exception e){
            return ResponseEntity.status(500).body("erro ap tentar deletar comanda: " + e);
        }
        return ResponseEntity.ok("{\"success\":{\"text\":\"comanda\n" +
                "removida\"}}");
    }
}

