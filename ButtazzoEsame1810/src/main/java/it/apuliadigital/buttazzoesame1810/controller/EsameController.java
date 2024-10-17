package it.apuliadigital.buttazzoesame1810.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsameController { //implements EsameApi

    Logger logger = LoggerFactory.getLogger(EsameController.class);

//    @Autowired
//    private EsameService esameservice;

    @GetMapping("/esame")
    public String getEsame() {
        logger.info("Esame recuperato con successo");
        return "Esame";
    }
}
