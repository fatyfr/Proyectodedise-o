package entidadesdenegocio;

public class Estudiante {

        private int id;
        private String codigo;
        private String nombre;
        private String apellido;
        private String carrera;

        public Estudiante(){}

        public Estudiante(int id, String codigo, String nombre, String apellido, String carrera) {
            this.id = id;
            this.codigo = codigo;
            this.nombre = nombre;
            this.apellido = apellido;
            this.carrera = carrera;
        }

        public int getId() {
            return id;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getCarrera() {
            return carrera;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
    }
