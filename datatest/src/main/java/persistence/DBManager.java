/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thomas
 */
public class DBManager {

    private static final String DB_URL = "jdbc:mysql://192.168.1.152/NurZumTest";
    private static final String DB_USR = "Thomas";     //Thomas@localhost
    private static final String DB_PAS = "C@mbiderm1983";
    private static final DBManager instance = new DBManager();
    private Connection dbConnection;

    private DBManager() {
	}

    public static DBManager getInstance() {
	return instance;
    }

    public Connection getConnection() throws SQLException {
	if (dbConnection == null) {
            dbConnection = DriverManager.getConnection(DB_URL, DB_USR, DB_PAS);
            createTables();
	}

	return dbConnection;
    }

    public void close() {
	try {
            if (dbConnection != null) {
		dbConnection.close();
		dbConnection = null;
            }
	} catch (SQLException e) {
            System.out.println("Exception:: " + e);
	}
    }

    private void createTables() {
	createTestTable();
    }

    private void createTestTable() {
	try (Statement sqlStatement = dbConnection.createStatement()) {

            String sqlCommand = "CREATE TABLE IF NOT EXISTS Test ("
                    + "id INT auto_increment, "
		+ "nachname VARCHAR(40), "
		+ "vorname VARCHAR(40), "
		+ "PRIMARY KEY (id))"
		+ "CHARACTER SET utf8 COLLATE utf8_unicode_ci";

            sqlStatement.executeUpdate(sqlCommand);
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
}
