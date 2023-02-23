package br.udesc.ceavi.edp.dsw.exercicio.JPA;

import br.udesc.ceavi.edp.dsw.exercicio.Beans.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
