package com.localiza.aluguelcarros.reports;

import java.io.ByteArrayOutputStream;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.localiza.aluguelcarros.dtos.VeiculoDTO;

public class DadosVeiculoReport {
	
private VeiculoDTO veiculoDTO;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public DadosVeiculoReport(VeiculoDTO veiculoDTO) {
		this.veiculoDTO = veiculoDTO;
	}

	public byte[] createPDF() {
		
		try {
			
			//Construtor
			Document documento = new Document(PageSize.A4);
			//left, right, top, bottom.
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			Image imagem = Image.getInstance(IOUtils.toByteArray(getClass().getResourceAsStream("/static/imagens/"+veiculoDTO.getImagemVeiculo())));
			imagem.setAlignment(Element.ALIGN_CENTER);
			
			documento.add(imagem);
			
				Paragraph dados = new Paragraph();
				dados.add("Código do Veiculo: "+veiculoDTO.getIdVeiculo() + "\n");
				dados.add("Placa do Veiculo: "+veiculoDTO.getPlacaVeiculo() + "\n");
				dados.add("Modelo do Veiculo: "+veiculoDTO.getModeloVeiculo() + "\n");
				dados.add("Ano do Veiculo: "+veiculoDTO.getAnoVeiculo() + "\n");
				dados.add("Montadora do Veiculo: "+veiculoDTO.getMontadoraVeiculo() + "\n");
				dados.add("Status do Veiculo: "+veiculoDTO.getStatusVeiculo() + "\n");
				dados.add("Categoria do Veiculo: "+veiculoDTO.getCategoriaVeiculo() + "\n");
				dados.setSpacingAfter(5);
				documento.add(dados);
				
			documento.close();
			
			return stream.toByteArray();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
