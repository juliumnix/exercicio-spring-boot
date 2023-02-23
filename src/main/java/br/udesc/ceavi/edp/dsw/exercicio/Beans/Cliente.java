package br.udesc.ceavi.edp.dsw.exercicio.Beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cpf;
    private String cnpj;
    private String tipo_cliente;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Venda> venda;
    public Cliente(){

    }
    public Cliente(Long id, String nome, String cpf, String cnpj, String tipo_cliente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.tipo_cliente = tipo_cliente;
    }

    public List<Venda> getVenda() {
        return venda;
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", tipo_cliente='" + tipo_cliente + '\'' +
                '}';
    }
}
