package br.udesc.ceavi.edp.dsw.exercicio.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private float valor;
    @OneToMany(mappedBy = "produto")
    @JsonIgnore
    private List<Venda> venda;
    @ManyToOne
    @JsonIgnore
    private Fornecedor fornecedor;

    public Produto(){}

    public Produto(Long id, String descricao, float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
