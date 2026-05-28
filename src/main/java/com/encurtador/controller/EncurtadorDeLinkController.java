package com.encurtador.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encurtador.database.model.EncurtadorDeLinkEntity;
import com.encurtador.database.repositories.EncurtadorDeLinkRepositories;
import com.encurtador.dtos.EncurtadorDto;
import com.encurtador.service.EncurtadorDeLinkService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/app/link")
public class EncurtadorDeLinkController {
    
    private final EncurtadorDeLinkService service;

    public EncurtadorDeLinkController(EncurtadorDeLinkService service) {
        this.service = service;
    }

    @PostMapping("/url")
    public String encurtarLink(@RequestBody EncurtadorDto dto) {
        EncurtadorDeLinkEntity encurtador = service.link(dto.urlOriginal());
        String url = "http://localhost:8080/app/link/" + encurtador.getUrlEncurtada();

        return url;
    }

    @GetMapping("/{codigo}")
    public void obterLink(@PathVariable("codigo") String codigo, HttpServletResponse response) throws IOException{
        response.sendRedirect(service.buscarCodigo(codigo));
    }
}
