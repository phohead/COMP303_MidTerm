package com.example.WilsonYang_MidtermTest_COMP303;

import com.example.WilsonYang_MidtermTest_COMP303.entity.Sensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends CrudRepository<Sensor, Long> {
	
}
