import java.util.ArrayList;

public class Caso {

    private String nombre;
    private String codigo;
    private String detectiveResponsable;

    private Ubicacion[] ubicaciones;
    private ArrayList<Pista> pistas;

    public Caso(String nombre, String codigo, String detectiveResponsable) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del caso no puede estar vacío.");
        }

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del caso no puede estar vacío.");
        }

        if (detectiveResponsable == null || detectiveResponsable.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El detective responsable no puede estar vacío."
            );
        }

        this.nombre = nombre;
        this.codigo = codigo;
        this.detectiveResponsable = detectiveResponsable;

        ubicaciones = new Ubicacion[5];
        pistas = new ArrayList<>();
    }


    public void registrarUbicacion(int posicion, Ubicacion ubicacion) {

        validarPosicion(posicion);

        if (ubicaciones[posicion] != null) {
            throw new IllegalArgumentException(
                    "La posición ya contiene una ubicación."
            );
        }

        if (ubicacion == null) {
            throw new IllegalArgumentException(
                    "La ubicación no puede ser null."
            );
        }

        ubicaciones[posicion] = ubicacion;
    }

    public void consultarUbicaciones() {

        boolean hayUbicaciones = false;

        System.out.println("\n===== UBICACIONES REGISTRADAS =====");

        for (int i = 0; i < ubicaciones.length; i++) {

            if (ubicaciones[i] != null) {

                hayUbicaciones = true;

                System.out.println("\nPosición: " + i);
                System.out.println(ubicaciones[i]);
            }
        }

        if (!hayUbicaciones) {
            System.out.println("No hay ubicaciones registradas.");
        }
    }

    public void consultarUbicacion(int posicion) {

        validarPosicion(posicion);

        if (ubicaciones[posicion] == null) {
            System.out.println("La posición está vacía.");
            return;
        }

        System.out.println("\n===== UBICACIÓN =====");
        System.out.println("Posición: " + posicion);
        System.out.println(ubicaciones[posicion]);
    }

    public void modificarUbicacion(
            int posicion,
            int nuevoRiesgo,
            String nuevoEstado) {

        validarPosicion(posicion);

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe una ubicación en esa posición."
            );
        }

        ubicaciones[posicion].setNivelRiesgo(nuevoRiesgo);
        ubicaciones[posicion].setEstado(nuevoEstado);
    }

    public void descartarUbicacion(int posicion) {

        validarPosicion(posicion);

        if (ubicaciones[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe una ubicación en esa posición."
            );
        }

        ubicaciones[posicion] = null;
    }

    private void validarPosicion(int posicion) {

        if (posicion < 0 || posicion >= ubicaciones.length) {
            throw new IndexOutOfBoundsException(
                    "La posición debe estar entre 0 y 4."
            );
        }
    }


    public void registrarPista(Pista pista) {

        if (pista == null) {
            throw new IllegalArgumentException(
                    "La pista no puede ser null."
            );
        }

        if (buscarPista(pista.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe una pista con ese código."
            );
        }

        pistas.add(pista);
    }

    public void consultarPistas() {

        System.out.println("\n===== PISTAS REGISTRADAS =====");

        if (pistas.isEmpty()) {
            System.out.println("No hay pistas registradas.");
            return;
        }

        for (int i = 0; i < pistas.size(); i++) {

            System.out.println("\nPista #" + (i + 1));
            System.out.println(pistas.get(i));
        }
    }

    public Pista buscarPista(String codigo) {

        for (Pista pista : pistas) {

            if (pista.getCodigo().equalsIgnoreCase(codigo)) {
                return pista;
            }
        }

        return null;
    }

    public void mostrarPista(String codigo) {

        Pista pista = buscarPista(codigo);

        if (pista == null) {
            System.out.println("No se encontró una pista con ese código.");
            return;
        }

        System.out.println("\n===== PISTA ENCONTRADA =====");
        System.out.println(pista);
    }

    public void modificarPista(
            String codigo,
            String nuevaDescripcion,
            String nuevoTipo,
            int nuevaImportancia,
            double nuevaConfiabilidad) {

        Pista pista = buscarPista(codigo);

        if (pista == null) {
            throw new IllegalArgumentException(
                    "No se encontró una pista con ese código."
            );
        }

        pista.setDescripcion(nuevaDescripcion);
        pista.setTipoEvidencia(nuevoTipo);
        pista.setNivelImportancia(nuevaImportancia);
        pista.setNivelConfiabilidad(nuevaConfiabilidad);
    }

    public void eliminarPista(String codigo) {

        for (int i = 0; i < pistas.size(); i++) {

            if (pistas.get(i).getCodigo().equalsIgnoreCase(codigo)) {

                pistas.remove(i);

                System.out.println("Pista eliminada correctamente.");
                return;
            }
        }

        throw new IllegalArgumentException(
                "No se encontró una pista con ese código."
        );
    }

    public void generarReporte() {

        int cantidadUbicaciones = 0;
        int mayorRiesgo = -1;
        Ubicacion ubicacionMayorRiesgo = null;

        for (Ubicacion ubicacion : ubicaciones) {

            if (ubicacion != null) {

                cantidadUbicaciones++;

                if (ubicacion.getNivelRiesgo() > mayorRiesgo) {
                    mayorRiesgo = ubicacion.getNivelRiesgo();
                    ubicacionMayorRiesgo = ubicacion;
                }
            }
        }

        int espaciosDisponibles = ubicaciones.length - cantidadUbicaciones;

        System.out.println("\n====================================");
        System.out.println("       REPORTE DE INVESTIGACIÓN");
        System.out.println("====================================");

        System.out.println("Caso: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Detective responsable: " + detectiveResponsable);

        System.out.println("\n--- UBICACIONES ---");
        System.out.println("Ubicaciones registradas: " + cantidadUbicaciones);
        System.out.println("Espacios disponibles: " + espaciosDisponibles);

        if (ubicacionMayorRiesgo != null) {
            System.out.println("\nUbicación con mayor riesgo:");
            System.out.println(ubicacionMayorRiesgo);
        } else {
            System.out.println("No hay ubicaciones registradas.");
        }

        System.out.println("\n--- PISTAS ---");

        System.out.println("Pistas registradas: " + pistas.size());

        if (pistas.isEmpty()) {

            System.out.println("No hay pistas para realizar cálculos.");

        } else {

            Pista mayorImportancia = pistas.get(0);
            Pista mayorConfiabilidad = pistas.get(0);

            double sumaImportancia = 0;

            for (Pista pista : pistas) {

                if (pista.getNivelImportancia()
                        > mayorImportancia.getNivelImportancia()) {

                    mayorImportancia = pista;
                }

                if (pista.getNivelConfiabilidad()
                        > mayorConfiabilidad.getNivelConfiabilidad()) {

                    mayorConfiabilidad = pista;
                }

                sumaImportancia += pista.getNivelImportancia();
            }

            double promedio = sumaImportancia / pistas.size();

            System.out.println("\nPista con mayor importancia:");
            System.out.println(mayorImportancia);

            System.out.println("\nPista con mayor confiabilidad:");
            System.out.println(mayorConfiabilidad);

            System.out.printf(
                    "\nPromedio de importancia: %.2f%n",
                    promedio
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDetectiveResponsable() {
        return detectiveResponsable;
    }
}