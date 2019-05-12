package com.main;

import java.util.Arrays;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.concept.cliente.Cliente;
import com.concept.cliente.InfoEconomica;
import com.concept.cliente.InfoPersonal;
import com.concept.destino.Destino;
import com.type.Educacion;
import com.type.Idioma;
import com.type.Interes;
import com.type.TipoEdad;
import com.util.KnowledgeSessionHelper;

public class ValoracionTuristica {
	public static void main(String[] args) {
		try {
			System.out.println("Ejecutando Motor de Valoración Turística...");
			
			KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
			KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kContainer, "ksession-process");
			
			Cliente cliente = new Cliente();
			InfoPersonal iPersonal = new InfoPersonal();
			InfoEconomica iEconomica = new InfoEconomica();
			
			iPersonal.setNombre("Stefan");
			iPersonal.setDiscapacidad(true);
			iPersonal.setEdad(61);
			iPersonal.setEducacion(Educacion.UNIVERSITARIO);
			iPersonal.setHijos(2);
			iPersonal.setIdioma(Arrays.asList(Idioma.INGLES, Idioma.ALEMAN, Idioma.ESPANOL));
			iPersonal.setIntereses(Arrays.asList(Interes.DEPORTIVO, Interes.ENTRETENIMIENTO, Interes.CULTURAL));
			
			iEconomica.setCosteMax(1000.f);
			iEconomica.setImpagosPrevios(false);
			
			cliente.setInfoPersonal(iPersonal);
			cliente.setInfoEconomica(iEconomica);
			
			Destino destino = new Destino();
			destino.setPais("España");
			destino.setDestino("Port Aventura");
			destino.setAtractivoTuristico(Arrays.asList(Interes.ENTRETENIMIENTO));
			destino.setIdioma(Arrays.asList(Idioma.INGLES, Idioma.ESPANOL, Idioma.FRANCES));
			destino.setRecomendacionEdad(Arrays.asList(TipoEdad.ADULTO_JOVEN, TipoEdad.ADULTO));
			destino.setCoste(200);
			destino.setUmbralFisico(3);
			destino.setUmbralEntretenimiento(5);
			destino.setUmbralCultural(1);
			
			Destino destino2 = new Destino();
			destino2.setPais("Polonia");
			destino2.setDestino("Jasna Góra");
			destino2.setAtractivoTuristico(Arrays.asList(Interes.CULTURAL));
			destino2.setIdioma(Arrays.asList(Idioma.POLACO, Idioma.INGLES));
			destino2.setRecomendacionEdad(Arrays.asList(TipoEdad.ADULTO, TipoEdad.TERCERA_EDAD));
			destino2.setCoste(100);
			destino2.setUmbralFisico(1);
			destino2.setUmbralEntretenimiento(1);
			destino2.setUmbralCultural(5);
			
			kSession.insert(cliente);
			kSession.insert(cliente);
			kSession.insert(destino);
			kSession.insert(destino2);
			
			kSession.startProcess("com.sample.bpmn.inferencegraph");
			
			System.out.println("\n[+] Se han disparado " + kSession.getFactCount() 
			+ " reglas distintas en total");
		
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
