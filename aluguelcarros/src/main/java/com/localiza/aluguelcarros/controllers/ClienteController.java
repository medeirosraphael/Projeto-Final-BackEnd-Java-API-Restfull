package com.localiza.aluguelcarros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.localiza.aluguelcarros.dtos.ClienteDTO;
import com.localiza.aluguelcarros.enums.MensagemEnum;
import com.localiza.aluguelcarros.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cliente")
@Tag(name = "Clientes", description = "Clientes Localiza API")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	@Operation(summary = "", description = "Listar todos os dados dos clientes.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	public List<ClienteDTO> listarTodos(){
		return clienteService.listarTodos();
	}	
	
	@PostMapping("/salvar")
	@Operation(summary = "", description = "Salvar os dados do cliente.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	public ResponseEntity salva(@RequestBody ClienteDTO clienteDTO) {
		try {
			clienteService.salvar(clienteDTO);
			return ResponseEntity.ok(MensagemEnum.CADASTRADO.getDescricao());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	}
	
	@PostMapping("/atualizar")
	@Operation(summary = "", description = "Atualizar os dados do cliente.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")

	public ResponseEntity atualizar(@RequestBody ClienteDTO clienteDTO) {
	try {
		clienteService.salvar(clienteDTO);
		return ResponseEntity.ok(MensagemEnum.ATUALIZADO.getDescricao());
	}catch (Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	
	}
	
	@PostMapping("/excluir/{id}")
	@Operation(summary = "", description = "Dados do cliente excluido.")
    @ApiResponse(responseCode = "200", description = "Sucesso!")
    @ApiResponse(responseCode = "404", description = "Não encontrado!")
	
	public ResponseEntity excluir(@PathVariable Long id) {
		try {
			clienteService.excluir(id);
			return ResponseEntity.ok(MensagemEnum.EXCLUIDO.getDescricao());
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	
	}
	
	@GetMapping("/gerar/relatorio")
	@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
	public ResponseEntity gerarRelatorio() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData(
				"attachment", "clientes.pdf");
		return ResponseEntity.ok().headers(headers)
				.body(clienteService.gerarRelatorio());
	}
	
	@GetMapping("/gerar/relatorio/{id}")
	@Operation(summary = "", description = "Realizar download do relatorio em PDF.")
	public ResponseEntity gerarRelatorio(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "cliente.pdf");
		return ResponseEntity.ok().headers(headers).body(clienteService.gerarRelatorio(id));
	}
}
