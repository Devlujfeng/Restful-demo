///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.acme.advweb.day4.test;
//
//import com.acme.advweb.web.NewMessageServlet;
//import com.acme.advweb.web.ParticipantList;
//import javax.enterprise.concurrent.ManagedScheduledExecutorService;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
/////import org.junit.Test;
////import static org.junit.Assert.*;
////import org.mockito.ArgumentCaptor;
////import static org.mockito.Mockito.*;
//
///**
// *
// * @author cmlee
// */
//public class NewEmptyJUnitTest {
//    
//    public NewEmptyJUnitTest() {
//    }
//    
//    
//    @Test
//    public void testPostingMessage() {
//        
//        NewMessageServlet servlet = new NewMessageServlet();
//        
//        HttpServletRequest req = mock(HttpServletRequest.class);
//        when(req.getParameter("name")).thenReturn("fred");
//        when(req.getParameter("message")).thenReturn("a message");
//        
//        HttpServletResponse resp = mock(HttpServletResponse.class);
//        
//        ManagedScheduledExecutorService svc = mock(ManagedScheduledExecutorService.class);
//        ParticipantList participants = new ParticipantList();
//        
//        servlet.setMyFristPool(svc);
//        servlet.setParticipantList(participants);
//        
//        try {
//            servlet.doGet(req, resp);
//        } catch (Exception ex) {
//            fail();
//            return;
//        }
//        
//        verify(req).getParameter("name");
//        verify(req).getParameter("message");
//        verify(svc).submit(any(Runnable.class));
//        
//        ArgumentCaptor<Integer> intCaptor = 
//                ArgumentCaptor.forClass(Integer.class);
//        
//        verify(resp).setStatus(intCaptor.capture());
//        
//        assertEquals((Integer)200, intCaptor.getValue());
//    }
//}
