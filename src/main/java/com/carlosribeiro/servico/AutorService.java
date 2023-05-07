package com.carlosribeiro.servico;

import com.carlosribeiro.exception.AutorNaoEncontradoException;
import com.carlosribeiro.exception.EstadoDeObjetoObsoletoException;
import com.carlosribeiro.modelo.Autor;
import com.carlosribeiro.repository.AutorRepository;
import corejava.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public void inclui(Autor umAutor) {
        autorRepository.save(umAutor);
        // umAutor.setNome("xyz");
        // autorRepository.save(umAutor);
    }
    public void alterarAutor(long id) throws AutorNaoEncontradoException, EstadoDeObjetoObsoletoException {
        Optional<Autor> autorDoBanco = autorRepository.findById(id);
        if(autorDoBanco.isEmpty()) throw new AutorNaoEncontradoException("Autor não encontrado!");
        Autor UmAutor = autorDoBanco.get();
        System.out.println(UmAutor.toString());
        System.out.println('\n' + "O que você deseja alterar?");
        System.out.println('\n' + "1. Nome");
        System.out.println("2. Instituicao");

        int opcaoAlteracao = Console.readInt('\n' +
                "Digite um número de 1 a 2:");

        switch(opcaoAlteracao){
            case 1: {
                String novoNome = Console.readLine("Digite o novo nome: ");
                UmAutor.setNome(novoNome);
                break;
            }
            case 2: {
                String novaInstituicao = Console.readLine("Digite a nova instituição: ");
                UmAutor.setInstituicao(novaInstituicao);
                break;
            }
        }
        try {
            autorRepository.save(UmAutor);
            System.out.println("Autor alterado com sucesso!");
        } catch (ObjectOptimisticLockingFailureException e){
            throw new EstadoDeObjetoObsoletoException("Conflito de versão, objeto já alterado por outro usuário!");
        }

    }
    public void removerAutor(long id) {
        autorRepository.deleteById(id);
    }
    public List<Autor> recuperaAutores() {
        return autorRepository.findAll(Sort.by("id"));
    }
}
