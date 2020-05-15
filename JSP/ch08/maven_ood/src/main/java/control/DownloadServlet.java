/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MASTER
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/ch08/FileDownloadWithFilter/download.do"})
public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            String targetDirectory = request.getParameter("AbsolutePath");
            String selectedFile = request.getParameter("file_name"); //7장과 다른 부분 (수정!)
            
            //read file
            File f = new File(targetDirectory + "/" + selectedFile);
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            //response header setting
            response.setHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "inline; filename=" + URLEncoder.encode(selectedFile, "UTF-8"));
            
            //Write file
            ServletOutputStream sos = response.getOutputStream();
            while(bis.available() > 0) {
                sos.write(bis.read());
            }
            sos.flush();
            sos.close();
            bis.close();
            fis.close();
        } catch (Exception ex) {
            PrintWriter out = response.getWriter();
            out.println("오류 발생: " + ex.getMessage());
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
