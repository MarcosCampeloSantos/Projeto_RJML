/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.Produtos;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marco
 */
public class EstoqueController {
    Produtos ProdutoBD = new Produtos();
    
    ResultSet Resultado;
    
    public void preencherDados(DefaultTableModel Tabela){
        try {
            Resultado = ProdutoBD.AllSearch();
            while(Resultado.next()){
                Object[] dados = {
                    Resultado.getInt("ID"),
                    Resultado.getString("PRODUTO"),
                    Resultado.getInt("ESTOQUE")
                };
                
                Tabela.addRow(dados);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao orgarnizar dados", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void alterarEstoque(int ID ,int Estoque){
        ProdutoBD.insertEstoque(ID, Estoque);
    }
    
    public void excluirEstoque(int ID){
        ProdutoBD.dropProduto(ID);
    }
}
