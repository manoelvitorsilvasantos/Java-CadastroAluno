/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.utils;



/**
 *
 * @author mvictor
 * @param <T>
 */
public abstract class ValidatorAbstract <T>{
    
    public String removeDotsOnlyNumbers(String campo){
        if(campo == null){
            return null;
        }
        return campo.replaceAll("[^0-9]+", "");
    }
    
    public boolean validarCPF(String cpf) {
        // remover caracteres não-numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
    
        // verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
    
        // calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int resto = (soma * 10) % 11;
        int digito1 = (resto == 10 ? 0 : resto);
    
        // calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        resto = (soma * 10) % 11;
        int digito2 = (resto == 10 ? 0 : resto);
        // verificar se os dígitos verificadores estão corretos
        return (cpf.charAt(9) - '0' == digito1 && cpf.charAt(10) - '0' == digito2);
    }
    public boolean isValid(String objeto){
        return objeto.isEmpty() && objeto.trim() != null;
    }
    
    public abstract boolean isNotValid(T entity);
    public abstract boolean isValid(T entity);
    
}
