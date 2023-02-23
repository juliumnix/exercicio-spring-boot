package br.udesc.ceavi.edp.dsw.exercicio.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "fornecedor")
    @JsonIgnore
    private List<Produto> produtos;

    public Fornecedor() {

    }

    public Fornecedor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
