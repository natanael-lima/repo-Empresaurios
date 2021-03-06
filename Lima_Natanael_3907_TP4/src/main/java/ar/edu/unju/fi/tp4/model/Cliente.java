package ar.edu.unju.fi.tp4.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Cliente {
	
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String mail;
	private String password;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int edad;
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	
	public Cliente() {
		
	}


	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String mail, String password,
			LocalDate fechaNacimiento, int edad, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.mail = mail;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public int getNroDocumento() {
		return nroDocumento;
	}


	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}


	public String getNombreApellido() {
		return nombreApellido;
	}


	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getEdad() {
		LocalDate today = LocalDate.now();
		Period per=Period.between(fechaNacimiento, today);
		edad=per.getYears();
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}


	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}


	public int getNroTelefono() {
		return nroTelefono;
	}


	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}


	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}


	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", mail=" + mail + ", password=" + password + ", fechaNacimiento=" + fechaNacimiento
				+ ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono=" + nroTelefono
				+ ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}

   /**
    * 
    Obtiene tiempo desde la ultima fecha de compra
    */
	
    public String obtenerUltimaCompra() {
    	String fecha="";
		LocalDate today = LocalDate.now();
		Period per =Period.between(fechaUltimaCompra, today);
		fecha="Anios: "+per.getYears()+'|'+" Meses: "+per.getMonths()+'|'+" Dias: "+per.getDays();
		return fecha;
    }
	/**
	 * Obtiene dias transcurridos
	 * @return
	 */
    
    public int obtenerFechaNacimiento() {
    	
    	// Usando ChronoUnit
    	LocalDate today = LocalDate.now();
        int dias = (int) DAYS.between(fechaNacimiento, today); 	
    	return dias;
    }
    /**
     * Obtiene tiempo para proximo cummplea??os
     * @return
     */
	
     public String obtenerCumpleanio() {
		
		String fecha="";
		
		LocalDate hoy = LocalDate.now();
		int anio = 0;
		
		if(hoy.getMonthValue()<fechaNacimiento.getMonthValue()) {
			anio=hoy.getYear();
		}else {
			if(hoy.getMonthValue()==fechaNacimiento.getMonthValue()) {
				if(hoy.getDayOfMonth()<fechaNacimiento.getDayOfMonth()) {
					anio=hoy.getYear();
				}
			}else {
				anio=hoy.getYear()+1;
			}
		}
		
		
        LocalDate proximoCumple=LocalDate.of(anio, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth());
		
	    Period periodo =Period.between(hoy, proximoCumple);
		
		fecha="Anios: "+periodo.getYears()+'|'+" Meses: "+periodo.getMonths()+'|'+" Dias: "+periodo.getDays();
		
		LocalDateTime horaHoy=LocalDateTime.now();
		
		LocalDateTime horasProximoCumple=LocalDateTime.of(anio, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth(), 0, 0, 0);
		
		Duration duracion=Duration.between(horaHoy, horasProximoCumple);
		
		fecha=fecha+'-'+" Hora: "+duracion.toHoursPart()+'|'+" Min: "+duracion.toMinutesPart()+'|'+" Seg: "+duracion.toSecondsPart();
		
		return fecha;
		
	}
	
}
