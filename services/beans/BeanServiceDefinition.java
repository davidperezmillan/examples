package com.sandbox.sandbox.common.services.beans;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Almacenamos los servicios
 */
public class BeanServiceDefinition {
	private String key;
	private Hashtable subservices=new Hashtable();
	
	public void addSubservice(BeanSubserviceDefinition subservice) {
		subservices.put(subservice.getKey(),subservice);
	} 
	
	public BeanSubserviceDefinition getSubservice(String key) {
		return (BeanSubserviceDefinition) subservices.get(key);
	}
	
	public Enumeration getSubservices(){
		return subservices.elements();
	
	}

	public String getKey() {
		return key;
	}


	public void setKey(String string) {
		key = string;
	}
	
	public String toString() {
		return "{"+key+":"+subservices+"}";
	}


}
