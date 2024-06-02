/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudjava_2;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import userInterfaces.Crud;



/**
 *
 * @author Nog
 */
public class UserServices {
    private static Connect connect = new Connect();
    private static Connection connection = connect.getConexao();
    
    private static PreparedStatement ps = null;
    
    public static boolean register(Querys q){
        String query = q.REGISTRAR;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, q.getName());
            ps.setString(2, q.getUser());
            ps.setString(3, q.getPassword());
            
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
            return false;
        }
        
        
    }
    
    public static boolean update(Querys q){
        String query = q.ATUALIZAR;
        try{
            ps = connection.prepareStatement(query);
            ps.setString(1, q.getName());
            ps.setString(2, q.getUser());
            ps.setString(3, q.getPassword());
            ps.setString(4, q.getId());
            
            ps.execute();
            return true;
        }catch(SQLException e){
              Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
              return false;
        }
    }
    public static boolean deleteAll(){
        String query = Querys.ELIMINAR_TODOS;
        try{
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
            return false;
        }
    }
    public static boolean delete(Querys q){
        String query = q.ELIMINAR;
        try{
            ps= connection.prepareStatement(query);
            ps.setString(1, q.getId());
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
             Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
             return false;
        }
    }
    
    public static void setListar(String buscar){
        DefaultTableModel modelo = (DefaultTableModel) Crud.userDashboard.getModel();
        while(modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
        String query = "";
        
        if(buscar.equals("")){
            query = Querys.LISTAR;
        }else{
            query = "SELECT * FROM user WHERE ("
                    + "id LIKE'%" + buscar + "%' OR "
                    + "name LIKE'%" + buscar + "%' OR "
                    + "user LIKE'%" + buscar + "%'"
                    + ")";
        }
        
        String data[] = new String[4];
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                data[0] = rs.getString("id");
                data[1] = rs.getString("name");
                data[2] = rs.getString("user");
                data[3] = rs.getString("password");
                
                modelo.addRow(data);
            }
            
            
        }catch(SQLException e ){
            Logger.getLogger(UserServices.class.getName()).log(Level.SEVERE, null, e); 
        }
    }
}
