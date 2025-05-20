package com.reciclaville.controller;

import com.reciclaville.dto.DeclaracaoDTO;
import com.reciclaville.service.DeclaracaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/declaracoes")
public class DeclaracaoController {

    private final DeclaracaoService declaracaoService;

    public DeclaracaoController(DeclaracaoService declaracaoService) {
        this.declaracaoService = declaracaoService;
    }

    @GetMapping
    public ResponseEntity<List<DeclaracaoDTO>> listarTodas() {
        return ResponseEntity.ok(declaracaoService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<DeclaracaoDTO> criar(@RequestBody DeclaracaoDTO dto) {
        return ResponseEntity.ok(declaracaoService.criar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeclaracaoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(declaracaoService.buscarPorId(id));
    }
}
