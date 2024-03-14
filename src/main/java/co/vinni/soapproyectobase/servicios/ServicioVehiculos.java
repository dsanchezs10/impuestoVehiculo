package co.vinni.soapproyectobase.servicios;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.entidades.Vehiculo;
import co.vinni.soapproyectobase.exception.ResourceNotFoundException;
import co.vinni.soapproyectobase.repositorios.RepositorioVehiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServicioVehiculos {

    private final ModelMapper modelMapper;
    private final RepositorioVehiculo repoVehiculo;

    public VehiculoDto registrar(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = repoVehiculo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
        return modelMapper.map(vehiculo, VehiculoDto.class);
    }

    public List<VehiculoDto> obtenerVehiculos() {
        return modelMapper.map(repoVehiculo.findAll(), new TypeToken<List<VehiculoDto>>() {}.getType());
    }

    public VehiculoDto obtenerVehiculo(long serial) {
        Vehiculo vehiculo = repoVehiculo.findById(serial)
                .orElseThrow(ResourceNotFoundException::new);
        return modelMapper.map(vehiculo, VehiculoDto.class);
    }

    public VehiculoDto actualizar(VehiculoDto vehiculoDto) {
        repoVehiculo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
        return vehiculoDto;
    }

    public void eliminar(long serial) {
        repoVehiculo.deleteById(serial);
    }
}
