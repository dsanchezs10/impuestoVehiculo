package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.ImpuestoDto;
import co.vinni.soapproyectobase.entidades.Impuesto;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioImpuesto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioImpuestos {

    private final ModelMapper modelMapper;
    private final RepositorioImpuesto repoImpuesto;

    public ServicioImpuestos(ModelMapper modelMapper, RepositorioImpuesto repoImpuesto) {
        this.modelMapper = modelMapper;
        this.repoImpuesto = repoImpuesto;
    }

    public ImpuestoDto crearImpuesto(ImpuestoDto impuestoDto) {
        Impuesto impuesto = new Impuesto();
        impuesto.setMonto(impuestoDto.getMonto());
        impuesto.setVehiculo(impuestoDto.getVehiculo());


        repoImpuesto.save(impuesto);

        return modelMapper.map(impuesto, ImpuestoDto.class);
    }

    public ImpuestoDto obtenerImpuestoPorId(long id) {
        Impuesto impuesto = repoImpuesto.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return modelMapper.map(impuesto, ImpuestoDto.class);
    }

    public ImpuestoDto actualizarImpuesto(ImpuestoDto impuestoDto) {
        Impuesto impuesto = repoImpuesto.findById(impuestoDto.getSerial())
                .orElseThrow(ResourceNotFoundException::new);

        impuesto.setMonto(impuestoDto.getMonto());
        // Puedes actualizar más propiedades del impuesto según sea necesario

        repoImpuesto.save(impuesto);

        return modelMapper.map(impuesto, ImpuestoDto.class);
    }

    public void eliminarImpuesto(long serial) {
        Impuesto impuesto = repoImpuesto.findById(serial)
                .orElseThrow(ResourceNotFoundException::new);

        repoImpuesto.delete(impuesto);
    }

    public List<ImpuestoDto> obtenerTodosImpuestos() {
        List<Impuesto> impuestos = repoImpuesto.findAll();
        return modelMapper.map(impuestos, new TypeToken<List<ImpuestoDto>>() {}.getType());
    }
}
