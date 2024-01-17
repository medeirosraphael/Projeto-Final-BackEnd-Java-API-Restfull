package com.localiza.aluguelcarros.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.localiza.aluguelcarros.dtos.ClienteDTO;
import com.localiza.aluguelcarros.dtos.VeiculoDTO;
import com.localiza.aluguelcarros.entities.Cliente;
import com.localiza.aluguelcarros.entities.Veiculo;
import com.localiza.aluguelcarros.reports.DadosVeiculoReport;
import com.localiza.aluguelcarros.reports.VeiculoReport;
import com.localiza.aluguelcarros.repositories.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public void salvar(VeiculoDTO veiculoDTO) throws Exception{
		Veiculo veiculo = new Veiculo();
		veiculo.setId(veiculoDTO.getIdVeiculo());
		veiculo.setPlaca(veiculoDTO.getPlacaVeiculo());
		veiculo.setModelo(veiculoDTO.getModeloVeiculo());
		veiculo.setAno(veiculoDTO.getAnoVeiculo());
		veiculo.setMontadora(veiculoDTO.getMontadoraVeiculo());
		veiculo.setLocacao(veiculoDTO.getLocacaoVeiculo() == "SIM"? true : false);
		veiculo.setImagem(veiculoDTO.getImagemVeiculo());
		veiculo.setCategoria(veiculoDTO.getCategoriaVeiculo());
		veiculoRepository.save(veiculo);		
	}
	
	public List<VeiculoDTO> listarTodos(){
		List<Veiculo> lista = veiculoRepository.findAll();
		List<VeiculoDTO> listaDTO = new ArrayList<>();
		for(Veiculo veiculo : lista) {
			VeiculoDTO veiculoDTO = new VeiculoDTO();
			veiculoDTO.setIdVeiculo(veiculo.getId());
			veiculoDTO.setPlacaVeiculo(veiculo.getPlaca());
			veiculoDTO.setModeloVeiculo(veiculo.getModelo());
			veiculoDTO.setAnoVeiculo(veiculo.getAno());
			veiculoDTO.setMontadoraVeiculo(veiculo.getMontadora());
			veiculoDTO.setLocacaoVeiculo(veiculo.getLocacao()? "Sim": "Não");
			veiculoDTO.setImagemVeiculo(veiculo.getImagem());
			veiculoDTO.setCategoriaVeiculo(veiculo.getCategoria());
			listaDTO.add(veiculoDTO);
		}
		return listaDTO;
	}

	public void excluir(Long id)throws Exception {
		Veiculo veiculo = veiculoRepository.findById(id).get();
    	if(veiculo != null) {
    		veiculoRepository.delete(veiculo);
    	}
	}
	
	//Relatorio PDF
    public byte[] gerarRelatorio() {
    	return new VeiculoReport(listarTodos()).createPDF();
    }
    
    public byte[] gerarRelatorio(Long id) {
    	return new DadosVeiculoReport(buscarPorId(id)).createPDF();
    }
    
    public VeiculoDTO buscarPorId (Long id) {
    	Veiculo veiculo = veiculoRepository.findById(id).get();
    	VeiculoDTO veiculoDTO = new VeiculoDTO();
    	veiculoDTO.setIdVeiculo(veiculo.getId());
		veiculoDTO.setPlacaVeiculo(veiculo.getPlaca());
		veiculoDTO.setModeloVeiculo(veiculo.getModelo());
		veiculoDTO.setAnoVeiculo(veiculo.getAno());
		veiculoDTO.setMontadoraVeiculo(veiculo.getMontadora());
		veiculoDTO.setLocacaoVeiculo(veiculo.getLocacao()? "Sim": "Não");
		veiculoDTO.setImagemVeiculo(veiculo.getImagem());
		veiculoDTO.setCategoriaVeiculo(veiculo.getCategoria());
    	return veiculoDTO;
    }

}
