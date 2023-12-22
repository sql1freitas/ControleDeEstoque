package com.matheus.estoque.service;


import com.matheus.estoque.domain.EntradaProduto;
import com.matheus.estoque.domain.Produto;
import com.matheus.estoque.repository.EntradaRepository;
import com.matheus.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class EntradaProdutoService {

     private EntradaRepository entradaRepository;

    private EntradaProdutoService(EntradaRepository entradaRepository){

        this.entradaRepository = entradaRepository;
    }


    public EntradaProduto toModel(Produto produto){

        return new EntradaProduto(produto,produto.getName(),produto.getCriadoEm(), produto.getValorUnidade(), produto.getQuantidade());
    }

    public EntradaProduto cadastrarEntrada(EntradaProduto entradaProduto){
        return entradaRepository.save(entradaProduto);

    }






}
