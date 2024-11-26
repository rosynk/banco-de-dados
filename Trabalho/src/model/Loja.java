package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private String id = "";
    private String nome = "";
    private String descricao = "";
    private List<Produto> produtos = new ArrayList<Produto>();

    public Loja (String nome, String descricao, List<Produto> produtos){
        this.nome = nome;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
