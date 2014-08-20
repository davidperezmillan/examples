package com.sandbox.sandbox.common.services.beans;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Clase que se encarga de cachear y proporcionar los distintos servicios que ofrece la aplicaciÃ³n.
 */
public class BeanServicesDefinition {
	private Hashtable services=new Hashtable();
	
	public void addService(BeanServiceDefinition service) {
		services.put(service.getKey(),service);
	} 
	
	public BeanServiceDefinition getService(String key) {
		return (BeanServiceDefinition) services.get(key);
	}
	
	public Enumeration getServices(){
		return services.elements();
	
	}
	
	public Hashtable getHtServices(){
		return services;
	}
	
	public String toString() {
		return "{"+services+"}";
	}
}
