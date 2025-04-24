package br.edu.ifsp.prw3.api_2025.controller;

import br.edu.ifsp.prw3.api_2025.domain.Concerto;
import br.edu.ifsp.prw3.api_2025.dto.ConcertoDTO;
import br.edu.ifsp.prw3.api_2025.persistence.ConcertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("concertos")
public class ConcertoController {
    @Autowired
    private ConcertoRepository repo;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody ConcertoDTO dto) {
        repo.save(new Concerto(dto));
        System.out.println(dto.toString());
    }
}
