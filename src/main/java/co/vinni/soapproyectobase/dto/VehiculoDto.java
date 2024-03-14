package co.vinni.soapproyectobase.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehiculoDto {
    private long serial;

    @NotBlank(message = "La marca del vehículo es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo del vehículo es obligatorio")
    private String modelo;
    @NotBlank(message = "El anio del vehículo es obligatorio")
    private int anio;


}