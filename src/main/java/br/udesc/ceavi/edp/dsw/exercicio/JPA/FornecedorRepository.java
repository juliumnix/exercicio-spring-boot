package br.udesc.ceavi.edp.dsw.exercicio.JPA;

import br.udesc.ceavi.edp.dsw.exercicio.Beans.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
