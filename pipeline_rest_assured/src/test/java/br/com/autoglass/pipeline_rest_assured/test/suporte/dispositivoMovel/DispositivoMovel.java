package br.com.autoglass.pipeline_rest_assured.test.suporte.dispositivoMovel;

public class DispositivoMovel {

	private String IMEI;
	private String CODEMPRESA;
	
	public String getCODEMPRESA() {
		return CODEMPRESA;
	}

	public void setCODEMPRESA(String cODEMPRESA) {
		CODEMPRESA = cODEMPRESA;
	}

	public DispositivoMovel() {
		
	}

	public String getIMEI() {
		return IMEI;
	}

	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}

	public DispositivoMovel getDisposivoMovelBD(String clausulaWhere){
		DispositivoMovel dispositivo = new DispositivoMovelDAO().getIMEIDispositivoMovel(clausulaWhere);
		return dispositivo;
	}

	
}
