package br.com.fiap.residex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_caminhao")
public class Caminhao {

    @Id
    @GeneratedValue(
            generator = "seq_caminhao",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_caminhao",
            sequenceName = "seq_caminhao",
            allocationSize = 1
    )
    @Column(name = "id_caminhao")
    private Long idCaminhao;

    private String modelo;

    private String placa;

    @Embedded
    private Coordenada coordenada;

    @JoinColumn(
            name = "id_status",
            referencedColumnName = "id_status"
    )
    @ManyToOne
    private Status status;

    @JoinColumn(
            name = "id_empresa",
            referencedColumnName = "id_empresa"
    )
    @ManyToOne
    @JsonIgnore
    private Empresa empresa;
}
