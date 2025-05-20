package com.reciclaville.repository;

import com.reciclaville.model.Declaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclaracaoRepository extends JpaRepository<Declaracao, Long> {
    List<Declaracao> findByClienteId(Long clienteId);
}
