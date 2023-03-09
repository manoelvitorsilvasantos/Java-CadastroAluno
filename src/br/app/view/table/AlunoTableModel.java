/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.view.table;

import java.util.List;

/**
 *
 * @author mvictor
 */
public class AlunoTableModel extends ViewCustomTableModel <DadosPessoais>{
    
    public AlunoTableModel(List<DadosPessoais> rows, String colunas[]){
        super(rows);
        columns = colunas;
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        DadosPessoais dp = rows.get(col);
        switch(col){
            case 0:
                return dp.getId();
            case 1:
                return dp.getNome();
            case 2:
                return dp.getCpf();
            case 3:
                return dp.getCelular();
            case 4:
                return dp.getEmail();
            default:
                return null;
        }
    }
    
}
