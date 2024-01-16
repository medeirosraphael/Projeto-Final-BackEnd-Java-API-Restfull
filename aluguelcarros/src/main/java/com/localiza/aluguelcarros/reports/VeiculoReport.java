package com.localiza.aluguelcarros.reports;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.localiza.aluguelcarros.dtos.VeiculoDTO;

public class VeiculoReport {

private List<VeiculoDTO> lista;
	
	private static Font FONT_TITULO =
			new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public VeiculoReport(List<VeiculoDTO> lista) {
		this.lista = lista;
	}
	
	public byte[] createPDF() {
		
		try {
			
			Document documento = new Document(PageSize.A4);
			//left, right, top, bottom.
			documento.setMargins(20, 20, 20, 20);
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PdfWriter.getInstance(documento, stream);
			
			documento.open();
			
			/*Image logo = Image.getInstance(
					IOUtils.toByteArray(
							getClass().getResourceAsStream("/static/imagens/animal.png")));
			
			documento.add(logo);*/
			
			Paragraph titulo = new Paragraph();
			Phrase phrase = new Phrase("Relatório de Clientes", FONT_TITULO);
			titulo.add(phrase);
			titulo.setAlignment(Element.ALIGN_CENTER);
			titulo.setSpacingAfter(20);
			
			documento.add(titulo);
			
			for(VeiculoDTO veiculoDTO: lista) {
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
			}
						
			documento.close();
			
			return stream.toByteArray();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
