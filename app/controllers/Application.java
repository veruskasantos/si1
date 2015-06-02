package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import models.Anuncio;
import models.Estilo;
import models.Instrumento;
import models.dao.GenericDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Controlador Principal do Sistema
 */
public class Application extends Controller {
	private static Form<Anuncio> bookForm = Form.form(Anuncio.class);
	private static final GenericDAO dao = new GenericDAO();
	

	@Transactional
	public static Result index() {
		
		return ok(views.html.novo.render());
		//return redirect(routes.Application.books());
	}

	/*
	 * A Anotação transactional é necessária em todas as Actions que
	 * usarem o BD.
	 */
	@Transactional
	public static Result books() {
		
		// Todos os Livros do Banco de Dados
		List<Anuncio> result = dao.findAllByClass(Anuncio.class);
		List<Instrumento> result1 = dao.findAllByClass(Instrumento.class);
		List<Estilo> result2 = dao.findAllByClass(Estilo.class);
		
		return ok(views.html.index.render(result, result1, result2));
	}

	@Transactional
	public static Result newBook() {
		// O formulário dos Livros Preenchidos
		Form<Anuncio> filledForm = bookForm.bindFromRequest();

		if (filledForm.hasErrors()) {
            List<Anuncio> result = dao.findAllByClass(Anuncio.class);
            List<Instrumento> result1 = dao.findAllByClass(Instrumento.class);
            List<Estilo> result2 = dao.findAllByClass(Estilo.class); 
            //TODO falta colocar na interface mensagem de erro.
			return badRequest(views.html.index.render(result, result1, result2));
		} else {
			
            Anuncio novoAnuncio = filledForm.get();
            novoAnuncio.addInstrumento(getInstrumentosSelecionados());
            novoAnuncio.addEstilo(getEstilosSelecionados());
            
            Logger.debug("Criando livro: " + filledForm.data().toString() + " como " + novoAnuncio.getTitulo()
            		+ " " + novoAnuncio.getDescricao() + " " + novoAnuncio.getCidade() + " " + novoAnuncio.getBairro()
            		+ " " + novoAnuncio.getContato() + " " + novoAnuncio.getInstrumentos().toString());
           
			// Persiste o Livro criado
			dao.persist(novoAnuncio);
			
			// Espelha no Banco de Dados
			dao.flush();
            /*
             * Usar routes.Application.<uma action> é uma forma de
             * evitar colocar rotas literais (ex: "/books")
             * hard-coded no código. Dessa forma, se mudamos no
             * arquivo routes, continua funcionando.
             */
			return redirect(routes.Application.books());
		}
	}
	
	@Transactional
	private static List<Instrumento> getInstrumentosSelecionados(){
		List<Instrumento> instrumentos = new ArrayList<Instrumento>();
		//pega todos os elementos da pag
		Map<String,String[]> map = request().body().asFormUrlEncoded();
		String[] recuperaInstrumentos = map.get("instrumentos");
		
		if(recuperaInstrumentos != null){
			List<String> idInstrumentos = Arrays.asList(recuperaInstrumentos);
			for(String id : idInstrumentos){
				Long idInstrumento = Long.parseLong(id);
				Instrumento instrumento = dao.findByEntityId(Instrumento.class, idInstrumento);
				if(instrumento != null) {
					instrumentos.add(instrumento);
				}
			}
		}
		return instrumentos;
	}
	
	
	@Transactional
	private static List<Estilo> getEstilosSelecionados(){
		List<Estilo> estilos = new ArrayList<Estilo>();
		//pega todos os elementos da pag
		Map<String,String[]> map = request().body().asFormUrlEncoded();
		String[] recuperaEstilos = map.get("estilos");
		
		if(recuperaEstilos != null){
			List<String> idEstilos = Arrays.asList(recuperaEstilos);
			for(String id : idEstilos){
				Long idEstilo = Long.parseLong(id);
				Estilo estilo = dao.findByEntityId(Estilo.class, idEstilo);
				if(estilo != null) {
					estilos.add(estilo);
				}
			}
		}
		return estilos;
	}
	

	@Transactional
	public static Result addInstrumento(Long id, String nome) {
		criaAutorDoLivro(id, nome);
        return redirect(routes.Application.books());
	}

	private static void criaAutorDoLivro(Long id, String nome) {
		// Cria um novo Autor para um livro de {@code id}
		Instrumento novoInstrumento = new Instrumento(nome);
		// Procura um objeto da classe Livro com o {@code id}
		Anuncio anuncioDaListagem = dao.findByEntityId(Anuncio.class, id);
		// Faz o direcionamento de cada um
		anuncioDaListagem.addInstrumento(novoInstrumento);
		novoInstrumento.addAnuncio(anuncioDaListagem);
		// Persiste o Novo Autor
		dao.persist(novoInstrumento);

		/* As informações do livro já serão automaticamente atualizadas
		 * no BD no final da transação. Isso porque o livro já existe
		 * no BD, e então já é gerenciado por ele.
		 *
		 * Assim fica opcional fazer dao.merge(livroDaListagem);
		 */
		// Espelha no Banco de Dados
		dao.flush();
	}

	// Notação transactional sempre que o método fizer transação com o Banco de
	// Dados.
	@Transactional
	public static Result deleteBook(Long id) {
		// Remove o Livro pelo Id
		dao.removeById(Anuncio.class, id);
		// Espelha no banco de dados
		dao.flush();
		return redirect(routes.Application.books());
	}

}
