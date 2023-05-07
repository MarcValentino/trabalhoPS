package com.carlosribeiro.repository;

import com.carlosribeiro.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {

}
