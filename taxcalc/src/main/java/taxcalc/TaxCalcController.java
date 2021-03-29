package taxcalc;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxCalcController {

	@GetMapping("/getTaxes")
	float calculateTaxes(@PathParam("price") float price){
		return price * 0.3F;
	}
}
