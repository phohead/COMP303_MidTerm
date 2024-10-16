package com.example.WilsonYang_MidtermTest_COMP303.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Sensor")
public class Sensor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sensorID;
	
	@NotBlank(message = "Sensor name is mandatory.")
	private String sensorName;
	
	@NotBlank (message = "Sensor type is mandatory.")
	private String sensorType;
	
	@NotNull(message = "Sensor pin is mandatory.")
	@Min(0)
	@Max(1000)
	private Integer sensorPin;
	
	private String sensorLocation;
	
	@NotNull(message = "Sensor status is mandtory.")
	@Enumerated(EnumType.STRING)
	private SensorStatus sensorStatus;
	
	public enum SensorStatus {
		ON, OFF
	}
	
	public Long getSensorID() {
		return sensorID;
	}
	
	public void setSensorID(Long sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getSensorPin() {
        return sensorPin;
    }

    public void setSensorPin(Integer sensorPin) {
        this.sensorPin = sensorPin;
    }

    public String getSensorLocation() {
        return sensorLocation;
    }
    
    public void setSensorLocation(String sensorLocation) {
    	this.sensorLocation = sensorLocation;
    }
    
    public SensorStatus getSensorStatus() {
    	return sensorStatus;
    }
    
    public void setSensorStatus(SensorStatus sensorStatus) {
    	this.sensorStatus = sensorStatus;
    }
}
