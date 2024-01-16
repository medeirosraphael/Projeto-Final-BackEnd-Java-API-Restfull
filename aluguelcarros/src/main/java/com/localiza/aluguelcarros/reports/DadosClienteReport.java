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
import com.localiza.aluguelcarros.dtos.ClienteDTO;

public class DadosClienteReport {
	
private ClienteDTO clienteDTO;
	
	private static Font FONT_TITULO = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
	
	public DadosClienteReport(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
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
			
			Image imagem = Image.getInstance(IOUtils.toByteArray(getClass().getResourceAsStream("/static/imagens/"+clienteDTO.getImagemCliente())));
			imagem.setAlignment(Element.ALIGN_CENTER);
			
			documento.add(imagem);
			
				Paragraph dados = new Paragraph();
				dados.add("Código do Cliente: "+clienteDTO.getIdCliente() + "\n");
				dados.add("Nome do Cliente: "+clienteDTO.getNomeCliente() + "\n");
				dados.add("CNH do Cliente: "+clienteDTO.getCnhCliente() + "\n");
				dados.add("Telefone do Cliente: "+clienteDTO.getTelefoneCliente() + "\n");
				dados.add("Endereço do Cliente: "+clienteDTO.getEndereçoCliente() + "\n");
				dados.add("Status da Locação: "+clienteDTO.getLocacaoCliente() + "\n");
				dados.add("Idade do Cliente: "+clienteDTO.getIdadeCliente() + "\n");
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
