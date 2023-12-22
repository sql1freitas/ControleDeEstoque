package com.matheus.estoque.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Entrada")
public class EntradaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataEntrada;
    @Column(nullable = false)
    @PositiveOrZero
    private Double valorUnidade;


    @Column(nullable = false)
    @PositiveOrZero
    private Integer quantidade;


    public EntradaProduto(Produto produto,String name, LocalDateTime dataEntrada, Double valorUnidade, Integer quantidade) {
        this.produto = produto;
        this.name = name;
        this.dataEntrada = dataEntrada;
        this.valorUnidade = valorUnidade;
        this.quantidade = quantidade;

    }

    public EntradaProduto(){

    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Double getValorUnidade() {
        return valorUnidade;
    }



}
