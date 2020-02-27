package co.com.invima.procesos.registro.alimentos;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import co.com.invima.procesos.registro.alimentos.integraciones_web_service.Establecimiento;

@Component
public class EstablecimientoRepository {
	private static final Map<String, Establecimiento> establecimientos = new HashMap<>();

	@PostConstruct
	public void initData() {
		
		Establecimiento contoso = new Establecimiento();
		contoso.setNIT("800555666");
		contoso.setRazonSocial("Ejemplo SAS");
		contoso.setEmailContacto("dir.alimentos@ejemplosas.co");
		establecimientos.put(contoso.getNIT(), contoso);
		

	}

	public Establecimiento findEstablecimiento(String nit) {
		Assert.notNull(nit, "El NIT del establecimiento no puede ser null");
		Establecimiento establecimiento = establecimientos.get(nit);
		if(establecimiento == null) {
			establecimiento = new Establecimiento();
			establecimiento.setExiste(false);
		} else {
			establecimiento.setExiste(true);
		}
		return establecimiento;
	}
	
	
	public void saveEstablecimiento(Establecimiento nuevo) {
		Assert.notNull(nuevo, "El objeto establecimiento no puede ser null");
		establecimientos.put(nuevo.getNIT(), nuevo);
	}
}
