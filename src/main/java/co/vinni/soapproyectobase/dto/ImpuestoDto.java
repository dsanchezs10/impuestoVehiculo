package co.vinni.soapproyectobase.dto;

import co.vinni.soapproyectobase.entidades.Vehiculo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImpuestoDto {
    @NotBlank(message = "La serial  es obligatoria")
    private long serial;
    @NotBlank(message = "El vehículo es obligatorio")
    private Vehiculo vehiculo;
    @NotBlank(message = "El monto es obligatorio")
    private double monto;
}

