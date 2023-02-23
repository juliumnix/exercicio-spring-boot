package br.udesc.ceavi.edp.dsw.exercicio.JPA;

import br.udesc.ceavi.edp.dsw.exercicio.Beans.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
