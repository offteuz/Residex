package br.com.fiap.residex.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(
            generator = "seq_notificacao",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_notificacao",
            sequenceName = "seq_notificacao",
            allocationSize = 1
    )
    @Column(name = "id_notificacao")
    private Long idNotificacao;

    @Column(name = "descricao_notificacao")
    private String descricaoNotificacao;

    @Column(name = "data_coleta")
    private LocalDate dataColeta;

    @JoinColumn(
            name = "id_morador",
            referencedColumnName = "id_morador"
    )
    @ManyToOne
    private Morador morador;

    @JoinColumn(
            name = "id_recipiente",
            referencedColumnName = "id_recipiente"
    )
    @ManyToOne
    private Recipiente recipiente;
}
