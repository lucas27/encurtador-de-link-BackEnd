package com.encurtador.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encurtador.database.model.EncurtadorDeLinkEntity;
import com.encurtador.database.repositories.EncurtadorDeLinkRepositories;

@Service
public class EncurtadorDeLinkService {

    @Autowired
    EncurtadorDeLinkRepositories repositories;
    
    public EncurtadorDeLinkEntity link(String urlOriginal) {
        if(urlOriginal == null || urlOriginal.isEmpty()) {
            throw new IllegalArgumentException("URL original não pode ser nula ou vazia");
        }

        String geradorDeId = UUID.randomUUID().toString().substring(0, 6);

        EncurtadorDeLinkEntity encurtador = new EncurtadorDeLinkEntity();
        encurtador.setUrl_original(urlOriginal);
        encurtador.setUrl_encurtada(geradorDeId);
        
        return repositories.save(encurtador);
    }

    public String buscarCodigo(String codigo) {
        return repositories.findLinkLongo(codigo);
    }
}
