package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Impuesto;
import co.vinni.soapproyectobase.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioImpuesto extends JpaRepository<Impuesto, Long> {
    List<Impuesto> findByVehiculo(Vehiculo vehiculo);
}
