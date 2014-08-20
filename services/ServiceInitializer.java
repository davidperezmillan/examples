package com.sandbox.sandbox.common.services;

import java.io.File;

import org.apache.commons.digester.Digester;

import com.sandbox.sandbox.common.helper.LogUtiles;
import com.sandbox.sandbox.common.services.beans.BeanServiceDefinition;
import com.sandbox.sandbox.common.services.beans.BeanServicesDefinition;
import com.sandbox.sandbox.common.services.beans.BeanSubserviceDefinition;

/**
 * Clase que inicializa los servicios que hay en la aplicación
 */
public class ServiceInitializer {
    public static BeanServicesDefinition initServices(String fileName) {
	BeanServicesDefinition services = null;
	try {
	    Digester digester = new Digester();
	    digester.setValidating(false);
	    digester.setUseContextClassLoader(true);
	    digester.addObjectCreate("services", BeanServicesDefinition.class);
	    digester.addObjectCreate("services/service", BeanServiceDefinition.class);
	    digester.addBeanPropertySetter("services/service/key", "key");
	    digester.addObjectCreate("services/service/subservices/subservice", BeanSubserviceDefinition.class);
	    digester.addBeanPropertySetter("services/service/subservices/subservice/key", "key");
	    digester.addBeanPropertySetter("services/service/subservices/subservice/className", "className");
	    digester.addSetNext("services/service/subservices/subservice", "addSubservice");
	    digester.addSetNext("services/service", "addService");
	    File input = new File(fileName);
	    services = (BeanServicesDefinition) digester.parse(input);
	} catch (Exception exc) {
	    LogUtiles.error(ServiceInitializer.class, exc.getMessage(), exc);
	}
	return services;
    }
}
