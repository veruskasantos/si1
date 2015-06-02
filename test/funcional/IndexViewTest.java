package funcional;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;
import java.util.List;

import models.Livro;
import models.Instrumento;

import org.junit.Before;
import org.junit.Test;

import play.data.Form;
import play.mvc.Content;
import views.html.index;

public class IndexViewTest {

	List<Livro> livros;
	List<Instrumento> instrumentos; //Edit
	Instrumento instrumento1; //Edit
	Livro livro1;

	@Before
	public void iniciaVariaveis() {
		livros = new ArrayList<Livro>();
		livro1 = new Livro("t", "t", "t", "t", "t");
        livro1.setId(1L);
        
        instrumentos = new ArrayList<Instrumento>();
        instrumento1 = new Instrumento("Thomas");
        instrumento1.setId(1L);
        
	}

	// Testa o template index.scala.html
	@Test
	public void indexTemplate() {
		livros.add(livro1);
		instrumentos.add(instrumento1);

		// guarda o html resultante da renderização do index.scala.html
		// com a lista de livros e o formulario
		Content html = index.render(livros, instrumentos);
		assertThat(contentType(html)).isEqualTo("text/html");
		// verifica se o html contém a determimnada string
		assertThat(contentAsString(html)).contains(livro1.getTitulo());
		assertThat(contentAsString(html)).contains(livro1.getContato());
		assertThat(contentAsString(html)).contains(livro1.getDescricao());
		assertThat(contentAsString(html)).contains(instrumento1.getNome());
	}

}
