/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.view.table;

import br.cadastro.app.connect.ConnectionFactory;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mvictor
 */
public final class QueryTableModel extends AbstractTableModel implements QueryTableModelInterface{
    
    private ArrayList<Object[]> linhas;
    private String[] colunas;
    private Statement stmt;
    private String query;
    
    public QueryTableModel(String query, String cols[]){
        colunas = cols;
        try{
            stmt = ConnectionFactory.criarConexao().createStatement();
            this.query = query;
            linhas = new ArrayList<>();
            loadData();
        }catch(SQLException e){
            System.out.println("QueryTableModel["+ e.toString() +"]");
        }
    }
    
    @Override
    public void loadData() {
        System.out.println("QueryTableModel[loadData()]");
        try(ResultSet rs = stmt.executeQuery(query)){
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            linhas.clear();
            while(rs.next()){
                Object l[] = new Object[numCols];
                for(int i = 0; i < numCols; i++){
                    l[i] = rs.getObject(i+1);
                }
                linhas.add(l);
            }
            fireTableDataChanged();
        } catch (SQLException ex) {
            System.out.println("QueryTableModel["+ex.toString()+"]");
        }
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rows, int cols) {
        try{
            Object l[] = linhas.get(rows);
            return l[cols];
        }
        catch(Exception e){
            System.out.println("QueryTableModel["+e.toString()+"]");
        }
        return null;
    } 

    @Override
    public void updateTable() {
        fireTableDataChanged();
    }
}
