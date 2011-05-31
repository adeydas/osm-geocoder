package net.sourceforge.jgeocoder.test;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import net.sourceforge.jgeocoder.CommonUtils;
import net.sourceforge.jgeocoder.JGeocodeAddress;
import net.sourceforge.jgeocoder.tiger.DatabaseUtils;
import net.sourceforge.jgeocoder.tiger.JGeocoder;
import net.sourceforge.jgeocoder.tiger.JGeocoderConfig;

class JaysTest{

	public static void main(String[] args) {
    JGeocoderConfig config = new JGeocoderConfig();
    config.setJgeocoderDataHome("/Users/bmartins/workspace/Address GeoCoder/data");
    config.setTigerDataSource(DatabaseUtils.getDataSource());
    JGeocoder jg = new JGeocoder(config);
    long start = System.currentTimeMillis();
    JGeocodeAddress addr = jg.geocodeAddress("lazaros pizza house");
    System.out.println(ToStringBuilder.reflectionToString(addr, ToStringStyle.MULTI_LINE_STYLE));
    CommonUtils.printElapsed(start, TimeUnit.SECONDS);
    jg.cleanup();
    }
	
}