/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import static java.rmi.server.LogStream.log;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MASTER
 */
public class Upper2LowerFilter implements Filter {
    
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;
    
    public Upper2LowerFilter(){
        
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("Upper2LowerFilter:Initializing filter");
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (debug) {
            log("Upper2LowerFilter:doFilter()");
        }
        
        LowerCaseResponseWrapper myResponse = new LowerCaseResponseWrapper((HttpServletResponse) response);
        
        Throwable problem = null;
        
        try {
            chain.doFilter(request, myResponse);
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }
}
