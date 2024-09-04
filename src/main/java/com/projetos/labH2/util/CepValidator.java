package com.projetos.labH2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator {
    private static final String CEP_REGEX = "^[0-9]{5}-[0-9]{3}$";
    private static final Pattern pattern = Pattern.compile(CEP_REGEX);

    public static boolean isValidCep(String cep) {
        if (cep == null){
            return false;
        }
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }
}
