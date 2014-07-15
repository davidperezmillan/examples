package com.sandbox.sandbox.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

/**
 * Helper para la gestion de log, evitando la inclusion de una variable en la clase lanzadora
 * 
 * @author David Perez Millan
 *
 */
public class LogUtiles {

    private static Class  lanzador = null;
    private static Log log = null;

    public LogUtiles(Class lanzador) {
	super();
	this.lanzador = lanzador;
	this.log =  LogFactory.getLog(lanzador);
    }
    
    public static void debug(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.debug(mensaje,t );
    }
    public static void debug(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.debug(mensaje);
    }
 
    public static void info(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.info(mensaje,t );
    }
    public static void info(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.info(mensaje);
    }
    
    public static void trace(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.trace(mensaje,t );
    }
    public static void trace(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.trace(mensaje);
    }
    
    public static void warn(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.warn(mensaje,t );
    }
    public static void warn(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.warn(mensaje);
    }
    
    public static void error(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.error(mensaje,t );
    }
    public static void error(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.error(mensaje);
    }
    
    public static void fatal(Class lanzador, String mensaje, Throwable t ){
	log = LogFactory.getLog(lanzador);
	log.fatal(mensaje,t );
    }
    public static void fatal(Class lanzador, String mensaje){
	log = LogFactory.getLog(lanzador);
	log.fatal(mensaje);
    }
    
    public static void level(String level, Class lanzador, String mensaje, Throwable t){
	log = LogFactory.getLog(lanzador);
	// Reflexion !!!!!
	Class[] types = { Object.class, Throwable.class};
	Method metodo = null;
	try {
	    metodo = log.getClass().getMethod(level,types);
	} catch (NoSuchMethodException e) {
		String message = "No contiene el metodo [ " + level +" ]";
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	}
	Object[] args = { mensaje, t};
	try {
	    metodo.invoke(log, args);
	} catch (IllegalArgumentException e) {
	    String message = "El metodo " + level +" devuelve un tipo no valido";
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	} catch (IllegalAccessException e) {
		String message = "Error en el metodo " + level;
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	} catch (InvocationTargetException e) {
		String message = "Error en el metodo " + level;
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	}
    }    
    
    public static void level(String level, Class lanzador, String mensaje){
	level = level.toLowerCase();
	log = LogFactory.getLog(lanzador);
	// Reflexion !!!!!
	Class[] types = { Object.class};
	Method metodo = null;
	try {
	    metodo = log.getClass().getMethod(level,types);
	} catch (NoSuchMethodException e) {
		String message = "No contiene el metodo " + level;
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	}
	Object[] args = { mensaje};
	try {
	    metodo.invoke(log, args);
	} catch (IllegalArgumentException e) {
	    String message = "El metodo " + level +" devuelve un tipo no valido";
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	} catch (IllegalAccessException e) {
		String message = "Error en el metodo " + level;
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	} catch (InvocationTargetException e) {
		String message = "Error en el metodo " + level;
		log = LogFactory.getLog(LogUtiles.class);
		log.error(message, e);
	}
    }    
    
}

