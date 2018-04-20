package loja;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Cliente;
import br.unibh.loja.entidades.Produto;

public class Teste {
	@Test
	public void testCriacao() throws ParseException {
		Categoria cat1 = new Categoria(00001L, "Aliemntos");
		assertEquals(cat1.getId(),new Long(00001));
		assertNotEquals(cat1.getDescricao(),"Geral");
		Categoria cat2 = new Categoria(00002L, "Bebidas");
		assertEquals(cat2.getId(),new Long(00002));
		assertEquals(cat2.getDescricao(),"Bebidas");
	
		BigDecimal preco = new BigDecimal(0.30);
		Produto prod1 = new Produto( 00001L, "Pão", "Aliemnto", cat1, preco, "Padaria");
		assertEquals(prod1 .getId(),new Long(1));
		assertEquals(prod1 .getNome(),"Pão");
		assertEquals(prod1 .getDescricao(),"Aliemnto");
		assertEquals(prod1 .getCategoria(),cat1);
		assertEquals(prod1 .getPreco(),new BigDecimal(0.30));
		assertEquals(prod1 .getFabricante(),"Padaria");
	
		
		Date data = new Date();
		
		Cliente c = new Cliente(2L, "Luiz", "Lulu", "33833173", "Ativo", "000000000000000", "33833177", "lulu00@hotmail.com", data, data);
		assertEquals(c.getId(),new Long(2));
		assertEquals(c.getNome(),"Luiz");
		assertEquals(c.getLogin(),"Lulu");
		assertEquals(c.getSenha(),"33833173");
		assertEquals(c.getPerfil(),"Ativo");
		assertEquals(c.getCpf(),"000000000000000");
		assertEquals(c.getTelefone(),"33833177");
		assertEquals(c.getEmail(),"lulu00@hotmail.com");
		assertEquals(c.getDataNascimento(),data);
		assertEquals(c.getDataCadastro(),data);
	}
	

	@Test
	public void testCompareObjects() throws ParseException {
		Date data = new Date();
		
		Cliente c1 = new Cliente(0002L, "Luiz", "Lulu", "33833173", "Ativo", "000000000000000", "33833177", "lulu00@hotmail.com", data, data);
		Cliente c2 = new Cliente(0002L, "Luiz", "Lulu", "33833173", "Ativo", "000000000000000", "33833177", "lulu00@hotmail.com", data, data);
		assertTrue(c1.equals(c2));
		
		Categoria cat1 = new Categoria(00001L, "Alimentos");
		Categoria cat2 = new Categoria(00001L, "Alimentos");
		assertTrue(cat1.equals(cat2));
		
		BigDecimal preco = new BigDecimal(0.30);
		Produto prod1 = new Produto( 00001L, "Pão", "Aliemnto", cat1, preco, "Padaria");
		Produto prod2 = new Produto( 00001L, "Pão", "Aliemnto", cat1, preco, "Padaria");
		assertTrue(prod1.equals(prod2));
		
	
	}


	public void testPrintObject() throws ParseException {
		DateFormat formatter = new SimpleDataFormat();
		Date dataN = (Date)formatter.parse("15/01/1997");
		Date dataC = (Date)formatter.parse("20/01/2018");
		Cliente c1 = new Cliente(0002L, "Luiz", "Lulu", "33833173", "Ativo", "000000000000000", "33833177", "lulu00@hotmail.com", dataN, dataC);
		assertEquals(c1.toString(), "");
	}
	
}