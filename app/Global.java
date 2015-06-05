import play.*;
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
				
				dao.flush();
							
			}});		
	}
		
		public void onStop(Application app) {
    		Logger.info("Aplicação desligada...");
	}
	
}