package com.web.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeUsuario;
    private Long idUsuario;
    private String telefoneUsuario;

    @OneToMany(cascade =  CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    public Comanda() {
    }

    public Comanda(Long id, String nomeUsuario, Long idUsuario, String telefoneUsuario, List<Produto> produtos) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.idUsuario = idUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void alterar(){
        //this.produtos.
    }
}
