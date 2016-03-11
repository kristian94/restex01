/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Kristian Nielsen
 */

@Provider
public class GenericExceptionMapper implements ExceptionMapper<NullPointerException> {

    @Override
    public Response toResponse(NullPointerException e) {
        return Response.status(500).entity(
                "{\"code\": 500, \"message\": \"Internal server Error, we are very sorry for the inconveniencet\"}"
        ).type(MediaType.APPLICATION_JSON).build();
    }
    
}
