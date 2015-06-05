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
		
		Anuncio a1 = new Anuncio("Biblia Sagrada");
		dao.persist(a1);
		
		anuncios = dao.findAllByClass(Anuncio.class); //consulta o bd
		assertThat(anuncios.size()).isEqualTo(1);
		assertThat(anuncios.get(0).getTitulo()).isEqualTo("Biblia Sagrada");
	}
	
	@Test
	public void deveSalvarAnuncioComInstrumento() {
		Instrumento i1 = new Instrumento("George Martin");
		Anuncio l1 = new Anuncio("A Game of Thrones", i1); // cria o livro com autor
		i1.addAnuncio(l1); // add o livro ao autor
		
		dao.persist(l1); // salva tudo junto
		
		anuncios = dao.findAllByClass(Anuncio.class); // carrega os anuncios com seu autor
		assertThat(anuncios.size()).isEqualTo(1);
		assertThat(anuncios.get(0).getTitulo()).isEqualTo("A Game of Thrones");
		assertThat(anuncios.get(0).getInstrumentos().size()).isEqualTo(1);
		
		instrumentos = dao.findAllByClass(Instrumento.class); // carrega os instrumentos com seus anuncios
		assertThat(instrumentos.size()).isEqualTo(1);
		assertThat(instrumentos.get(0).getNome()).isEqualTo("George Martin");
		assertThat(instrumentos.get(0).getAnuncios().size()).isEqualTo(1);
	}
}
