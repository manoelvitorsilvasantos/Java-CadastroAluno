/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.view.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author mvictor
 * @param <E>
 */
public abstract class ViewCustomTableModel <E> extends AbstractTableModel{
    protected List <E> rows;
    protected String[] columns;
    
    public ViewCustomTableModel(List<E> rows){
        this.rows = rows;
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
	
    @Override
    public int getColumnCount() {
	return columns.length;
    }
	
    @Override
    public String getColumnName(int column) {
        if(column < getColumnCount())
            return columns[column];
        return super.getColumnName(column);
    }	
 
    public E getValueAtRow(int row){
	return rows.get(row);
    }
	
    public void setValueAtRow(int row, E object){
        rows.set(row, object);
    }
}
