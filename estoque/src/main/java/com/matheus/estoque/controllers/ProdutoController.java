package com.matheus.estoque.controllers;

import com.matheus.estoque.domain.EntradaProduto;
import com.matheus.estoque.domain.Produto;
import com.matheus.estoque.repository.EntradaRepository;
import com.matheus.estoque.repository.ProdutoRepository;
import com.matheus.estoque.service.EntradaProdutoService;
import com.matheus.estoque.service.ProdutoService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private EntradaProdutoService entradaProdutoService;
    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;
    private EntradaRepository entradaRepository;

    public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository,
                             EntradaProdutoService entradaProdutoService, EntradaRepository entradaRepository) {
        this.produtoService = produtoService;
        this.produtoRepository = produtoRepository;
        this.entradaProdutoService = entradaProdutoService;
        this.entradaRepository = entradaRepository;

    }


    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> cadastrarProduto (@RequestBody Produto produto){
        Produto novoProduto = produtoService.cadastrarProduto(produto);
        EntradaProduto novaEntrada = entradaProdutoService.toModel(produto);
        entradaProdutoService.cadastrarEntrada(novaEntrada);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}






