package com.projetos.labH2.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatDateUtil {
    private static final DateTimeFormatter FORMATO_DDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_YYYYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Converte uma data no formato dd/MM/yyyy para yyyy-MM-dd.
     *
     * @param data Data no formato dd/MM/yyyy
     * @return Data no formato yyyy-MM-dd
     * @throws DateTimeParseException se a data estiver em um formato inválido
     */

    public static String converterParaFormatoYYYYMMDD(String data){
        LocalDate dataConvertida = LocalDate.parse(data, FORMATO_DDMMYYYY);
        return dataConvertida.format(FORMATO_YYYYMMDD);
    }

    /**
     * Converte uma data no formato yyyy-MM-dd para dd/MM/yyyy.
     *
     * @param data Data no formato yyyy-MM-dd
     * @return Data no formato dd/MM/yyyy
     * @throws DateTimeParseException se a data estiver em um formato inválido
     */

    public static String converterParaFormatoDDMMYYYY(String data) {
        LocalDate dataConvertida = LocalDate.parse(data, FORMATO_YYYYMMDD);
        return dataConvertida.format(FORMATO_DDMMYYYY);
    }
}
