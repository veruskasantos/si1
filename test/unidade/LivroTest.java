package unidade;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import models.Instrumento;
import models.Livro;
import models.dao.GenericDAO;

import org.junit.Test;

import base.AbstractTest;

public class LivroTest extends AbstractTest {

    GenericDAO dao = new GenericDAO();
	List<Livro> livros;
	List<Instrumento> instrumentos;
	
	@Test
	public void deveSalvarLivroSemAutor () {
		livros = dao.findAllByClass(Livro.class); //consulta o bd
		assertThat(livros.size()).isEqualTo(0);
		
		Livro l1 = new Livro("Biblia Sagrada");
		dao.persist(l1);
		
		livros = dao.findAllByClass(Livro.class); //consulta o bd
		assertThat(livros.size()).isEqualTo(1);
		assertThat(livros.get(0).getTitulo()).isEqualTo("Biblia Sagrada");
	}
	
	@Test
	public void deveSalvarLivroComAutor() {
		Instrumento i1 = new Instrumento("George Martin");
		Livro l1 = new Livro("A Game of Thrones", i1); // cria o livro com autor
		i1.addAnuncio(l1); // add o livro ao autor
		
		dao.persist(l1); // salva tudo junto
		
		livros = dao.findAllByClass(Livro.class); // carrega os livros com seu autor
		assertThat(livros.size()).isEqualTo(1);
		assertThat(livros.get(0).getTitulo()).isEqualTo("A Game of Thrones");
		assertThat(livros.get(0).getInstrumentos().size()).isEqualTo(1);
		
		instrumentos = dao.findAllByClass(Instrumento.class); // carrega os instrumentos com seus livros
		assertThat(instrumentos.size()).isEqualTo(1);
		assertThat(instrumentos.get(0).getNome()).isEqualTo("George Martin");
		assertThat(instrumentos.get(0).getAnuncios().size()).isEqualTo(1);
	}
}
