package logicadenegocio;

import accesoadatos.EstudianteDAL;
import entidadesdenegocio.Estudiante;

import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteBL {
    public int guardar(Estudiante estudiante) throws SQLException {
        return EstudianteDAL.guardar(estudiante);
    }

    public int modificar(Estudiante estudiante) throws SQLException{
        return EstudianteDAL.modificar(estudiante);
    }

    public int eliminar(Estudiante estudiante) throws SQLException{
        return EstudianteDAL.eliminar(estudiante);
    }

    public static ArrayList<Estudiante> obtenerTodos() throws SQLException{
        return EstudianteDAL.obtenerTodos();
    }

    public ArrayList<Estudiante> obteberDatosFiltrados(Estudiante estudiante) throws SQLException{
        return EstudianteDAL.obtenerDatosFiltrados(estudiante);
    }
}
