package br.edu.ifsp.prw3.api_2025.controller;

import br.edu.ifsp.prw3.api_2025.domain.Conserto;
import br.edu.ifsp.prw3.api_2025.dto.ConsertoDTO;
import br.edu.ifsp.prw3.api_2025.dto.DadosListagemConsertoDTO;
import br.edu.ifsp.prw3.api_2025.dto.DadosPatchConsertoDTO;
import br.edu.ifsp.prw3.api_2025.persistence.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired
    private ConsertoRepository repo;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> cadastrar(@RequestBody @Valid ConsertoDTO dto) {
        var conserto = new Conserto(dto);
        repo.save(conserto);
        URI uri = UriComponentsBuilder
                .fromPath("/conserto/{id}")
                .buildAndExpand(conserto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(conserto.toDTO());
    }

    @GetMapping
    public ResponseEntity<List<ConsertoDTO>> listar(Pageable pageable) {
        Page<Conserto> lista = repo.findAll(pageable);
        return ResponseEntity.ok(lista.stream().map(Conserto::toDTO).toList());
    }

    @GetMapping("limitado")
    public ResponseEntity<List<DadosListagemConsertoDTO>> listarLimitado(){
        return ResponseEntity.ok(repo.findAllByAtivoTrue().stream().map(DadosListagemConsertoDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsertoDTO> buscarPorId(@PathVariable String id) {
        Optional<Conserto> conserto = repo.findById(id);

        return conserto.map(value -> ResponseEntity.ok(value.toDTO())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> update(@RequestBody @Valid DadosPatchConsertoDTO dto){
        System.out.println("esse é o id -> " + dto.id());
        Optional<Conserto> toBeUpdated = repo.findById(String.valueOf(dto.id()));
        if (toBeUpdated.isPresent()) {
            Conserto conserto = toBeUpdated.get();
            conserto.atualizar(dto);
            return ResponseEntity.ok(conserto.toDTO());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable String id) {
        Optional<Conserto> conserto = repo.findById(id);
        if (conserto.isPresent()) {
            conserto.get().excluir();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
