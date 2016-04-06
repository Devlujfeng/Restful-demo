/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.advweb.rest;

import java.util.concurrent.ScheduledFuture;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

/**
 *
 * @author cmlee
 */
public class CounterTask implements Runnable {
    
    private int count;
    private final EventOutput eo;
    private ScheduledFuture<?> future = null;
    
    public CounterTask(int c, EventOutput eo) {
        count = c;
        this.eo = eo;
    }
    
    public void setHandle(ScheduledFuture<?> f) {
        future = f;
    }
    
    @Override
    public void run() {
        
        OutboundEvent data = new OutboundEvent.Builder()
            .data(Integer.class, ++count)
            .build();
        
        try {
            eo.write(data);
        } catch (Exception ex) {
            future.cancel(true);
        }
        
        System.out.println(">>> count = " + count);
    }
    
}
