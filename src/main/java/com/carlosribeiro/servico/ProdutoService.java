package com.carlosribeiro.servico;

import com.carlosribeiro.modelo.Produto;
import com.carlosribeiro.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void inclui(Produto umProduto) {
        produtoRepository.save(umProduto);
        // umProduto.setNome("xyz");
        // produtoRepository.save(umProduto);
    }
    public List<Produto> recuperaProdutos() {
        return produtoRepository.findAll(Sort.by("id"));
    }
}
