package com.reciclaville.repository.declaracao;

import com.reciclaville.model.ItemDeclaracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDeclaracaoRepository extends JpaRepository<ItemDeclaracao, Long> {
    List<ItemDeclaracao> findByDeclaracaoId(Long declaracaoId);
}