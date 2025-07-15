package org.medrecord.model;

public class Prescripcion  {
    private int idPrescripcion;
    private int idConsulta;
    private int idMedicamento;
    private double dosis;
    private int frecuencia;
    private int duracion;
    private String instruccionesAdionales;

    public int getIdPrescripcion() {
        return idPrescripcion;
    }

    public void setIdPrescripcion(int idPrescripcion) {
        this.idPrescripcion = idPrescripcion;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getInstruccionesAdionales() {
        return instruccionesAdionales;
    }

    public void setInstruccionesAdionales(String instruccionesAdionales) {
        this.instruccionesAdionales = instruccionesAdionales;
    }
}

