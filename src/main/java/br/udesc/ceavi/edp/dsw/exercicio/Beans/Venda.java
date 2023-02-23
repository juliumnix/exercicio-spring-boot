package br.udesc.ceavi.edp.dsw.exercicio.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Venda {
    @Id
    @GeneratedValue
    private Long id;

    private Long valor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Cliente cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Produto produto;

    public Venda(Long id, Long valor, Cliente cliente, Produto produto) {
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
        this.produto = produto;
    }
    public Venda(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valor=" + valor +
                ", cliente=" + cliente +
                ", produto=" + produto +
                '}';
    }
}
