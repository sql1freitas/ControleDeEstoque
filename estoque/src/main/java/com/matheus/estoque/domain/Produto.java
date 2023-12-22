package com.matheus.estoque.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    @PositiveOrZero
    private Double valorUnidade;

    public Double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    @Column(nullable = false)
    @PositiveOrZero
    private Integer quantidade;

    public Produto(String name, LocalDateTime data, Integer quantidade, Double valorUnidade) {
        this.name = name;
        this.valorUnidade = valorUnidade;
        this.criadoEm = LocalDateTime.now();
        this.quantidade = quantidade;

    }

    public Produto(Long id){
        this.id = id;
    }


    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
