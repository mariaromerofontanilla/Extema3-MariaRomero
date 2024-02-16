package fecha;

public class Fecha {
	private int dia; //d�a
	private int mes; //mes
	private int anho; //a�o

	
	public Fecha() {

	}

	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anho = anio;
	}

	
	
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = anho > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	private boolean esBisiesto() {
		boolean bisiesto = anho % 4 == 0 && anho % 100 != 0 || anho % 400 == 0;
		boolean esBisiesto = bisiesto;
		return bisiesto;
	}

	// M�todo toString
	public String toString() {
		if (dia < 10 && mes < 10) {
			return "0" + dia + "-0" + mes + "-" + anho;
		} else if (dia < 10 && mes >= 10) {
			return "0" + dia + "-" + mes + "-" + anho;
		} else if (dia >= 10 && mes < 10) {
			return dia + "-0" + mes + "-" + anho;
		} else {
			return dia + "-" + mes + "-" + anho;
		}
		
	}

}
