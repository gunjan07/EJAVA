/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca3_rest;

import ca3_business.ClientInstance;
import ca3_business.PodBean;
import ca3_model.Pod;
import com.sun.xml.ws.security.opt.impl.util.SOAPUtil;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinayakPriya
 */
@WebServlet(urlPatterns = {"/callback"})
public class ReceiveData extends HttpServlet  {
@EJB private PodBean pBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("inside get");
        System.out.println(resp.getStatus());
        
        
         req.getParameter("podId");
         req.getParameter("ack_id");
         
         Pod p=pBean.findById(req.getParameter("podId"));
         pBean.updateToDb(p);
         
        
       
        
    }
    
}

