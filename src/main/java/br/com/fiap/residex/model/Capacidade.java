package br.com.fiap.residex.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Capacidade {

    @Column(name = "capacidade_maxima")
    private double capacidadeMaxima;

    @Column(name = "capacidade_atual")
    private double Atual;
}
