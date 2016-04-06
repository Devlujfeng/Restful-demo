package com.acme.advweb.rest;

import com.acme.advweb.web.BroadcastMessageTask;
import com.acme.advweb.web.ParticipantList;
import java.io.IOException;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;

@RequestScoped
@Path("/chatroom")
public class ChatroomResource {
    @Inject private ParticipantList participants;
    @Resource(lookup = "concurrent/myFirstPool")
    private ManagedScheduledExecutorService service;
    
    
     @GET     
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public Response connect() {
        
         System.out.println(">>> new connection ");
         EventOutput eo = new EventOutput();
         participants.add(eo);
         return (Response.ok(eo).build());
    }

    @GET
    @Path("/newMessage2")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    
    public Response get(
             @QueryParam("name")String name,
             @QueryParam("message")String msg) {
      
        EventOutput eo = new EventOutput();
        
        System.out.println(name + ">>> " + msg);
        
        service.submit(new BroadcastMessageTask(name, msg, participants));
        
        return (Response.ok(eo).build());
    }   
}
