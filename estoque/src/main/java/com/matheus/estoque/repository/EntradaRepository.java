package com.matheus.estoque.repository;

import com.matheus.estoque.domain.EntradaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<EntradaProduto, Long> {
}
