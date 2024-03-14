package co.vinni.soapproyectobase.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Vehiculo")
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEHICULOS")
    @SequenceGenerator(name = "SEQ_VEHICULOS", sequenceName = "SEQ_VEHICULOS", allocationSize = 1)
    @Column(name = "VEH_CODIGO", nullable = false)
    private long codigo;

    @Column(name = "VEH_MARCA", nullable = false)
    private String marca;

    @Column(name = "VEH_MODELO", nullable = false)
    private String modelo;

    @Column(name = "VEH_ANIO", nullable = false)
    private int anio;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Impuesto> impuestos;


}
