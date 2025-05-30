package br.edu.ifsp.prw3.api_2025.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionUtil {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404Exception(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400( MethodArgumentNotValidException ex ) {
        var erros = ex.getFieldErrors();
        var lista = erros.stream().map(DadosErroValidacao::new).toList();
        return ResponseEntity.badRequest().body(lista);
    }

    private record DadosErroValidacao(String campo, String msgErro) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
