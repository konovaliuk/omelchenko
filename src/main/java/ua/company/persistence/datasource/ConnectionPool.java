package ua.company.persistence.datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DataSource.java - class which implements connection to Database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class ConnectionPool {

    //private static final Logger logger = Logger.getLogger(DataSource.class);
    private static ConnectionPool connectionPool = null;
    private static Connection connection;
    private List <Connection> availableConnections = new ArrayList();

    private ConnectionPool() {
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        try {
            availableConnections.add(createNewConnection().getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public static DataSource createNewConnection() {
        DataSource ds=null;
        try {
//            Hashtable env = new Hashtable();
//            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
//            env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");

                Context ctx = new InitialContext();
            if (ctx == null)
            {
                throw new Exception("No context!");
            }
//            Context envContext = (Context) ctx.lookup("java:comp/env");
//            ds = (DataSource) envContext.lookup("jdbc/QuizSystem");

            ds = (DataSource) ctx.lookup("java:global/env/jdbc/QuizSystem");

                if (ds == null) {
                    throw new Exception("Data source not found!");
                }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public Connection getConnection()
    {
        if(availableConnections.size() > 0)
        {
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }else {
            initializeConnectionPool();
            connection = availableConnections.get(0);
            availableConnections.remove(0);
        }
//        System.out.println(connection);
        return connection;
        //может вернуть null???
    }

    public void close() {
        if (connection != null) {
            availableConnections.add(connection);
        }
    }
}
