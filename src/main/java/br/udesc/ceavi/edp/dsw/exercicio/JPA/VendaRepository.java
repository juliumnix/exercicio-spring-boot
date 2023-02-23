package br.udesc.ceavi.edp.dsw.exercicio.JPA;

import br.udesc.ceavi.edp.dsw.exercicio.Beans.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
