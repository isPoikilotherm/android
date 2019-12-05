package yang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
       private Connection conn=null;
       private Statement stat=null;
       private PreparedStatement pstat=null;
       public static final String DRIVER="com.mysql.jdbc.Driver";
       public static final String DM="jdbc:mysql://localhost:3306/wenjuan?useSSL=false&useUnicode=true&characterEncoding=utf-8";
       public static final String USERNAME="root";
       public static final String ROOT="123456";
       //����������
       public  DBUtil(){
    	   try {
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(DM,USERNAME,ROOT);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       //
       public int update(String sql) throws SQLException {
    	  stat=conn.createStatement();
    	   return  stat.executeUpdate(sql);
       }
       //
       public  int update(String sql,Object...arr) throws SQLException{
    	   pstat=conn.prepareStatement(sql);
    	   for (int i = 0; i < arr.length; i++) {
    		  pstat.setObject(i+1, arr[i]);
        	
		}
    	   return pstat.executeUpdate();
       }
       //
       public  ResultSet  query(String sql) throws SQLException{
    	   stat=conn.createStatement();
    	   return stat.executeQuery(sql);
       }
       //
       public ResultSet query(String sql,Object...arr) throws SQLException{
    	   pstat=conn.prepareStatement(sql);
    	   for (int i = 0; i < arr.length; i++) {
     		  pstat.setObject(i+1, arr[i]);
 		}
    	   return pstat.executeQuery();
       }
       //�ر���Դ�ķ���
       public  void closeAll(){
    	
			try {
				   if(pstat !=null)pstat.close();
				   if(stat !=null) stat.close();
		    	   if(conn !=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   
       }
}