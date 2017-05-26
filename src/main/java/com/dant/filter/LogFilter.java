package com.dant.filter;

import javax.ws.rs.container.ContainerRequestContext;
        import javax.ws.rs.container.ContainerRequestFilter;
        import javax.ws.rs.container.ContainerResponseContext;
        import javax.ws.rs.container.ContainerResponseFilter;
        import java.io.*;
        import java.util.logging.Logger;

/**
 * Created by nguye on 25/05/2017.
 */
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger log = Logger.getLogger(LogFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Called when a request comes
        log.info("A request is here : " + requestContext.getMethod() + " " + requestContext.getUriInfo().getPath());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        // Called at the end, after the endpoint response
        log.info("The end");
    }
}