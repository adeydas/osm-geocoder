package net.sourceforge.jgeocoder.tiger;

import javax.sql.DataSource;
import org.postgresql.jdbc3.Jdbc3SimpleDataSource;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils{

  private DatabaseUtils() {
  }
  
  private static String _tigerUrl;

  public static DataSource getDataSource( ) {
	_tigerUrl = "jdbc:postgresql://localhost/test?user=postgres&password=a2250065";
	return getDataSource(_tigerUrl);
  }
  
  public static DataSource getDataSource ( String tigerUrl ){
	_tigerUrl = tigerUrl;
	try {
		if (!tigerUrl.startsWith("jdbc:postgresql:")) throw new ClassNotFoundException();
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException cnfe) {
		System.err.println("Couldn't find the JDBC driver!");
		System.exit(1);
	}
	Jdbc3SimpleDataSource ds = new Jdbc3SimpleDataSource();
	try {
		URI url = new URI(tigerUrl.substring(tigerUrl.indexOf("jdbc:")+5));
		ds.setServerName(url.getHost());
		ds.setDatabaseName(url.getRawPath().substring(1));
		if (url.getPort() > 0) ds.setPortNumber(url.getPort());
		if (url.getQuery()!=null) for ( String query : url.getQuery().split("&") ) {
		  if(query.startsWith("user")) ds.setUser(query.substring(query.indexOf("=")+1));
		  if(query.startsWith("password")) ds.setPassword(query.substring(query.indexOf("=")+1));
		}
		return ds;
	} catch ( Exception e ) {
		e.printStackTrace();
		System.exit(1);
		return null;
	}
  }
  
  public static void executeScript ( Reader script ) throws SQLException {
		Connection conn = getDataSource().getConnection();
		BufferedReader d = new BufferedReader(script);
		String thisLine, sqlQuery;
		try {
			Statement stmt = conn.createStatement();
			sqlQuery = "";
		    while ((thisLine = d.readLine()) != null) {
		    	thisLine = thisLine.trim();
		        if(thisLine.length() > 0 && thisLine.startsWith("--") || thisLine.length() == 0 ) continue;
		        sqlQuery = (sqlQuery + " " + thisLine).trim();
		        if( sqlQuery.length() > 1 && sqlQuery.charAt(sqlQuery.length() - 1) == ';') {
		            sqlQuery = sqlQuery.replace(';' , ' ');
		            try { stmt.execute(sqlQuery); }
		            catch(SQLException ex) { System.err.println("Error Executing the SQL Script : " + ex.getMessage()); }
		            catch(Exception ex) { System.err.println("Error Executing the SQL Script : " + ex.getMessage()); }
		            sqlQuery = "";
		        }   
		    }
		    stmt.close();
		    conn.close();
		} catch(Exception ex) { 
			System.err.println("Error Executing the SQL Script : " + ex.getMessage());
		}
	}
  
    public static void main ( String args[] ) throws Exception {
    	executeScript(new FileReader(args[0]));
    }

}