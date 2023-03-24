

package crud1.empleadosDAL;

//Librerias importantes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class conexion {
    String url="C:\\Users\\gabri\\.1 dam\\pr\\crud1\\base de datos\\crud1.s3db";
    Connection  conexionN;
    
    
    /*
    //nos dice donde esta nuestra base de datos 
    String strConexion = "jdbc:sqlite:C:/Users/gabri/.1 dam/pr/crud1/base de datos/crud1.s3db.db";//ruta de base de datos
    //"jdbc:sqlite:C:/Users/gabri/.1 dam/pr/base de datos/crud1.s3db";
    Connection conn=null;
    String strConexionDB ="";
    */
    //constructor
    /*
    public conexion(){
        try {
            //tener cuidado donde se guarda la bd, debe de estar en la misma raiz que este proyecto
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexión esablecida ");
            
        } catch (Exception e) {
            System.out.println("Error en la conexión "+e);
        }
    }
*/
    
    /*otro video*/
     public void conectar() {
        try{
            //Class.forName("org.sqlite.JDBC");
            conexionN=DriverManager.getConnection("jdbc:sqlite:" +url);
            if(conexionN!=null){
                System.out.println("Conexión exitosa");
            }
            
        }catch(SQLException ex){
           System.out.println("Error al conectar: " +ex);  
        }
    }
    
    public void cerrarConexion(){
        try{
            conexionN.close();
        }catch(SQLException ex){
            System.out.println("Error al cerrar");
        }
    }
    
    /*Insert into*/
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
         conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
       
       try{
           PreparedStatement pstm= conexionN.prepareStatement(strSentenciaSQL);
           pstm.execute();
           //pstm.executeUpdate();
           System.out.println("Empleado insertado correctamente");
            return 1;
       }catch(SQLException e){
           System.out.println("Error "+e);
           return 0;
       }    
    }
    
    //importar result de sql
    //consultamos y recuperamos los datos
    //result set nos pide la sentenecia select
    public ResultSet consultarRegistros(String strSentenciaSQL){
        conexion con = new conexion();
        con.conectar();//conexion a base de datos, FUNDAMENTAL
        //consultar
        try {
            //con el parameto de abajo recibimos la sentencia selet(es la misma) y la preparamos
            PreparedStatement pstm= conexionN.prepareStatement(strSentenciaSQL);
            
            //aqui devolvemos la informacion de la consulta, si queremos consultar una persona, esto nos muestra sus datos
            ResultSet respuesta = pstm.executeQuery();
            System.out.println("Se hace consulta");
            return respuesta;
            
        } catch (Exception e) {
            System.out.println("Error"+e);
            return null;
        }    
    }
    
  
}
