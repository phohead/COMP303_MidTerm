package com.example.WilsonYang_MidtermTest_COMP303;
import com.example.WilsonYang_MidtermTest_COMP303.entity.Sensor;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.*;

@Controller
@RequestMapping("/sensors")
public class SensorController {
	
	@Autowired
	private SensorRepo sensorRepo;
	
	@GetMapping
	public String listSensors(Model model) {
		model.addAttribute("sensors", sensorRepo.findAll());
		model.addAttribute("count", sensorRepo.count());
		return "sensor-list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("sensor", new Sensor());
		return "sensor-add";
	}
	
	@PostMapping("/add")
	public String addSensor(@ModelAttribute("sensor") @Valid Sensor sensor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("sensor", sensor);
			return "sensor-add";
		}
		sensorRepo.save(sensor);
		return "redirect:/sensors";
	}
	
	@GetMapping("/exists")
	public String sensorExists(@RequestParam("sensorId") Long id, Model model) {
		boolean exists = sensorRepo.existsById(id);
		model.addAttribute("sensorExists", exists);
		model.addAttribute("sensorId", id);
		return "existing-sensor";
	}
}
