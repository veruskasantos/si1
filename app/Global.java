import org.joda.time.LocalDate;

import play.*;
import models.Anuncio;
import models.Estilo;
import models.EstiloNO;
import models.Instrumento;
import models.dao.GenericDAO;
import play.db.jpa.JPA;


public class Global extends GlobalSettings {
	
	
	private static GenericDAO dao = new GenericDAO();

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0(){
			@Override
			public void invoke() throws Throwable {
				
				//Adiciona novos instrumentos
				
				Instrumento novoInstrumento = new Instrumento("Violão");
				Instrumento novoInstrumento1 = new Instrumento("Baixo");
				Instrumento novoInstrumento2 = new Instrumento("Guitarra");
				Instrumento novoInstrumento3 = new Instrumento("Flauta");
				Instrumento novoInstrumento4 = new Instrumento("Saxofone");
				Instrumento novoInstrumento5 = new Instrumento("Teclado");
				Instrumento novoInstrumento6 = new Instrumento("Piano");
				Instrumento novoInstrumento7 = new Instrumento("Berimbau");
				Instrumento novoInstrumento8 = new Instrumento("Contrabaixo");
				Instrumento novoInstrumento9 = new Instrumento("Rabeca");
				Instrumento novoInstrumento10 = new Instrumento("Harpa");
				Instrumento novoInstrumento11 = new Instrumento("Sanfona");
				Instrumento novoInstrumento12 = new Instrumento("Triângulo");
				Instrumento novoInstrumento13 = new Instrumento("Zabumba");
				Instrumento novoInstrumento14 = new Instrumento("Violino");
				Instrumento novoInstrumento15 = new Instrumento("Bateria");
				
				
				dao.persist(novoInstrumento);
				dao.persist(novoInstrumento1);
				dao.persist(novoInstrumento2);
				dao.persist(novoInstrumento3);
				dao.persist(novoInstrumento4);
				dao.persist(novoInstrumento5);
				dao.persist(novoInstrumento6);
				dao.persist(novoInstrumento7);
				dao.persist(novoInstrumento8);
				dao.persist(novoInstrumento9);
				dao.persist(novoInstrumento10);
				dao.persist(novoInstrumento11);
				dao.persist(novoInstrumento12);
				dao.persist(novoInstrumento13);
				dao.persist(novoInstrumento14);
				dao.persist(novoInstrumento15);
				
				//==================================================================
				
				//Adiciona novos estilos que gosta
				
				Estilo estilo = new Estilo("Brega");
				Estilo estilo1 = new Estilo("Forró");
				Estilo estilo2 = new Estilo("Acústico");
				Estilo estilo3 = new Estilo("Gospel");
				Estilo estilo4 = new Estilo("Axé");
				Estilo estilo5 = new Estilo("Heavy Metal");
				Estilo estilo6 = new Estilo("Jazz");
				Estilo estilo7 = new Estilo("MPB");
				Estilo estilo8 = new Estilo("Pagode");
				Estilo estilo9 = new Estilo("Samba");
				Estilo estilo10 = new Estilo("Pop");
				Estilo estilo11 = new Estilo("Reggae");
				Estilo estilo12 = new Estilo("Sertanejo");
				Estilo estilo13 = new Estilo("Eletrônico");
				Estilo estilo14 = new Estilo("Funk");
				Estilo estilo15 = new Estilo("HipHop");
				Estilo estilo16 = new Estilo("Rock");
				Estilo estilo17 = new Estilo("Rap");
				Estilo estilo18 = new Estilo("Punk");
				Estilo estilo19 = new Estilo("Blues");
				
				dao.persist(estilo);
				dao.persist(estilo1);
				dao.persist(estilo2);
				dao.persist(estilo3);
				dao.persist(estilo4);
				dao.persist(estilo5);
				dao.persist(estilo6);
				dao.persist(estilo7);
				dao.persist(estilo8);
				dao.persist(estilo9);
				dao.persist(estilo10);
				dao.persist(estilo11);
				dao.persist(estilo12);
				dao.persist(estilo13);
				dao.persist(estilo14);
				dao.persist(estilo15);
				dao.persist(estilo16);
				dao.persist(estilo17);
				dao.persist(estilo18);
				dao.persist(estilo19);
				
				//===============================================================
				
				//Adiciona novos estilos que não gosta
				
				EstiloNO estiloN = new EstiloNO("Brega");
				EstiloNO estiloN1 = new EstiloNO("Forró");
				EstiloNO estiloN2 = new EstiloNO("Acústico");
				EstiloNO estiloN3 = new EstiloNO("Gospel");
				EstiloNO estiloN4 = new EstiloNO("Axé");
				EstiloNO estiloN5 = new EstiloNO("Heavy Metal");
				EstiloNO estiloN6 = new EstiloNO("Jazz");
				EstiloNO estiloN7 = new EstiloNO("MPB");
				EstiloNO estiloN8 = new EstiloNO("Pagode");
				EstiloNO estiloN9 = new EstiloNO("Samba");
				EstiloNO estiloN10 = new EstiloNO("Pop");
				EstiloNO estiloN11 = new EstiloNO("Reggae");
				EstiloNO estiloN12 = new EstiloNO("Sertanejo");
				EstiloNO estiloN13 = new EstiloNO("Eletrônico");
				EstiloNO estiloN14 = new EstiloNO("Funk");
				EstiloNO estiloN15 = new EstiloNO("HipHop");
				EstiloNO estiloN16 = new EstiloNO("Rock");
				EstiloNO estiloN17 = new EstiloNO("Rap");
				EstiloNO estiloN18 = new EstiloNO("Punk");
				EstiloNO estiloN19 = new EstiloNO("Blues");
				
				dao.persist(estiloN);
				dao.persist(estiloN1);
				dao.persist(estiloN2);
				dao.persist(estiloN3);
				dao.persist(estiloN4);
				dao.persist(estiloN5);
				dao.persist(estiloN6);
				dao.persist(estiloN7);
				dao.persist(estiloN8);
				dao.persist(estiloN9);
				dao.persist(estiloN10);
				dao.persist(estiloN11);
				dao.persist(estiloN12);
				dao.persist(estiloN13);
				dao.persist(estiloN14);
				dao.persist(estiloN15);
				dao.persist(estiloN16);
				dao.persist(estiloN17);
				dao.persist(estiloN18);
				dao.persist(estiloN19);
				
				//====================================================================
				
				//Adiciona 25 novos anúncios das últimas semanas
				
				Anuncio anuncio = new Anuncio("Ex1", "Ex1", "Ex1", "Ex1", "Ex1",
						"Ex1", "Ex1", "Ex1", "Ex1", new Instrumento("Violao"));
				anuncio.setData(new LocalDate(2015, 6, 1));
				anuncio.addEstiloGosta(new Estilo("Brega"));
				anuncio.addEstiloNaoGosta(new EstiloNO("Forró"));
				
				Anuncio anuncio1 = new Anuncio("Ex2", "Ex2", "Ex2", "Ex2", "Ex2",
						"Ex2", "Ex2", "Ex2", "Ex2", new Instrumento("Flauta"));
				anuncio1.setData(new LocalDate(2015, 6, 2));
				anuncio1.addEstiloGosta(new Estilo("Brega"));
				
				Anuncio anuncio2 = new Anuncio("Ex3", "Ex3", "Ex3", "Ex3", "Ex3",
						"Ex3", "Ex3", "Ex3", "Ex3", new Instrumento("Bateria"));
				anuncio2.setData(new LocalDate(2015, 5, 10));
				anuncio2.addEstiloNaoGosta(new EstiloNO("Forró"));
				
				Anuncio anuncio3 = new Anuncio("Ex4", "Ex4", "Ex4", "Ex4", "Ex4",
						"Ex4", "Ex4", "Ex4", "Ex4", new Instrumento("Baixo"));
				anuncio3.setData(new LocalDate(2015, 5, 17));
				
				Anuncio anuncio4 = new Anuncio("Ex5", "Ex5", "Ex5", "Ex5", "Ex5",
						"Ex5", "Ex5", "Ex5", "Ex5", new Instrumento("Guitarra"));
				anuncio4.setData(new LocalDate(2015, 6, 5));
				
				Anuncio anuncio5 = new Anuncio("Ex6", "Ex6", "Ex6", "Ex6", "Ex6",
						"Ex6", "Ex6", "Ex6", "Ex6", new Instrumento("Contrabaixo"));
				anuncio5.setData(new LocalDate(2015, 6, 4));
				
				Anuncio anuncio6 = new Anuncio("Ex7", "Ex7", "Ex7", "Ex7", "Ex7",
						"Ex7", "Ex7", "Ex7", "Ex7", new Instrumento("Violao"));
				anuncio6.setData(new LocalDate(2015, 5, 10));
				
				Anuncio anuncio7 = new Anuncio("Ex8", "Ex8", "Ex8", "Ex8", "Ex8",
						"Ex8", "Ex8", "Ex8", "Ex8", new Instrumento("Violao"));
				anuncio7.setData(new LocalDate(2015, 5, 18));
				
				Anuncio anuncio8 = new Anuncio("Ex9", "Ex9", "Ex9", "Ex9", "Ex9",
						"Ex9", "Ex9", "Ex9", "Ex9", new Instrumento("Violao"));
				anuncio8.setData(new LocalDate(2015, 5, 17));
				
				Anuncio anuncio9 = new Anuncio("Ex10", "Ex10", "Ex10", "Ex10", "Ex10",
						"Ex10", "Ex10", "Ex10", "Ex10", new Instrumento("Violao"));
				anuncio9.setData(new LocalDate(2015, 6, 2));
				
				Anuncio anuncio10 = new Anuncio("Ex11", "Ex11", "Ex11", "Ex11", "Ex11",
						"Ex11", "Ex11", "Ex11", "Ex11", new Instrumento("Violao"));
				anuncio10.setData(new LocalDate(2015, 5, 20));
				
				Anuncio anuncio11 = new Anuncio("Ex12", "Ex12", "Ex12", "Ex12", "Ex12",
						"Ex12", "Ex12", "Ex12", "Ex12", new Instrumento("Violao"));
				anuncio11.setData(new LocalDate(2015, 5, 19));
				
				Anuncio anuncio12 = new Anuncio("Ex13", "Ex13", "Ex13", "Ex13", "Ex13",
						"Ex13", "Ex13", "Ex13", "Ex13", new Instrumento("Violao"));
				anuncio12.setData(new LocalDate(2015, 5, 20));
				
				Anuncio anuncio13 = new Anuncio("Ex14", "Ex14", "Ex14", "Ex14", "Ex14",
						"Ex14", "Ex14", "Ex14", "Ex14", new Instrumento("Violao"));
				anuncio13.setData(new LocalDate(2015, 5, 21));
				
				Anuncio anuncio14 = new Anuncio("Ex15", "Ex15", "Ex15", "Ex15", "Ex15",
						"Ex15", "Ex15", "Ex15", "Ex15", new Instrumento("Violao"));
				anuncio14.setData(new LocalDate(2015, 5, 22));
				
				Anuncio anuncio15 = new Anuncio("Ex16", "Ex16", "Ex16", "Ex16", "Ex16",
						"Ex16", "Ex16", "Ex16", "Ex16", new Instrumento("Violao"));
				anuncio15.setData(new LocalDate(2015, 5, 23));
				
				Anuncio anuncio16 = new Anuncio("Ex17", "Ex17", "Ex17", "Ex17", "Ex17",
						"Ex17", "Ex17", "Ex17", "Ex17", new Instrumento("Violao"));
				anuncio16.setData(new LocalDate(2015, 5, 31));
				
				Anuncio anuncio17 = new Anuncio("Ex18", "Ex18", "Ex18", "Ex18", "Ex18",
						"Ex18", "Ex18", "Ex18", "Ex18", new Instrumento("Violao"));
				anuncio17.setData(new LocalDate(2015, 5, 30));
				
				Anuncio anuncio18 = new Anuncio("Ex19", "Ex19", "Ex19", "Ex19", "Ex19",
						"Ex19", "Ex19", "Ex19", "Ex19", new Instrumento("Violao"));
				anuncio18.setData(new LocalDate(2015, 5, 29));
				
				Anuncio anuncio19 = new Anuncio("Ex20", "Ex20", "Ex20", "Ex20", "Ex20",
						"Ex20", "Ex20", "Ex20", "Ex20", new Instrumento("Violao"));
				anuncio19.setData(new LocalDate(2015, 5, 10));
				
				Anuncio anuncio20 = new Anuncio("Ex21", "Ex21", "Ex21", "Ex21", "Ex21",
						"Ex21", "Ex21", "Ex21", "Ex21", new Instrumento("Violao"));
				anuncio20.setData(new LocalDate(2015, 6, 1));
				
				Anuncio anuncio21 = new Anuncio("Ex22", "Ex22", "Ex22", "Ex22", "Ex22",
						"Ex22", "Ex22", "Ex22", "Ex22", new Instrumento("Violao"));
				anuncio21.setData(new LocalDate(2015, 6, 2));
				
				Anuncio anuncio22 = new Anuncio("Ex23", "Ex23", "Ex23", "Ex23", "Ex23",
						"Ex23", "Ex23", "Ex23", "Ex23", new Instrumento("Violao"));
				anuncio22.setData(new LocalDate(2015, 5, 25));
				
				Anuncio anuncio23 = new Anuncio("Ex24", "Ex24", "Ex24", "Ex24", "Ex24",
						"Ex24", "Ex24", "Ex24", "Ex24", new Instrumento("Violao"));
				anuncio23.setData(new LocalDate(2015, 5, 26));
				
				Anuncio anuncio24 = new Anuncio("Ex25", "Ex25", "Ex25", "Ex25", "Ex25",
						"Ex25", "Ex25", "Ex25", "Ex25", new Instrumento("Violao"));
				anuncio24.setData(new LocalDate(2015, 5, 27));
				
				dao.persist(anuncio);
				dao.persist(anuncio1);
				dao.persist(anuncio2);
				dao.persist(anuncio3);
				dao.persist(anuncio4);
				dao.persist(anuncio5);
				dao.persist(anuncio6);
				dao.persist(anuncio7);
				dao.persist(anuncio8);
				dao.persist(anuncio9);
				dao.persist(anuncio10);
				dao.persist(anuncio11);
				dao.persist(anuncio12);
				dao.persist(anuncio13);
				dao.persist(anuncio14);
				dao.persist(anuncio15);
				dao.persist(anuncio16);
				dao.persist(anuncio17);
				dao.persist(anuncio18);
				dao.persist(anuncio19);
				dao.persist(anuncio20);
				dao.persist(anuncio21);
				dao.persist(anuncio22);
				dao.persist(anuncio23);
				dao.persist(anuncio24);
				
				
				dao.flush();
							
			}});		
	}
		
		public void onStop(Application app) {
    		Logger.info("Aplicação desligada...");
	}
	
}