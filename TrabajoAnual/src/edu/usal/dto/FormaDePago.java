package edu.usal.dto;

public enum FormaDePago {

	TarjetaDébito(1), TarjetaCrédito(2), Efectivo(3);

	
	FormaDePago (int t) {
		this.t = t;
	}
	
	private int t;
	
	public int getT() {
		return t;
	}
	
	public static FormaDePago getTipo (int t) {
		if (t == 1) {
			return FormaDePago.TarjetaDébito;
		} else if (t == 2) {
			return FormaDePago.TarjetaCrédito;
		} else {
			return FormaDePago.Efectivo;
		}
	}
	
}
