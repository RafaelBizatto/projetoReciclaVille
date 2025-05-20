package com.reciclaville.service;

import com.reciclaville.dto.DeclaracaoDTO;
import com.reciclaville.model.Declaracao;
import com.reciclaville.repository.DeclaracaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeclaracaoService {

    private final DeclaracaoRepository declaracaoRepository;

    public List<DeclaracaoDTO> listarTodas() {
        return declaracaoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public DeclaracaoDTO criar(DeclaracaoDTO dto) {
        Declaracao declaracao = toEntity(dto);
        Declaracao salva = declaracaoRepository.save(declaracao);
        return toDTO(salva);
    }

    public DeclaracaoDTO buscarPorId(Long id) {
        Optional<Declaracao> opt = declaracaoRepository.findById(id);
        return opt.map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Declaração não encontrada"));
    }

    private DeclaracaoDTO toDTO(Declaracao declaracao) {
        DeclaracaoDTO dto = new DeclaracaoDTO();
        dto.setId(declaracao.getId());
        dto.setData(declaracao.getData());
        dto.setCliente(declaracao.getCliente());
        return dto;
    }

    private Declaracao toEntity(DeclaracaoDTO dto) {
        Declaracao declaracao = new Declaracao();
        declaracao.setId(dto.getId());
        declaracao.setData(dto.getData());
        declaracao.setCliente(dto.getCliente());
        return declaracao;
    }
}
