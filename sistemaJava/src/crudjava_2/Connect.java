
package crudjava_2;

/**
 *
 * @author Nog
 */

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

public class Connect {
    private static Connection conection = null; // Adicionado 'static' e corrigido o nome para 'conection'
    
    public Connection getConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password");
            Statement statement = conection.createStatement();
        boolean databaseExists = statement.execute("CREATE SCHEMA IF NOT EXISTS `sistema_java` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci");
            
            boolean tableExists = statement.execute(
                    "CREATE TABLE IF NOT EXISTS `sistema_java`.`user` ("
                    + "`id` INT NOT NULL AUTO_INCREMENT,"
                    + "`name` VARCHAR(100) NULL DEFAULT NULL,"
                    + "`user` VARCHAR(100) NULL DEFAULT NULL,"
                    + "`password` VARCHAR(20) NULL DEFAULT NULL,"
                    + "PRIMARY KEY (`id`)) "
                    + "ENGINE = InnoDB "
                    + "AUTO_INCREMENT = 1 "
                    + "DEFAULT CHARACTER SET = utf8mb4 "
                    + "COLLATE = utf8mb4_0900_ai_ci");
            conection = DriverManager.getConnection("jdbc:mysql://localhost/sistema_java", "root", "password");

            
            return conection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
