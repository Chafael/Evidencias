package org.medrecord.model;

public class Medicamento {
    private int idMedicamento;
    private String nombreMedicamento;
    private String unidadMedicamento;
    private String categoriaMedicamento;
    private String tipoMedicamento;

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getUnidadMedicamento() {
        return unidadMedicamento;
    }

    public void setUnidadMedicamento(String unidadMedicamento) {
        this.unidadMedicamento = unidadMedicamento;
    }

    public String getCategoriaMedicamento() {
        return categoriaMedicamento;
    }

    public void setCategoriaMedicamento(String categoriaMedicamento) {
        this.categoriaMedicamento = categoriaMedicamento;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }
}
