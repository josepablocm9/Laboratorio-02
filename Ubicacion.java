public class Ubicacion {

    private String codigo;
    private String nombre;
    private String direccion;
    private int nivelRiesgo;
    private String estado;

    public Ubicacion(String codigo, String nombre, String direccion,
                     int nivelRiesgo, String estado) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }

        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }

        validarRiesgo(nivelRiesgo);

        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nivelRiesgo = nivelRiesgo;
        this.estado = estado;
    }

    private void validarRiesgo(int nivelRiesgo) {
        if (nivelRiesgo < 1 || nivelRiesgo > 10) {
            throw new IllegalArgumentException(
                    "El nivel de riesgo debe estar entre 1 y 10."
            );
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public String getEstado() {
        return estado;
    }

    public void setNivelRiesgo(int nivelRiesgo) {
        validarRiesgo(nivelRiesgo);
        this.nivelRiesgo = nivelRiesgo;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }

        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + "\nNombre: " + nombre
                + "\nDirección: " + direccion
                + "\nNivel de riesgo: " + nivelRiesgo
                + "\nEstado: " + estado;
    }
}