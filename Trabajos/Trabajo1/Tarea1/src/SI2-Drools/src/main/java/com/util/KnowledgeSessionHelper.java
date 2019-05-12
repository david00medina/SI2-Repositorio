package com.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {
	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kc = ks.getKieClasspathContainer();
		return kc;
	}
	
	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kc, String sessionName) {
		StatelessKieSession kSession = kc.newStatelessKieSession(sessionName);
		return kSession;
	}
	
	public static KieSession getStatefulKnowledgeSession(KieContainer kc, String sessionName) {
		KieSession kSession = kc.newKieSession(sessionName);
		return kSession;
	}
}
