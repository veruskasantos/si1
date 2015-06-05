package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import models.Anuncio;
import models.Estilo;
import models.EstiloNO;
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
	private static Form<Anuncio> anuncioForm = Form.form(Anuncio.class);
	private static final GenericDAO dao = new GenericDAO();
	private static Long satisfacao = 0L;
	

	@Transactional
	public static Result index() {
		List<Anuncio> result = dao.findAllByClass(Anuncio.class);
		List<Instrumento> result1 = dao.findAllByClass(Instrumento.class);
		List<Estilo> result2 = dao.findAllByClass(Estilo.class);
		List<EstiloNO> result3 = dao.findAllByClass(EstiloNO.class);
		return ok(views.html.novo.render(result, result1, result2, result3, satisfacao));
		//return redirect(routes.Application.books());
	}

	/*
	 * A Anotação transactional é necessária em todas as Actions que
	 * usarem o BD.
	 */
	@Transactional
	public static Result anuncios() {
		
		// Todos os Livros do Banco de Dados
		List<Anuncio> result = dao.findAllByClass(Anuncio.class);
		List<Instrumento> result1 = dao.findAllByClass(Instrumento.class);
		List<Estilo> result2 = dao.findAllByClass(Estilo.class);
		List<EstiloNO> result3 = dao.findAllByClass(EstiloNO.class);
		
		return ok(views.html.index.render(result, result1, result2, result3));
	}

	@Transactional
	public static Result novoAnuncio() {
		// O formulário dos Livros Preenchidos
		Form<Anuncio> filledForm = anuncioForm.bindFromRequest();

		if (filledForm.hasErrors()) {
            List<Anuncio> result = dao.findAllByClass(Anuncio.class);
            List<Instrumento> result1 = dao.findAllByClass(Instrumento.class);
            List<Estilo> result2 = dao.findAllByClass(Estilo.class); 
            List<EstiloNO> result3 = dao.findAllByClass(EstiloNO.class);
            //TODO falta colocar na interface mensagem de erro.
			return badRequest(views.html.index.render(result, result1, result2, result3));
		} else {
			
            Anuncio novoAnuncio = filledForm.get();
            novoAnuncio.addInstrumento(getInstrumentosSelecionados());
            novoAnuncio.addEstiloGosta(getEstilosSelecionados());
            novoAnuncio.addEstiloNaoGosta(getEstilosNGSelecionados());
            
            Logger.debug("Criando livro: " + filledForm.data().toString() + " como " + novoAnuncio.getTitulo()
            		+ " " + novoAnuncio.getDescricao() + " " + novoAnuncio.getCidade() + " " + novoAnuncio.getBairro()
            		+ " " + novoAnuncio.getEmail() + " " + novoAnuncio.getInstrumentos().toString());
           
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
			return redirect(routes.Application.index());
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
		String[] recuperaEstilos = map.get("estilosG");
		
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
	private static List<EstiloNO> getEstilosNGSelecionados(){
		List<EstiloNO> estilos = new ArrayList<EstiloNO>();
		//pega todos os elementos da pag
		Map<String,String[]> map = request().body().asFormUrlEncoded();
		String[] recuperaEstilos = map.get("estilosNG");
		
		if(recuperaEstilos != null){
			List<String> idEstilos = Arrays.asList(recuperaEstilos);
			for(String id : idEstilos){
				Long idEstilo = Long.parseLong(id);
				EstiloNO estilo = dao.findByEntityId(EstiloNO.class, idEstilo);
				if(estilo != null) {
					estilos.add(estilo);
				}
			}
		}
		return estilos;
	}
	
	
	@Transactional
	public static Result removeAnuncio(Long id, String nome, String satisfeito){
		
		Anuncio anuncio = dao.findByEntityId(Anuncio.class, id);
		if(anuncio != null){
			if(anuncio.getCodigo().equals(nome)){
				dao.removeById(Anuncio.class, id);
				dao.flush();
				
				if(satisfeito.equalsIgnoreCase("Sim")){
					satisfacao++;
				}
			}
		}
		
		return redirect(routes.Application.index());
	}

}
