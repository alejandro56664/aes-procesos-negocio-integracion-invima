package co.com.invima.procesos.registro.alimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import co.com.invima.procesos.registro.alimentos.integraciones_web_service.BuscarEstablecimientoByNITRequest;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.BuscarEstablecimientoByNITResponse;

import co.com.invima.procesos.registro.alimentos.integraciones_web_service.CalcularTarifaTramiteRequest;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.CalcularTarifaTramiteResponse;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.DeterminarTipoRevisionRequest;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.DeterminarTipoRevisionResponse;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.GenerarNumeroExpedienteRequest;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.GenerarNumeroExpedienteResponse;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.GenerarNumeroRadicadoRequest;
import co.com.invima.procesos.registro.alimentos.integraciones_web_service.GenerarNumeroRadicadoResponse;


@Endpoint
public class InvimaEndpoint {
	private static final String NAMESPACE_URI = "http://invima.com.co/procesos/registro/alimentos/integraciones-web-service";

	private EstablecimientoRepository establecimientoRepository;
	
	@Autowired
	private IntegracionesService integraciones;

	@Autowired
	public InvimaEndpoint(EstablecimientoRepository establecimientoRepository) {
		this.establecimientoRepository = establecimientoRepository;
	}
	
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "buscarEstablecimientoByNITRequest")
	@ResponsePayload
	public BuscarEstablecimientoByNITResponse getCountry(@RequestPayload BuscarEstablecimientoByNITRequest request) {
		BuscarEstablecimientoByNITResponse response = new BuscarEstablecimientoByNITResponse();
		
		response.setEstablecimiento(establecimientoRepository.findEstablecimiento(request.getNIT()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "calcularTarifaTramiteRequest")
	@ResponsePayload
	public CalcularTarifaTramiteResponse calcularTarifaTramite(@RequestPayload CalcularTarifaTramiteRequest request) {
		CalcularTarifaTramiteResponse response = new CalcularTarifaTramiteResponse();
		
		response.setTarifa(integraciones.calcularTarifa(request.getTipoProducto()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "determinarTipoRevisionRequest")
	@ResponsePayload
	public DeterminarTipoRevisionResponse determinarTipoRevision(@RequestPayload DeterminarTipoRevisionRequest request) {
		DeterminarTipoRevisionResponse response = new DeterminarTipoRevisionResponse();
		
		response.setTipoRevision(integraciones.getTipoRevision(request.getTipoProducto()));

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generarNumeroRadicadoRequest")
	@ResponsePayload
	public GenerarNumeroRadicadoResponse generarNumeroRadicado(@RequestPayload GenerarNumeroRadicadoRequest request) {
		GenerarNumeroRadicadoResponse response = new GenerarNumeroRadicadoResponse();
		
		response.setNumRadicado(integraciones.generarNumeroRadicado());

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "generarNumeroExpedienteRequest")
	@ResponsePayload
	public GenerarNumeroExpedienteResponse generarNumeroExpediente(@RequestPayload GenerarNumeroExpedienteRequest request) {
		GenerarNumeroExpedienteResponse response = new GenerarNumeroExpedienteResponse();
		
		response.setNumExpediente(integraciones.generarNumeroExpediente());

		return response;
	}
}
