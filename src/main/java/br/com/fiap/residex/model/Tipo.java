package br.com.fiap.residex.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Component
@Entity(name = "t_tipo")
public class Tipo {

    @Id
    @SequenceGenerator(
            name = "seq_tipo",
            sequenceName = "seq_tipo",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "seq_tipo",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "descricao_tipo")
    private String descricaoTipo;

    @OneToMany(mappedBy = "tipo")
    private List<Item> items;

    @OneToMany(mappedBy = "tipo")
    private List<Recipiente> recipientes;
}
