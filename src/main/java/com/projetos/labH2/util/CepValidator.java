package com.projetos.labH2.util;

import com.projetos.labH2.advice.exceptions.InvalidCepException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator {
    private static final String CEP_REGEX = "^\\d{8}$";
    private static final Pattern pattern = Pattern.compile(CEP_REGEX);

    public static boolean isValidCep(String cep) {
        if (cep == null){
            return false;
        }
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }

    // Método para validar o formato do CEP
    public static void validarCep(String cep){
        if(!isValidCep(cep)){
            throw new InvalidCepException("Formato do Cep é inválido");
        }
    }

    public static String formatCep(String cep){
        if(cep == null || cep.length() != 8) {
            throw new InvalidCepException("Formato do Cep é inválido. O CEP deve conter exatamente 8 caracteres.");
        }
        return cep.substring(0,5) + "-" + cep.substring(5);
    }
}
