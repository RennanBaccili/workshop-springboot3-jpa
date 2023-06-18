package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	//boa pratica de programação
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CENCELED(5);
	
	private int code; //codigo do tipo enumero
	
	private OrderStatus(int code) { //construtor do código enumero é private
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	
	// metodo statico poque o metodo vai funcionar sem a necessidade de instanciação
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) { // forma de percorrer todos os valores do ordme status
			if (value.getCode() == code) { // se o código for igual a o código procurado for igual a um tabela
				return value;//retorna o valor
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); // caso não tenha o codigo desejado
	}
}
