package com.sandbox.sandbox.common.services.beans;

/**
 * Clase que almacena un subservicio
 */
public class BeanSubserviceDefinition {
	private String className;
	private String key; 


	public String getClassName() {
		return className;
	}

	public String getKey() {
		return key;
	}

	public void setClassName(String string) {
		className = string;
	}

	public void setKey(String string) {
		key = string;
	}
	
	public String toString() {
		return key+","+className;
	}

}
