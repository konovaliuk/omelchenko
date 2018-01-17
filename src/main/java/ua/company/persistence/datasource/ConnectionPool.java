package ua.company.persistence.datasource;

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

    private static final String RES_NAME = "java:comp/env/jdbc/quizsystem";
    private static DataSource dataSource;
    private static ConnectionPool connectionPool = null;
    private Connection connection;

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
                e.printStackTrace();
            }
        }
    }

    public static synchronized ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        return connection;
    }

    public void beginTransaction() {
        try {
            getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
