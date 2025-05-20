package com.reciclaville.controller;

import com.reciclaville.dto.MaterialDTO;
import com.reciclaville.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> listarTodos() {
        return ResponseEntity.ok(materialService.listar());
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> criar(@RequestBody MaterialDTO dto) {
        return ResponseEntity.ok(materialService.salvar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.buscarPorId(id));
    }
}
