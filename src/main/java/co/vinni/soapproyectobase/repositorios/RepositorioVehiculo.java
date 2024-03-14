package co.vinni.soapproyectobase.repositorios;

import co.vinni.soapproyectobase.entidades.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RepositorioVehiculo extends JpaRepository<Vehiculo, Long>, JpaSpecificationExecutor<Vehiculo> {
    // No es necesario definir métodos aquí, ya que JpaRepository proporciona métodos CRUD básicos
}

