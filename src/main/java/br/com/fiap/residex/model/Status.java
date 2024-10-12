package br.com.fiap.residex.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_status")
public class Status {

    @Id
    @GeneratedValue(
            generator = "seq_status",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "seq_status",
            sequenceName = "seq_status",
            allocationSize = 1
    )
    @Column(name = "id_status")
    private Long idStatus;

    @Column(name = "descricao_status")
    private String descricaoStatus;
}
