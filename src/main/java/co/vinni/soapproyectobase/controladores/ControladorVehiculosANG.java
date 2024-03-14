package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.servicios.ServicioVehiculos;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ControladorVehiculosANG {
    private static final Logger logger = LogManager.getLogger(ControladorVehiculosANG.class);

    private final ServicioVehiculos servicioVehiculos;

    @GetMapping("/")
    public ResponseEntity<List<VehiculoDto>> listarVehiculos() {
        return ResponseEntity.ok(servicioVehiculos.obtenerVehiculos());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<VehiculoDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info("Ingresando serial: " + serial);
        return ResponseEntity.ok(servicioVehiculos.obtenerVehiculo(serial));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VehiculoDto> crear(@Validated @RequestBody VehiculoDto vehiculoDto) {
        vehiculoDto = servicioVehiculos.registrar(vehiculoDto);
        return new ResponseEntity<>(vehiculoDto, HttpStatus.CREATED);
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<VehiculoDto> modificar(@Validated @RequestBody VehiculoDto vehiculoDto) {
        vehiculoDto = servicioVehiculos.actualizar(vehiculoDto);
        return new ResponseEntity<>(vehiculoDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {
        servicioVehiculos.eliminar(serial);
    }
}
