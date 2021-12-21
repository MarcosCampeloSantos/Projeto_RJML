/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class Produtos {
    Conexao Conexao = new Conexao();
    
    private String query;
        
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public void create(String Nome, int Estoque){
        query = "INSERT INTO rjml.produtos (PRODUTO, ESTOQUE) VALUES (?, ?)";
        connection = Conexao.openConection();
        
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1 , Nome);
            statement.setInt(2, Estoque);
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Produto Gravado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar Produto", "Error", JOptionPane.ERROR_MESSAGE);;
        }finally{
            Conexao.closeConnection(connection);
        }
    }
    
    public ResultSet AllSearch(){
        query = "SELECT * FROM rjml.produtos";
        connection = Conexao.openConection();
        
        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Estoque!", "Error", JOptionPane.WARNING_MESSAGE);
            result = null;
        }
        
        return result;
    }
    
    public void insertEstoque(int ID, int Estoque){
        query = "UPDATE rjml.produtos SET ESTOQUE = (?) WHERE (`ID` = "+ID+")";
        connection = Conexao.openConection();
        
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1 , Estoque);
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Estoque alterado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar o Estoque!", "Error", JOptionPane.WARNING_MESSAGE);
        }finally{
            Conexao.closeConnection(connection);
        }
    }
    
    public void dropProduto(int ID){
        query = "DELETE FROM rjml.produtos WHERE (`ID` = "+ID+")";
        connection = Conexao.openConection();
        
        try {
            statement = connection.prepareStatement(query);
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Arquivo Deletado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar Produto!", "Error", JOptionPane.WARNING_MESSAGE);
        }finally{
            Conexao.closeConnection(connection);
        }
    }
}
