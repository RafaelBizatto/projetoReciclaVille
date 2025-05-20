package com.reciclaville.service;

import com.reciclaville.dto.MaterialDTO;
import com.reciclaville.model.Material;
import com.reciclaville.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository repository;

    public MaterialDTO salvar(MaterialDTO dto) {
        Material material = toEntity(dto);
        Material salvo = repository.save(material);
        return toDTO(salvo);
    }

    public List<MaterialDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public MaterialDTO buscarPorId(Long id) {
        Optional<Material> opt = repository.findById(id);
        return opt.map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Material não encontrado"));
    }

    private MaterialDTO toDTO(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setNome(material.getNome());
        dto.setFatorCompensacaoCarbono(material.getFatorCompensacaoCarbono());
        return dto;
    }

    private Material toEntity(MaterialDTO dto) {
        Material material = new Material();
        material.setId(dto.getId());
        material.setNome(dto.getNome());
        material.setFatorCompensacaoCarbono(dto.getFatorCompensacaoCarbono());
        return material;
    }
}
