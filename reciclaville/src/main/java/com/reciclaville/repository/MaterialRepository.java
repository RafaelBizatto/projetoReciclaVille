package com.reciclaville.repository;

import com.reciclaville.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    // Exemplo: Optional<Material> findByNome(String nome);
}
