package akkocdesign.hrms.business.abstracts;

import java.util.List;

import akkocdesign.hrms.core.utilities.results.DataResult;
import akkocdesign.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
