package com.carlosribeiro.servico;

import com.carlosribeiro.modelo.Autor;
import com.carlosribeiro.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void inclui(Autor umAutor) {
        autorRepository.save(umAutor);
        // umAutor.setNome("xyz");
        // autorRepository.save(umAutor);
    }
    public List<Autor> recuperaAutores() {
        return autorRepository.findAll(Sort.by("id"));
    }
}
