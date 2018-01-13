package ua.company.controller.filter;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.service.logger.MyLogger;

import javax.servlet.*;
import java.io.IOException;

/**
 * CharFilter.java -
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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOGGER.info("Read encoding from request.");
        encoding = servletRequest.getCharacterEncoding();
        LOGGER.info("Set up necessary encoding.");
        appEncoding = AppManager.getInstance().getProperty(AppManager.getENCODING());
        if (!appEncoding.equalsIgnoreCase(encoding)){
            servletResponse.setCharacterEncoding(appEncoding);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
