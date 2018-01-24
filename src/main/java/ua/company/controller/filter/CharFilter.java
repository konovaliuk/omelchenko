package ua.company.controller.filter;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.*;
import java.io.IOException;

/**
 * CharFilter.java - filter which set up default encoding.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 06.01.2018
 */
public class CharFilter implements Filter {
    private static final Logger LOGGER = MyLogger.getLOGGER(CharFilter.class);
    private String encoding;
    private String appEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Receive from current encoding and if it is differ from default set up
     * default encoding.
     *
     * @param servletRequest data received from servlet
     * @param servletResponse data received from servlet
     * @param filterChain invoke the resource at the end of the chain.
     * @throws IOException if stream cannot be written to or closed.
     * @throws ServletException if errors are occurred in servlet.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("Read encoding from request.");
        encoding = servletRequest.getCharacterEncoding();
        LOGGER.info("Current encoding: " + encoding);
        appEncoding = AppManager.getInstance().getProperty(AppManager.getENCODING());
        LOGGER.info("Encoding from properties: " + appEncoding);
        if (!appEncoding.equalsIgnoreCase(encoding)){
            LOGGER.info("Encodings are not equals. Set encoding: " + appEncoding);
            servletRequest.setCharacterEncoding(appEncoding);
            servletResponse.setCharacterEncoding(appEncoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
