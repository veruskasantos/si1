package funcional;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;
import java.util.List;

import models.Anuncio;
import models.Estilo;
import models.EstiloNO;
import models.Instrumento;

import org.junit.Before;
import org.junit.Test;

import play.data.Form;
import play.mvc.Content;
import views.html.index;

public class IndexViewTest {

	List<Anuncio> anuncios;
	List<Instrumento> instrumentos; 
	List<Estilo> estilos; 
	List<EstiloNO> estilosNO;
	EstiloNO estiloN;
	Estilo estilo1;
	Instrumento instrumento1; 
	Anuncio anuncio1;

	@Before
	public void iniciaVariaveis() {
		anuncios = new ArrayList<Anuncio>();
		anuncio1 = new Anuncio("tit", "des", "cid", "bai", "em", "fac", "ban", "toc", "seg" );
        anuncio1.setId(1L);
        
        instrumentos = new ArrayList<Instrumento>();
        instrumento1 = new Instrumento("Violão");
        instrumento1.setId(1L);
        
        estilos = new ArrayList<Estilo>();
        estilo1 = new Estilo("Forró");
        estilo1.setId(1L);
        
        estilosNO = new ArrayList<EstiloNO>();
        estiloN = new EstiloNO("Forró");
        estiloN.setId(1L);
        
	}

	// Testa o template novo.scala.html
	@Test
	public void novoTemplate() {
		
		anuncios.add(anuncio1);
		instrumentos.add(instrumento1);
		estilos.add(estilo1);
		estilosNO.add(estiloN);
		int contador = 0;

		// guarda o html resultante da renderização do index.scala.html
		// com a lista de anuncios e o formulario
		Content html = views.html.novo.render(anuncios, instrumentos, estilos, estilosNO, contador);
		assertThat(contentType(html)).isEqualTo("text/html");
		// verifica se o html contém a determimnada string
		assertThat(contentAsString(html)).contains(anuncio1.getTitulo());
		assertThat(contentAsString(html)).contains(anuncio1.getDescricao());
		assertThat(contentAsString(html)).contains(anuncio1.getCidade());
		assertThat(contentAsString(html)).contains(anuncio1.getBairro());
		assertThat(contentAsString(html)).contains(anuncio1.getFacebook());
		assertThat(contentAsString(html)).contains(anuncio1.getBanda());
		assertThat(contentAsString(html)).contains(anuncio1.getTocar());
		assertThat(contentAsString(html)).contains(anuncio1.getEmail());
		assertThat(contentAsString(html)).contains(anuncio1.getDescricao());
		assertThat(contentAsString(html)).contains(instrumento1.getNome());
		assertThat(contentAsString(html)).contains(estilo1.getNome());
	}
	
	// Testa o template index.scala.html
	@Test
	public void indexTemplate(){
		
		anuncios.add(anuncio1);
		instrumentos.add(instrumento1);
		estilos.add(estilo1);
		estilosNO.add(estiloN);
		
		Content html = index.render(anuncios, instrumentos, estilos, estilosNO);
		assertThat(contentType(html)).isEqualTo("text/html");
	}

}
