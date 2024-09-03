package in.fl.los.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.fl.los.model.Registry;

/**
 * JPA repository class for lms_registry table Consists of queries to access the
 * table
 * 
 * @author Ashwin Kumar V
 *
 */
@Repository("RegistryRepository")
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

	public Registry findByconfigKey(String configKey);
}
