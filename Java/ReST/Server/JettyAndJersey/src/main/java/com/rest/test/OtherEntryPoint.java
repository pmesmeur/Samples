package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/other-entry-point")
public class OtherEntryPoint {

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        return Response.ok()
                .entity("{\"source\":\"OtherEntryPoint\", \"result\":\"OK\"}")
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}