package accesoadatos;

import java.sql.DriverManager;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class ComunDB {
    private static String cadenaConexion = "jdbc:mysql://localhost:3306/registroestudiantes?user=root&password=080218";

    public static Connection obtenerconexion() throws SQLException {
        DriverManager.registerDriver(new Driver() {
            @Override
            public Connection connect(String url, Properties info) throws SQLException {
                return null;
            }

            @Override
            public boolean acceptsURL(String url) throws SQLException {
                return false;
            }

            @Override
            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                return new DriverPropertyInfo[0];
            }

            @Override
            public int getMajorVersion() {
                return 0;
            }

            @Override
            public int getMinorVersion() {
                return 0;
            }

            @Override
            public boolean jdbcCompliant() {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        });
        Connection conexion = DriverManager.getConnection(cadenaConexion);
        return conexion;
    }

    public static Connection obtenerConexion() throws SQLException, SQLException {
        DriverManager.registerDriver(new Driver() {
            @Override
            public Connection connect(String url, Properties info) throws SQLException {
                return null;
            }

            @Override
            public boolean acceptsURL(String url) throws SQLException {
                return false;
            }

            @Override
            public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                return new DriverPropertyInfo[0];
            }

            @Override
            public int getMajorVersion() {
                return 0;
            }

            @Override
            public int getMinorVersion() {
                return 0;
            }

            @Override
            public boolean jdbcCompliant() {
                return false;
            }

            @Override
            public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
            }
        });
        Connection conexion = DriverManager.getConnection(cadenaConexion);
        return conexion;
    }

    public static PreparedStatement crearPreparedStatement(Connection conexion, String sql) throws SQLException {
        PreparedStatement ps = conexion.prepareStatement(sql);
        return ps;
    }

    public static ResultSet obtenerResultSet(PreparedStatement ps) throws SQLException {
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }
}

