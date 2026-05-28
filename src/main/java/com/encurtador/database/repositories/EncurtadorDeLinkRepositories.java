package com.encurtador.database.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encurtador.database.model.EncurtadorDeLinkEntity;

public interface EncurtadorDeLinkRepositories extends JpaRepository<EncurtadorDeLinkEntity, String> {

    // Optional<EncurtadorDeLinkEntity> findByUrlEncurtada(String urlEncurtada);

    @Query("SELECT e.urlOriginal FROM EncurtadorDeLinkEntity e WHERE e.urlEncurtada = :urlEncurtada")
    String findLinkLongo(String urlEncurtada);
}
