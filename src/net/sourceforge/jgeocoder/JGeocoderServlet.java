package net.sourceforge.jgeocoder;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import net.opengis.xls.RequestDocument;
import net.opengis.xls.AddressType;
import net.opengis.xls.GeocodeRequestDocument;
import net.opengis.xls.GeocodeResponseDocument;
import net.sourceforge.jgeocoder.tiger.JGeocoder;

public class JGeocoderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			BufferedReader reader = null;
			ServletOutputStream outStream = response.getOutputStream();
			if (request.getParameter("REQUEST") != null && request.getParameter("REQUEST").length() > 0)
				reader = new BufferedReader(new StringReader(request.getParameter("REQUEST")));
			else if (ServletFileUpload.isMultipartContent(request))
				reader = new BufferedReader(new InputStreamReader(((FileItem)(new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request).get(0))).getInputStream()));
			else
				reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			GeocodeRequestDocument input = GeocodeRequestDocument.Factory.parse(RequestDocument.Factory.parse(reader).getBody().newReader());
			GeocodeResponseDocument output = GeocodeResponseDocument.Factory.newInstance();
			for ( AddressType address : input.getGeocodeRequest().getAddressArray()) {
				String addressString = address.getAddressee();
				JGeocoder jg = new JGeocoder();
				JGeocodeAddress ret  = jg.geocodeAddress(addressString);
				Map<AddressComponent,String> map = ret.getGeocodedAddr();
				output.addNewGeocodeResponse();
				output.getGeocodeResponse().addNewGeocodeResponseList();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].addNewGeocodedAddress();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].getGeocodedAddressArray()[0].addNewAddress();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].getGeocodedAddressArray()[0].addNewPoint();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].getGeocodedAddressArray()[0].addNewGeocodeMatchCode();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].getGeocodedAddressArray()[0].getPoint().addNewPos();
				output.getGeocodeResponse().getGeocodeResponseListArray()[0].getGeocodedAddressArray()[0].getPoint().getPos().setStringValue("0 0");
				jg.cleanup();
			}
		    output.save(outStream);
			outStream.close();
		} catch ( Exception e ) {
			e.printStackTrace();
			
		}
	}

}
