package ua.company.persistence.datasource;

import org.apache.log4j.Logger;
import ua.company.service.logger.MyLogger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * DataSource.java - class which implements connection to Database.
 *
 * @author Ruslan Omelchenko
 * @version 1.0 28 Dec 2017
 */
public class ConnectionPool {
    private static final Logger LOGGER = MyLogger.getLOGGER(ConnectionPool.class);
    private static final String RES_NAME = "java:comp/env/jdbc/quizsystem";
    private static DataSource dataSource;
    private static ConnectionPool connectionPool = null;
    private Connection connection;

    /**
     * Private constructor - creation new object of class {@link ConnectionPool}
     */
    private ConnectionPool() {
    }

    static {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup(RES_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        if (dataSource==null){
            try {
                throw new Exception("Datasource not found");
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * Create object of ConnectionPool class.
     *
     * @return instance of ConnectionPool class.
     */
    public static synchronized ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    /**
     * Create connection from ConnectionPool.
     *
     * @throws SQLException if errors concerning work with database are occurred.
     * @return connection to database.
     */
    public synchronized Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    /**
     * Begin transaction in database.
     */
    public void beginTransaction() {
        try {
            getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
    }

    /**
     * Commit transaction to database.
     */
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("There is no connection with database: ", e);
        }
    }

    /**
     * Close connection to database.
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Connection was not closed: ", e);
        }
    }
}
