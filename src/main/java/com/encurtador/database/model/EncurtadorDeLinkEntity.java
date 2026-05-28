package com.encurtador.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "encurtador_link")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EncurtadorDeLinkEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private java.util.UUID id;

    private String urlOriginal;
    private String urlEncurtada;

    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP")
    private java.time.LocalDateTime dataCriacao;

}
