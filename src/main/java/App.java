import ua.company.service.service.AuthServiceImpl;

/**
 * App.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 17.12.2017
 */
public class App {
    public static void main(String[] args) {
        //Checking log file - success
//        Logger LOGGER = MyLogger.getLOGGER(App.class);
//        LOGGER.info("Page was updated.");

//        IUser iUser = DaoFactory.getIUser();
//        User user = iUser.getUserByLoginAndPass("admin", "rosronaldo");
//        System.out.println(user);

        AuthServiceImpl a = new AuthServiceImpl();
        a.registration("Omelchenko", "omelchenko@gmail.com", "Rosronaldo1", "Ukraine", "mail");

        //Checking resource bundle - success
//        ConfigManager.getInstance().getProperty(ConfigManager.getLOGIN());


    }
}
