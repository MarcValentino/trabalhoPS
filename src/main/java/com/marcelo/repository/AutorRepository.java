package com.marcelo.repository;

import com.marcelo.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    @Query("Select a from Autor a where a.nome like %?1%")
    List<Autor> buscaAutorPorNome(String nome);

    @Query("Select a from Autor a where a.instituicao like %?1%")
    List<Autor> buscaAutorPorInstituicao(String instituicao);
}
