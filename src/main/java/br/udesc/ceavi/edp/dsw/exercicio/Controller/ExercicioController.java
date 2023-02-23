package br.udesc.ceavi.edp.dsw.exercicio.Controller;

import br.udesc.ceavi.edp.dsw.exercicio.Beans.Cliente;
import br.udesc.ceavi.edp.dsw.exercicio.Beans.Fornecedor;
import br.udesc.ceavi.edp.dsw.exercicio.Beans.Produto;
import br.udesc.ceavi.edp.dsw.exercicio.Beans.Venda;
import br.udesc.ceavi.edp.dsw.exercicio.DTO.VendaDTO;
import br.udesc.ceavi.edp.dsw.exercicio.JPA.ClienteRepository;
import br.udesc.ceavi.edp.dsw.exercicio.JPA.FornecedorRepository;
import br.udesc.ceavi.edp.dsw.exercicio.JPA.ProdutoRepository;
import br.udesc.ceavi.edp.dsw.exercicio.JPA.VendaRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ExercicioController {
    private ClienteRepository clienteRepository;
    private FornecedorRepository fornecedorRepository;
    private ProdutoRepository produtoRepository;
    private VendaRepository vendaRepository;

    public ExercicioController(ClienteRepository clienteRepository, FornecedorRepository fornecedorRepository, ProdutoRepository produtoRepository, VendaRepository vendaRepository) {
        this.clienteRepository = clienteRepository;
        this.fornecedorRepository = fornecedorRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteRepository.save(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCliente.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/cliente")
    public List<Cliente> allClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable Long id) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()) {
            throw new Exception("Cliente não encontrado com id " + id);
        }
        return cliente.get();
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

    @PostMapping("/produto/{id}")
    public ResponseEntity<Produto> createProduto(@PathVariable Long id,  @RequestBody Produto produto) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        produto.setFornecedor(fornecedor.get());
        Produto savedCliente = produtoRepository.save(produto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCliente.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/produto")
    public List<Produto> allProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto getProduto(@PathVariable Long id) throws Exception {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new Exception("Produto não encontrado com id " + id);
        }
        return produto.get();
    }

    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

    @PostMapping("/fornecedor")
    public ResponseEntity<Produto> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor savedCliente = fornecedorRepository.save(fornecedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCliente.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/fornecedor")
    public List<Fornecedor> allFornecedor() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("/fornecedor/{id}")
    public Fornecedor getFornecedor(@PathVariable Long id) throws Exception {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (fornecedor.isEmpty()) {
            throw new Exception("Produto não encontrado com id " + id);
        }
        return fornecedor.get();
    }

    @DeleteMapping("/fornecedor/{id}")
    public void deleteFornecedor(@PathVariable Long id) {
        fornecedorRepository.deleteById(id);
    }

    @PostMapping("/venda/{idCliente}/{idProduto}")
    public ResponseEntity<Venda> createVenda(@PathVariable Long idCliente,
                                             @PathVariable Long idProduto,
                                             @RequestBody Venda venda) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        venda.setCliente(cliente.get());
        venda.setProduto(produto.get());
        Venda savedVenda = vendaRepository.save(venda);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVenda.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/venda/{idCliente}")
    public List<VendaDTO> getVendaById(@PathVariable Long idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        Example<Cliente> clienteExample = Example.of(cliente);
        Optional<Cliente> res = clienteRepository.findOne(clienteExample);
        if (res != null) {
            List<VendaDTO> listaVendaDTO = new ArrayList<>();
            for (Venda vend : res.get().getVenda()) {
                VendaDTO vendaDTO = new VendaDTO();
                vendaDTO.setNomeProduto(vend.getProduto().getDescricao());
                vendaDTO.setNomeFornecedor(vend.getProduto().getFornecedor().getNome());
                vendaDTO.setValor(vend.getValor());
                vendaDTO.setId(vend.getId());
                listaVendaDTO.add(vendaDTO);
            }
            return listaVendaDTO;
        } else {
            return null;
        }
    }
}
