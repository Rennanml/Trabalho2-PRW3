package br.edu.ifsp.prw3.api_2025.persistence;

import br.edu.ifsp.prw3.api_2025.domain.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, String> {

    List<Conserto> findAllByAtivoTrue();
}
