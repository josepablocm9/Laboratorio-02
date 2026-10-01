public class Pista {

    private String codigo;
    private String descripcion;
    private String tipoEvidencia;
    private int nivelImportancia;
    private double nivelConfiabilidad;

    public Pista(String codigo, String descripcion, String tipoEvidencia,
                 int nivelImportancia, double nivelConfiabilidad) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        if (tipoEvidencia == null || tipoEvidencia.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de evidencia no puede estar vacío."
            );
        }

        validarImportancia(nivelImportancia);
        validarConfiabilidad(nivelConfiabilidad);

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoEvidencia = tipoEvidencia;
        this.nivelImportancia = nivelImportancia;
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    private void validarImportancia(int nivelImportancia) {
        if (nivelImportancia < 1 || nivelImportancia > 10) {
            throw new IllegalArgumentException(
                    "La importancia debe estar entre 1 y 10."
            );
        }
    }

    private void validarConfiabilidad(double nivelConfiabilidad) {
        if (nivelConfiabilidad < 0 || nivelConfiabilidad > 100) {
            throw new IllegalArgumentException(
                    "La confiabilidad debe estar entre 0 y 100."
            );
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoEvidencia() {
        return tipoEvidencia;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public double getNivelConfiabilidad() {
        return nivelConfiabilidad;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        this.descripcion = descripcion;
    }

    public void setTipoEvidencia(String tipoEvidencia) {
        if (tipoEvidencia == null || tipoEvidencia.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de evidencia no puede estar vacío."
            );
        }

        this.tipoEvidencia = tipoEvidencia;
    }

    public void setNivelImportancia(int nivelImportancia) {
        validarImportancia(nivelImportancia);
        this.nivelImportancia = nivelImportancia;
    }

    public void setNivelConfiabilidad(double nivelConfiabilidad) {
        validarConfiabilidad(nivelConfiabilidad);
        this.nivelConfiabilidad = nivelConfiabilidad;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + "\nDescripción: " + descripcion
                + "\nTipo de evidencia: " + tipoEvidencia
                + "\nNivel de importancia: " + nivelImportancia
                + "\nNivel de confiabilidad: " + nivelConfiabilidad;
    }
}