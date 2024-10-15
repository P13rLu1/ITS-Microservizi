package it.apuliadigital.esercizio05anagraficaclient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public class NumeriTelefoniciMapper {

    //conversione da stringa a mappa
    @Named("stringToMap")
    public Map<String, String> stringToMap(String numeriTelefonici){
        Map<String, String> mappaNumeri = new HashMap<>();
        if (numeriTelefonici != null && !numeriTelefonici.isEmpty()){
            String[] coppie = numeriTelefonici.split(", ");
            for (String coppia: coppie){
                String[] entry = coppia.split(": ");
                if (entry.length == 2){
                    mappaNumeri.put(entry[0].trim(), entry[1].trim());
                }
            }
        }
        return mappaNumeri;
    }

    //conversione da mappa a stringa bravo, gigi
    @Named("mapToString")
    public String mapToString(Map<String, String> numeriTelefonici){
        StringBuilder stringaNumeri = new StringBuilder();
        for (Map.Entry<String, String> entry: numeriTelefonici.entrySet()){
            if (!stringaNumeri.isEmpty()){
                stringaNumeri.append(", ");
            }
            stringaNumeri.append(entry.getKey()).append(": ").append(entry.getValue());
        }
        return stringaNumeri.toString();
    }
}
