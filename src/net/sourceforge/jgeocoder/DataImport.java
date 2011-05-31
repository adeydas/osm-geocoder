package net.sourceforge.jgeocoder;

import java.sql.PreparedStatement;
import java.sql.Connection;
import net.sourceforge.jgeocoder.osm.parser.OSMParser;
import net.sourceforge.jgeocoder.osm.parser.model.OSM;
import net.sourceforge.jgeocoder.osm.parser.model.Way;
import net.sourceforge.jgeocoder.osm.parser.model.OSMNode;
import net.sourceforge.jgeocoder.tiger.DatabaseUtils;

public class DataImport {

	public static void main ( String args[] ) throws Exception {
		int i = 0 , j = 0;
		//OSM data = OSMParser.parse(args[0]);
		OSM data = OSMParser.parse("/home/bmartins/workspace/Address GeoCoder/data.osm");
		Connection conn = DatabaseUtils.getDataSource().getConnection();
		conn.createStatement().execute("DROP TABLE IF EXISTS TIGER");
		conn.createStatement().execute("CREATE TABLE TIGER ( COUNTRY varchar(2), STATE varchar(30), TLID numeric not null, FEDIRP varchar(2), FENAME varchar(50), FETYPE varchar(30), FEDIRS varchar(2), FRADDL numeric, TOADDL numeric, FRADDR numeric, TOADDR numeric, ZIPL  varchar(5), ZIPR varchar(5), FRLONG numeric not null, FRLAT numeric not null, TOLONG numeric not null, TOLAT  numeric not null, LONG1 numeric, LAT1 numeric, LONG2 numeric, LAT2 numeric, LONG3 numeric, LAT3 numeric, LONG4  numeric, LAT4 numeric, LONG5 numeric, LAT5 numeric, LONG6 numeric, LAT6 numeric, LONG7 numeric, LAT7 numeric, LONG8  numeric, LAT8 numeric, LONG9 numeric, LAT9 numeric, LONG10 numeric, LAT10 numeric )");
		conn.createStatement().execute("create index IDX0_TIGER on TIGER(tlid)");
		conn.createStatement().execute("create index IDX1_TIGER on TIGER(fename)");
		conn.createStatement().execute("create index IDX2_TIGER on TIGER(fraddL)");
		conn.createStatement().execute("create index IDX3_TIGER on TIGER(toaddL)");
		conn.createStatement().execute("create index IDX4_TIGER on TIGER(fraddR)");
		conn.createStatement().execute("create index IDX5_TIGER on TIGER(toaddR)");
		conn.createStatement().execute("create index IDX6_TIGER on TIGER(zipL)");
		conn.createStatement().execute("create index IDX7_TIGER on TIGER(zipR)");
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO TIGER (COUNTRY, STATE, TLID, FEDIRP, FENAME, FETYPE, FEDIRS , FRADDL, TOADDL, FRADDR, TOADDR, ZIPL, ZIPR, FRLONG, FRLAT, TOLONG, TOLAT, LONG1, LAT1, LONG2, LAT2, LONG3, LAT3, LONG4, LAT4, LONG5, LAT5, LONG6, LAT6, LONG7, LAT7, LONG8, LAT8, LONG9, LAT9, LONG10, LAT10) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		for ( Way way : data.getWays() ) {
			if ( !way.tags.containsKey("name") ) continue;
			String type = way.tags.get("highway");
			if ( type != null ) {
				type = "highway " + type;
			} else {
				type = way.tags.get("building");
				if ( type != null ) type = "building " + type;
			}
			if ( type == null ) continue;
			Double lat[] = new Double[10];
			Double lon[] = new Double[10];
			for ( i = 0 ; i < 10 ; i++ ) {
				lat[i] = Double.NaN;
				lon[i] = Double.NaN;
			}
			Double toLat = Double.NaN;
			Double toLon = Double.NaN;
			i = 0;
			for ( OSMNode node : way.nodes ) {
				toLat = new Double(node.lat);
				toLon = new Double(node.lon);
				lat[i] = new Double(node.lat);
				lon[i] = new Double(node.lon);
				if (i < (lat.length - 1)) i++;
			}
			Double frLat = lat[0];
			Double frLon = lon[0];
			String country = way.tags.get("addr:country");
			String state = way.tags.get("addr:city");
			Long tlid = new Long(way.id);
			String FEDIRP = ""; // direction, prefix
			String FEDIRS = ""; // direction, suffix
			String FENAME = way.tags.get("name");
			String FETYPE = type; 
			String houseNumbers[] = way.tags.containsKey("addr:housenumber") ? way.tags.get("addr:housenumber").split(",") : new String[0];
			long FRADDL = 0;
			long TOADDL = 0;
			long FRADDR = 0;
			long TOADDR = 0;
			String ZIPL = way.tags.get("addr:postcode");
			String ZIPR = way.tags.get("addr:postcode");
			stmt.setString(1,country);
			stmt.setString(2,state);
			stmt.setLong(3,tlid);
			stmt.setString(4,FEDIRP);
			stmt.setString(5,FENAME);
			stmt.setString(6,FETYPE);
			stmt.setString(7,FEDIRS);
			stmt.setLong(8,FRADDL);
			stmt.setLong(9,TOADDL);
			stmt.setLong(10,FRADDR);
			stmt.setLong(11,TOADDR);
			stmt.setString(12,ZIPL);
			stmt.setString(13,ZIPR);
			stmt.setDouble(14,frLon);
			stmt.setDouble(15,frLat);
			stmt.setDouble(16,toLon);
			stmt.setDouble(17,toLat);
			for ( i = 0, j = 18 ; i < lat.length ; i++) {
				stmt.setDouble(j++,lon[i]);
				stmt.setDouble(j++,lat[i]);				
			}
			stmt.execute();
		}
	}
	
}