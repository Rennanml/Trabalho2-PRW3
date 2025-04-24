package br.edu.ifsp.prw3.api_2025.persistence;

import br.edu.ifsp.prw3.api_2025.domain.Concerto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertoRepository extends JpaRepository<Concerto, String> {
}
