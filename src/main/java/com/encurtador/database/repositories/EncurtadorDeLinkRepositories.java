package com.encurtador.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encurtador.database.model.EncurtadorDeLinkEntity;

public interface EncurtadorDeLinkRepositories extends JpaRepository<EncurtadorDeLinkEntity, String> {

    // Optional<EncurtadorDeLinkEntity> findByUrlEncurtada(String urlEncurtada);

    @Query("SELECT e.url_original FROM EncurtadorDeLinkEntity e WHERE e.url_encurtada = :url_encurtada")
    String findLinkLongo(String url_encurtada);
}
