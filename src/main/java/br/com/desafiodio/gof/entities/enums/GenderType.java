package br.com.desafiodio.gof.entities.enums;

import java.util.Arrays;

public enum GenderType {
    MASCULINE,
    FEMININE,
    UNDEFINED;

    public static GenderType getGenderType(String genderType){
        return Arrays.stream(GenderType.values()).filter(g -> g.name().equalsIgnoreCase(genderType)).findFirst().orElseGet(() -> GenderType.UNDEFINED);
    }

}
