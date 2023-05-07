package com.carlosribeiro.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="autor")

public class Autor
{
    private Long id;
    private String nome;
    private String instituicao;

    // ********* Construtores *********

    public Autor()
    {
    }

    public Autor(String nome,
                   String instituicao)
    {	this.nome = nome;
        this.instituicao = instituicao;
    }

    @Override
    public String toString() {
        return "\nAutor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", instituicao=" + instituicao +
                '}';
    }

    // ********* Métodos do Tipo Get *********

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId()
    {	return id;
    }

    public String getNome()
    {	return nome;
    }

    @Column(name="LANCE_MINIMO")
    public String getInstituicao()
    {	return instituicao;
    }

    // ********* Métodos do Tipo Set *********

    private void setId(Long id)
    {	this.id = id;
    }

    public void setNome(String nome)
    {	this.nome = nome;
    }

    public void setInstituicao(String instituicao)
    {	this.instituicao = instituicao;
    }
}

