package br.com.desafiodio.gof.utils;

import org.apache.commons.lang3.StringUtils;

public class Utils {

    /**
     * @param zipcode
     * @apiNote [^0-9]+ ou \\D, Esse regex representa tudo o que não for um número de 0 a 9.
     * @apiNote StringUtils é mais performatico do que o replace do String do java.
     * */
    public static String removeCharacterEspecialZipcode(String zipcode){
        return StringUtils.replace(zipcode, "\\D","");
    }
}
