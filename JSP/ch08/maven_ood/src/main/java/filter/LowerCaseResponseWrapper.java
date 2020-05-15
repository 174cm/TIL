/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author MASTER
 */
class LowerCaseResponseWrapper extends HttpServletResponseWrapper{
    
    public LowerCaseResponseWrapper(HttpServletResponse response) {
        super(response);
    }
    
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        LowerCaseOutputStream los = new LowerCaseOutputStream(getResponse().getOutputStream());
        
        return los;
    }


}
