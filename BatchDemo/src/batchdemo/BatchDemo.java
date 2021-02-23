
package batchdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author smsj
 */
public class BatchDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        int iterations = 10000;
        
        long startBatch = System.currentTimeMillis();        
        doBatchProcPrepared(iterations);
        long stopBatch = System.currentTimeMillis();
        
        long startPrepared = System.currentTimeMillis();        
        doNormalPrepared(iterations);
        long stopPrepared = System.currentTimeMillis();  
        
        long start = System.currentTimeMillis();        
        doNormalStatement(iterations);
        long stop = System.currentTimeMillis();  
        
        System.out.println("Total time (batch): " + (stopBatch - startBatch) + "ms");
        System.out.println("Total time (prepared st): " + (stopPrepared - startPrepared) + "ms");        
        System.out.println("Total time (normal st): " + (stop - start) + "ms");
    } 
    
    
    /**
     * 
     */
    private static void doBatchProcPrepared(int iterations) {
        try (Connection conn = DBConnection.getConnection()) {
            
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO [User] VALUES (?,?)");
            
            for (int i = 0; i < iterations; i++) {
                stmt.setString(1, "Username" + i);
                stmt.setString(2, "Password" + i);
            
                stmt.addBatch();    
            }            
            stmt.executeBatch();
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * 
     */
    private static void doNormalPrepared(int iterations) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO [User] VALUES (?,?)");
            
            for (int i = 0; i < iterations; i++) {
                stmt.setString(1, "Username" + i);
                stmt.setString(2, "Password" + i); 
                
                stmt.executeUpdate();
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
    }       
    
    /**
     * 
     */
    private static void doNormalStatement(int iterations) {
        try (Connection conn = DBConnection.getConnection()) {            
            
            for (int i = 0; i < iterations; i++) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO [User] VALUES ('Username" + i + "','Password" + i + "')");
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
