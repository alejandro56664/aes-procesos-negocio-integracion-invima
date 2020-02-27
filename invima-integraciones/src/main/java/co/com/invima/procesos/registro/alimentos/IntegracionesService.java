package co.com.invima.procesos.registro.alimentos;

import org.springframework.stereotype.Service;

import co.com.invima.procesos.registro.alimentos.integraciones_web_service.TipoRevision;
import java.util.Random;



@Service
public class IntegracionesService {
	

	public TipoRevision getTipoRevision(String tipoProducto) {
		String ltipoProductoString = tipoProducto.toLowerCase();
		if(ltipoProductoString.contains("confites") ||
		   ltipoProductoString.contains("dulce")) {
			return TipoRevision.NSA;
		}
		
		if(ltipoProductoString.contains("bebida")) {
			return TipoRevision.PSA;
		}
		
		if(ltipoProductoString.contains("lacteo")) {
			return TipoRevision.RSA;
		}
		
		if(ltipoProductoString.contains("pescado") ||
		   ltipoProductoString.contains("marisco")) {
			return TipoRevision.RSA;
		}
		
		
		if(ltipoProductoString.contains("panes") ||
		   ltipoProductoString.contains("trigo")) {
			return TipoRevision.PSA;
		}
		return TipoRevision.NSA;
	}

	public String generarNumeroRadicado() {
		return generarNumeroAleatorio();
	}

	public String generarNumeroExpediente() {
		return generarNumeroAleatorio();
	}
	
	private String generarNumeroAleatorio() {
		Random rand = new Random();
		Long num = rand.nextLong();
		num = (num<0) ? num*-1: num;
		
		return num.toString();
	}

	public String calcularTarifa(String tipoProducto) {
		String ltipoProductoString = tipoProducto.toLowerCase();
		if(ltipoProductoString.contains("confites") ||
		   ltipoProductoString.contains("dulce")) {
			return "COP $500000";
		}
		
		if(ltipoProductoString.contains("bebida")) {
			return "COP $650000";
		}
		
		if(ltipoProductoString.contains("lacteo")) {
			return "COP $475000";
		}
		
		if(ltipoProductoString.contains("pescado") ||
		   ltipoProductoString.contains("marisco")) {
			return "COP $990000";
		}
		
		
		if(ltipoProductoString.contains("panes") ||
		   ltipoProductoString.contains("trigo")) {
			return "COP $230000";
		}
		return "COP $100000";
		
	}

}
