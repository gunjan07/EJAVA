/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_rest;

import ca3_business.ClientInstance;
import ca3_business.PodBean;
import ca3_model.Pod;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.TimerService;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.servlet.http.Part;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.*;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;


/**
 *
 * @author vinayakPriya
 */
//@RequestScoped
//@Path("/upload")
@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig
public class uploadData extends HttpServlet  {
    
    @Resource TimerService service;
    @EJB private PodBean pBean;
    @Inject private ClientInstance client;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
       
        
            String podId = new String(readPart(req.getPart("podId")));
            String note = new String(readPart(req.getPart("note")));
            String time = new String(readPart(req.getPart("time")));
            byte[] image = readPart(req.getPart("image"));

            Pod p=new Pod();
            Date d=new Date(Long.parseLong(time));
            
           
            
            p.setNote(note);
            p.setPodid(Integer.parseInt(podId));
            p.setDate(d);
            
            p.setImage(image);
            pBean.saveintoDB(p);
            uploadToHq(note,podId,d,image);
            
}

     private byte[] readPart(Part p) throws IOException {
        byte[] buffer = new byte[1024 * 8];
        int sz = 0;
        try (InputStream is = p.getInputStream()) {
            BufferedInputStream bis = new BufferedInputStream(is);
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                while (-1 != (sz = bis.read(buffer))) {
                    baos.write(buffer, 0, sz);
                }
                buffer = baos.toByteArray();
            }
        }
        return buffer;
    }
     
  @Schedule(second="*/30")          
  public void uploadToHq(String note,String podId,Date date,byte[] img) throws IOException{
                Client client = ClientBuilder.newBuilder()
                                             .register(MultiPartFeature.class)
                                             .build();
            
            MultiPart m=new MultiPart();
         
            BodyPart p=new BodyPart(img,MediaType.APPLICATION_OCTET_STREAM_TYPE);
          
                     p.setContentDisposition(FormDataContentDisposition.name("image").fileName("ca3.jpg").build());
                                           

                        MultiPart formData = new FormDataMultiPart()
                            .field("teamId","a2f7a747",MediaType.TEXT_PLAIN_TYPE)  
                            .field("podId", podId, MediaType.TEXT_PLAIN_TYPE)
                            .field("note", note, MediaType.TEXT_PLAIN_TYPE)
                            .field("callback","http://10.10.24.121:8080/week5_ca/callback")
                            .field("time", Long.toString(System.currentTimeMillis()), MediaType.TEXT_PLAIN_TYPE)
                            .bodyPart(p);
            
            formData.setMediaType(MediaType.MULTIPART_FORM_DATA_TYPE);


            WebTarget target=client.target("http://10.10.0.50:8080/epod/upload");

            Invocation.Builder inv = target.request();

            System.out.println(">>> part: " + formData);

            Response callResp = inv.post(Entity.entity(formData, formData.getMediaType()));

            System.out.println(">> call resp:" + callResp.getStatus());
            }
           
    };
            
    
 
    

