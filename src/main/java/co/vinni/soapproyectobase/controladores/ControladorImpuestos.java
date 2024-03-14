package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.ImpuestoDto;
import co.vinni.soapproyectobase.servicios.ServicioImpuestos;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/impuestos")
public class ControladorImpuestos {

    @Autowired
    private ServicioImpuestos servicioImpuestos;

    @GetMapping
    public String listarImpuestos(Model model) {
        List<ImpuestoDto> impuestos = servicioImpuestos.obtenerTodosImpuestos();
        model.addAttribute("impuestos", impuestos);
        return "impuestos/lista"; // Devuelve el nombre de la vista para mostrar la lista de impuestos
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        ImpuestoDto impuestoDto = new ImpuestoDto();
        model.addAttribute("impuesto", impuestoDto);
        return "impuestos/nuevo"; // Devuelve el nombre de la vista para crear un nuevo impuesto
    }

    @PostMapping
    public String registrarImpuesto(@ModelAttribute("impuesto") ImpuestoDto impuestoDto) {
        servicioImpuestos.crearImpuesto(impuestoDto);
        return "redirect:/impuestos"; // Redirige a la página de listado de impuestos después de registrar uno nuevo
    }

    // Otros métodos para editar, eliminar, ver detalles, etc.
}