package com.localiza.aluguelcarros.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localiza.aluguelcarros.dtos.ClienteDTO;
import com.localiza.aluguelcarros.entities.Cliente;
import com.localiza.aluguelcarros.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvar(ClienteDTO clienteDTO) throws Exception{
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getIdCliente());
		cliente.setNome(clienteDTO.getNomeCliente());
		cliente.setCnh(clienteDTO.getCnhCliente());
		cliente.setTelefone(clienteDTO.getTelefoneCliente());
		cliente.setEndereço(clienteDTO.getEndereçoCliente());
		cliente.setLocacao(clienteDTO.getLocacaoCliente());
		cliente.setImagem(clienteDTO.getImagemCliente());
		cliente.setIdade(clienteDTO.getIdadeCliente());
		clienteRepository.save(cliente);		
	}
	
	public List<ClienteDTO> listarTodos(){
		List<Cliente> lista = clienteRepository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();
		for(Cliente cliente : lista) {
			ClienteDTO clienteDTO = new ClienteDTO();
			clienteDTO.setIdCliente(cliente.getId());
			clienteDTO.setNomeCliente(cliente.getNome());
			clienteDTO.setCnhCliente(cliente.getCnh());
			clienteDTO.setTelefoneCliente(cliente.getTelefone());
			clienteDTO.setEndereçoCliente(cliente.getEndereço());
			clienteDTO.setLocacaoCliente(cliente.getLocacao());
			clienteDTO.setImagemCliente(cliente.getImagem());
			clienteDTO.setIdadeCliente(cliente.getIdade());
			listaDTO.add(clienteDTO);
		}
		return listaDTO;
	}

	public void excluir(Long id)throws Exception {
		Cliente cliente = clienteRepository.findById(id).get();
    	if(cliente != null) {
    		clienteRepository.delete(cliente);
    	}
	}
	
	//Relatorio PDF
    public byte[] gerarRelatorio() {
    	return new ClienteReport(listarTodos()).createPDF();
    }
    
    public byte[] gerarRelatorio(Long id) {
    	return new DadosClienterReport(buscarPorId(id)).createPDF();
    }
    
    public ClienteDTO buscarPorId (Long id) {
    	Cliente cliente = clienteRepository.findById(id).get();
    	ClienteDTO clienteDTO = new ClienteDTO();
    	clienteDTO.setIdCliente(cliente.getId());
		clienteDTO.setNomeCliente(cliente.getNome());
		clienteDTO.setCnhCliente(cliente.getCnh());
		clienteDTO.setTelefoneCliente(cliente.getTelefone());
		clienteDTO.setEndereçoCliente(cliente.getEndereço());
		clienteDTO.setLocacaoCliente(cliente.getLocacao());
		clienteDTO.setImagemCliente(cliente.getImagem());
		clienteDTO.setIdadeCliente(cliente.getIdade());
    	return clienteDTO;
    }
}
    	
    	
    	
    	
    	
