/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class Conexao {
    private final String URL = "jdbc:mysql://localhost:3306/rjml";
    private final String USER = "root";
    private final String PASS = "123456";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private Connection connection = null;
    
    public Connection openConection(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro, Banco desconectado ou dados Incorretos!", "Error", JOptionPane.WARNING_MESSAGE);
            connection = null;
        }
        
        return connection;
    }
    
    public void closeConnection(Connection connection){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar Conexão", "Error", JOptionPane.WARNING_MESSAGE);
            }finally{
                connection = null;
            }
        }
    }
}
