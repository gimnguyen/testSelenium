package selem.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connecttomysql {

	public static void connmysql(String word, String mp3, String ogg, String spell, String type, String shortdes,
			String examp) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String myDriver = "org.gjt.mm.mysql.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/testhome?useUnicode=true&characterEncoding=utf-8";

		try {
			Class.forName(myDriver).newInstance(); 
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			
			
//			con = DriverManager.getConnection("jdbc:mysql:///dbname?useUnicode=true&characterEncoding=utf-8", "user", "pass");
			
			
			
			// the mysql insert statement
			String query = " insert into vocabulary (word, mp3url, oggurl, spelling, type, shortdes, example)"
					+ " values (?, ?, ?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt;

			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, word);
			preparedStmt.setString(2, mp3);
			preparedStmt.setString(3, ogg);
			preparedStmt.setString(4, spell);
			preparedStmt.setString(5, type);
			preparedStmt.setString(6, shortdes);
			preparedStmt.setString(7, examp);
			preparedStmt.execute();
			
			System.out.println("write DB");
			
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
	
	public static void myconnect() {
		
		System.out.println("vao myconnect");
		
		 try
		    {  
		        Class.forName("com.mysql.jdbc.Driver");  
		        Connection con=DriverManager.getConnection(  
		        "jdbc:mysql://localhost:3306/testhome","root","");  

		        Statement stmt=con.createStatement();  
		        ResultSet rs=stmt.executeQuery("select * from vocabulary");  
		        while(rs.next())  
		        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		        con.close();
		    }

		    catch(Exception e)
		    {
		        System.out.println(e.getMessage());
		        e.printStackTrace();
		    }
		 finally {
			System.out.println("chay finnally");
		}
		
	}
}
