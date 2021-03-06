package funcional;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.charset;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.redirectLocation;
import static play.test.Helpers.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import models.Anuncio;
import models.dao.GenericDAO;

import org.junit.Test;

import play.mvc.Http;
import play.mvc.Result;
import base.AbstractTest;

public class ApplicationControllerTest extends AbstractTest {

	Result result;
	EntityManager em;
	
	@Test
	public void callIndex() {
		// realiza a chamada ao método index() do Application
		result = callAction(controllers.routes.ref.Application.index(),
				fakeRequest());
		// ao chamar o metodo index do Application, ele redireciona para '/books'
		assertThat(status(result)).isEqualTo(Http.Status.OK); //Edit
		//assertThat(status(result)).isEqualTo(Http.Status.SEE_OTHER);
		//assertThat(redirectLocation(result)).isEqualTo("/books");
	}
	
	@Test
	public void callAnuncios() {
		// realiza a chamada ao método anuncios() do Application
		result = callAction(controllers.routes.ref.Application.anuncios(),
				fakeRequest());
		// ao chamar o método index do Application, ele retora o html
		// correspondente.
		assertThat(status(result)).isEqualTo(Http.Status.OK);
		assertThat(charset(result)).isEqualTo("utf-8");
		assertThat(contentAsString(result)).contains("0 anúncio(s)");
	}
	
	@Test
	public void callNewBook() {
		// Mapa com os dados do formulario para criação do livro
		Map<String, String> formData = new HashMap<String, String>();
		formData.put("titulo", "Banda");
		
		// realiza a chamada ao método newBook() do Application com o
		// formulário.
		result = callAction(
				controllers.routes.ref.Application.newBook(), fakeRequest()
						.withFormUrlEncodedBody(formData));
		
		// ao chamar o método newBook do Application, ele adiciona o livro e
		// redireciona para a url '/books'
		assertThat(status(result)).isEqualTo(Http.Status.SEE_OTHER);
		assertThat(redirectLocation(result)).isEqualTo("/books");

		// testa se realmente adicionou o anúncio com nome "Anuncio" no banco de
		// dados.
        GenericDAO dao = new GenericDAO();
		List<Anuncio> anuncios = dao.findAllByClass(Anuncio.class);
		assertThat(anuncios.size()).isEqualTo(1);
        assertThat(anuncios.get(0).getTitulo()).isEqualTo("Banda");
		List<Anuncio> result2 = dao.findByAttributeName("Anuncio", 
				"titulo", "Banda");	
		assertThat(result2.size()).isEqualTo(1);
		
		// verifica o html gerado pela url '/books' que é chamada dentro do newBook
		result = callAction(controllers.routes.ref.Application.books(),
				fakeRequest());
		assertThat(status(result)).isEqualTo(Http.Status.OK);
		assertThat(contentAsString(result)).contains("1 anúncio(s)");
	}
}