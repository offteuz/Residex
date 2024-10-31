package model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class CoordenadaModel {
    @Expose
    private double latitude;

    @Expose
    private double longitude;
}

