/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudjava_2;

/**
 *
 * @author Nog
 */
public class Querys {
    
    public static String LISTAR = "SELECT * FROM user";
    
    public static String REGISTRAR = "INSERT INTO user ("
            + "name, "
            + "user, "
            + "password ) "
            + "VALUES(?,?,?)";
    
    public static String ATUALIZAR = "UPDATE user SET "
            + "name = ?, "
            + "user = ?, "
            + "password = ? "
            + "WHERE idUser = ?";
    
    public static String ELIMINAR = "DELETE FROM user WHERE id = ?";
    
    public static String ELIMINAR_TODOS = "TRUNCATE TABLE user";
    
    private String id;
    private String name;
    private String user;
    private String password;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
  
    
    
}
