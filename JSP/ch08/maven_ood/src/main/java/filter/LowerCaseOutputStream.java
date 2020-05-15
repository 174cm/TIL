/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 *
 * @author MASTER
 */
class LowerCaseOutputStream extends ServletOutputStream {

    private ServletOutputStream mSos = null;
    
    public LowerCaseOutputStream(ServletOutputStream sos) {
        mSos = sos;
    }
    
    @Override
    public void write(int b) throws IOException {
        int c = (b == -1) ? b : Character.toLowerCase(b);
        mSos.write(c);
    }

    @Override
    public boolean isReady() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
