package br.udesc.ceavi.edp.dsw.exercicio.DTO;

public class VendaDTO {
    private Long valor;
    private String nomeProduto;
    private String nomeFornecedor;
    private Long id;
    public VendaDTO() {
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TarefaDTO{" +
                "valor=" + valor +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", id=" + id +
                '}';
    }
}
