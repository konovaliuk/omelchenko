package ua.company.service.taglib;

import org.apache.log4j.Logger;
import ua.company.persistence.domain.User;
import ua.company.service.logger.MyLogger;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * AccessTag.java - class describe custom tag.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 08.01.2018
 */
public class AccessTag extends TagSupport {
    private static final Logger LOGGER = MyLogger.getLOGGER(AccessTag.class);

    /**
     * Create custom tag for access to part of jsp page
     *
     * @return 0 or 1 which mean skip or include body of custom tag
     */
    @Override
    public int doStartTag() {
        HttpSession session = pageContext.getSession();
        User user = (User) session.getAttribute("user");
        LOGGER.info("Customer tag");
        if (user == null) {
            return EVAL_BODY_INCLUDE;
        } else if (!user.isAccess()) {
            LOGGER.info("User access: " + user.isAccess());
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }
}
