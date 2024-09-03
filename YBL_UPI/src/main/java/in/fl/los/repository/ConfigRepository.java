package in.fl.los.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.fl.los.model.ConfigDetails;

/**
 * config_details table repository interface
 *
 * @author ragavan 21-May-2019
 * @version 1
 */
@Repository
public interface ConfigRepository extends JpaRepository<ConfigDetails, Integer> {

	public ConfigDetails findByconfigKey(String configKey);

}
