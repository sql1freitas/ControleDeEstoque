package com.matheus.estoque.service;

import com.matheus.estoque.domain.EntradaProduto;
import com.matheus.estoque.domain.Produto;
import com.matheus.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;


    private ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }


    public Produto cadastrarProduto(Produto produto){
       return produtoRepository.save(produto);
    }
    public Produto atualizarProduto(Produto produto, Long id){
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);

    }
}
