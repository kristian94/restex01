/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kristian94;

import java.util.Set;

/**
 *
 * @author Kristian Nielsen
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(exceptionhandling.GenericExceptionMapper.class);
        resources.add(exceptionhandling.NoQuotesCreatedExceptionMapper.class);
        resources.add(exceptionhandling.NotFoundExceptionMapper.class);
        resources.add(exceptionhandling.QuoteNotFoundExceptionMapper.class);
        resources.add(kristian94.QuoteEndpoint.class);
    }
    
}