package com.example.crudspring.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.crudspring.model.Pessoa;

@Repository
public class PessoaRepository {

    private List<Pessoa> pessoas = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Pessoa> findAll() {
        return pessoas;
    }

    public void save(Pessoa pessoa) {
        if (pessoa.getId() == null) {
            pessoa.setId(counter.incrementAndGet());
        }
        pessoas.add(pessoa);
    }

    public void update(Pessoa pessoa) {
        pessoas.removeIf(p -> p.getId().equals(pessoa.getId()));
        pessoas.add(pessoa);
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoas.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        pessoas.removeIf(p -> p.getId().equals(id));
    }

}
