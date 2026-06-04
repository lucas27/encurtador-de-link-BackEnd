package com.encurtador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.encurtador.database.model.EncurtadorDeLinkEntity;
import com.encurtador.database.repositories.EncurtadorDeLinkRepositories;
import com.encurtador.service.EncurtadorDeLinkService;

@ExtendWith(MockitoExtension.class)
public class EncurtadorDeLinkServiceTeste {
    
    EncurtadorDeLinkEntity entidadeSimulada = new EncurtadorDeLinkEntity();
    
    @InjectMocks
    private EncurtadorDeLinkService encurtadorDeLinkService;
    
    @Mock
    private EncurtadorDeLinkRepositories encurtadorDeLinkRepositories;

    @Test
    public void testeAdicionarLink() {
        // Arrange
        String urlOriginalTeste = "www.google.com";

        entidadeSimulada.setUrl_original(urlOriginalTeste);
        entidadeSimulada.setUrl_encurtada("abc123");

        // Mock do comportamento do repositório para retornar a entidade simulada
        // ele ensina o que ele deve retornar quando o método save for chamado com qualquer objeto do tipo EncurtadorDeLinkEntity
        when(encurtadorDeLinkRepositories.save(any(EncurtadorDeLinkEntity.class))).thenReturn(entidadeSimulada);

        // Act
        EncurtadorDeLinkEntity resultado = encurtadorDeLinkService.link(urlOriginalTeste);

        // Assert
        assertNotNull(resultado);
        assertEquals(urlOriginalTeste, resultado.getUrl_original());
        assertEquals("abc123", resultado.getUrl_encurtada());
        assertNotNull(resultado.getUrl_encurtada());
        assertEquals(6, resultado.getUrl_encurtada().length());
    }

    @Test
    public void testeBuscarCodigo() {
        // Arrange
        String codigoTeste = "abc123";
        String urlOriginalEsperada = "www.google.com";

        when(encurtadorDeLinkRepositories.findLinkLongo(codigoTeste)).thenReturn(urlOriginalEsperada);

        // Act
        String resultado = encurtadorDeLinkService.buscarCodigo(codigoTeste);

        // Assert
        assertNotNull(resultado);
        assertEquals(urlOriginalEsperada, resultado);
    }

}
