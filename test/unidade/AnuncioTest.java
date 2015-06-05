package unidade;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Anuncio;
import models.Instrumento;
import models.dao.GenericDAO;

import org.junit.Test;

import base.AbstractTest;

public class AnuncioTest extends AbstractTest {

    GenericDAO dao = new GenericDAO();
	List<Anuncio> anuncios;
	List<Instrumento> instrumentos;
	
	@Test
	public void deveSalvarAnuncioSemInstrumento () {
		anuncios = dao.findAllByClass(Anuncio.class); //consulta o bd
		assertThat(anuncios.size()).isEqualTo(0);
		
		Anuncio a1 = new Anuncio("Formar Banda");
		dao.persist(a1);
		
		anuncios = dao.findAllByClass(Anuncio.class); //consulta o bd
		assertThat(anuncios.size()).isEqualTo(1);
		assertThat(anuncios.get(0).getTitulo()).isEqualTo("Formar Banda");
	}
	
	@Test
	public void deveSalvarAnuncioComInstrumento() {
		Instrumento i1 = new Instrumento("Violão");
		Anuncio l1 = new Anuncio("Novo Anúncio", i1);
		i1.addAnuncio(l1);
		
		dao.persist(l1);
		
		anuncios = dao.findAllByClass(Anuncio.class);
		assertThat(anuncios.size()).isEqualTo(1);
		assertThat(anuncios.get(0).getTitulo()).isEqualTo("Novo Anúncio");
		assertThat(anuncios.get(0).getInstrumentos().size()).isEqualTo(1);
		
		instrumentos = dao.findAllByClass(Instrumento.class); // carrega os instrumentos com seus anuncios
		assertThat(instrumentos.size()).isEqualTo(1);
		assertThat(instrumentos.get(0).getNome()).isEqualTo("Violão");
		assertThat(instrumentos.get(0).getAnuncios().size()).isEqualTo(1);
	}
}
