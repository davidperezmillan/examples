package com.sandbox.sandbox.common.services;


import com.sandbox.sandbox.common.services.beans.BeanServicesDefinition;

/**
 * Clase que se encarga de proporcionar los servicios de la aplicación.
 */
public class ServicesFactory {
    private static BeanServicesDefinition servicesDef = null;

    public static GenericService getService(String key) throws Exception {
	GenericService service = null;
	service = getService(key, "default");
	return service;
    }


    public static GenericService getService(String key, String variant) throws Exception {
	GenericService service = null;
	StringBuffer sbVariant = new StringBuffer(variant);
	Class clase = Class.forName(servicesDef.getService(key).getSubservice(sbVariant.toString()).getClassName());
	service = (GenericService) clase.newInstance();
	return service;
    }


    public static BeanServicesDefinition getServicesDef() {
	return servicesDef;
    }

    public static void setServicesDef(BeanServicesDefinition definition) {
	servicesDef = definition;
    }

}
