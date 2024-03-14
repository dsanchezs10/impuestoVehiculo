package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.servicios.ServicioVehiculos;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class ControladorVehiculos {
    private static final Logger logger = LogManager.getLogger(ControladorVehiculos.class);

    @Autowired
    ServicioVehiculos servicioVehiculos;

    @GetMapping("/vehiculos")
    public String listarVehiculos(Model model){
        logger.info("Listando vehículos");
        model.addAttribute("vehiculos", servicioVehiculos.obtenerVehiculos());
        return "vehiculos"; // Devuelve el nombre de la vista para mostrar los vehículos
    }

    @GetMapping("/vehiculos/nuevo")
    public String mostrarFormulario(Model model){
        VehiculoDto vehiculoDto = new VehiculoDto();
        model.addAttribute("vehiculo", vehiculoDto);
        return "crear_vehiculo"; // Devuelve el nombre de la vista para crear un nuevo vehículo
    }

    @PostMapping("/vehiculos")
    public String registrarVehiculo(@ModelAttribute("vehiculo") VehiculoDto vehiculoDto) {
        servicioVehiculos.registrar(vehiculoDto);
        return "redirect:/vehiculos"; // Redirige a la página de listado de vehículos después de registrar uno nuevo
    }

    @GetMapping("/vehiculos/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        VehiculoDto vehiculoDto = servicioVehiculos.obtenerVehiculo(serial);
        model.addAttribute("vehiculo", vehiculoDto);
        return "editar_vehiculo"; // Devuelve el nombre de la vista para editar un vehículo existente
    }

    @PostMapping("/vehiculos/{serial}")
    public String modificarVehiculo(@PathVariable long serial, @ModelAttribute("vehiculo") VehiculoDto vehiculoDto) {
        servicioVehiculos.actualizar(vehiculoDto);
        return "redirect:/vehiculos"; // Redirige a la página de listado de vehículos después de modificar uno
    }

    @GetMapping("/vehiculos/{serial}")
    public String eliminarVehiculo(@PathVariable long serial) {
        servicioVehiculos.eliminar(serial);
        return "redirect:/vehiculos"; // Redirige a la página de listado de vehículos después de eliminar uno
    }
}


