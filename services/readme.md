Configurar servicios
Los servicios se cargan al iniciar el servidor:

private void servicesInit(ServletConfig config) {
        //String ficheroSer=rutaContexto+"/"+AppProperties.getProperty("path_services");
        String ficheroSer = "C:/david/workspace/workspace/sandbox/WebContent/WEB-INF/services.xml";
        log.info("******** Fichero de servicios inicializadas desde: " + ficheroSer);
        ServicesFactory.setServicesDef(ServiceInitializer.initServices(ficheroSer));
}<br>

  
Al invocar a los servicios se crea un objeto extendido de GenericService. Este objeto puede tener metodos abstractos
y ser padre de los diferentes servicios (incluyendo valores Entrada/Salida) o directamente un servicio implementado
