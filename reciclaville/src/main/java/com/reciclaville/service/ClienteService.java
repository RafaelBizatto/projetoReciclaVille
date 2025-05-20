package com.reciclaville.service;

import com.reciclaville.dto.ClienteDTO;
import com.reciclaville.model.Cliente;
import com.reciclaville.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Optional<Cliente> opt = clienteRepository.findById(id);
        return opt.map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public ClienteDTO criar(ClienteDTO dto) {
        Cliente cliente = toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return toDTO(salvo);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    private Cliente toEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        return cliente;
    }
}
