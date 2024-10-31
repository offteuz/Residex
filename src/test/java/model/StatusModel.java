package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class StatusModel {
    @Expose
    private Long idStatus;

    @Expose
    private String descricaoStatus;
}
