/*
 * An XML document type.
 * Localname: _RequestParameters
 * Namespace: http://www.opengis.net/xls
 * Java type: net.opengis.xls.RequestParametersDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.xls.impl;
/**
 * A document containing one _RequestParameters(@http://www.opengis.net/xls) element.
 *
 * This is a complex type.
 */
public class RequestParametersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements net.opengis.xls.RequestParametersDocument
{
    
    public RequestParametersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName REQUESTPARAMETERS$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/xls", "_RequestParameters");
    private static final org.apache.xmlbeans.QNameSet REQUESTPARAMETERS$1 = org.apache.xmlbeans.QNameSet.forArray( new javax.xml.namespace.QName[] { 
        new javax.xml.namespace.QName("http://www.opengis.net/xls", "GeocodeRequest"),
        new javax.xml.namespace.QName("http://www.opengis.net/xls", "_RequestParameters"),
        new javax.xml.namespace.QName("http://www.opengis.net/xls", "ReverseGeocodeRequest"),
    });
    
    
    /**
     * Gets the "_RequestParameters" element
     */
    public net.opengis.xls.AbstractRequestParametersType getRequestParameters()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AbstractRequestParametersType target = null;
            target = (net.opengis.xls.AbstractRequestParametersType)get_store().find_element_user(REQUESTPARAMETERS$1, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "_RequestParameters" element
     */
    public void setRequestParameters(net.opengis.xls.AbstractRequestParametersType requestParameters)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AbstractRequestParametersType target = null;
            target = (net.opengis.xls.AbstractRequestParametersType)get_store().find_element_user(REQUESTPARAMETERS$1, 0);
            if (target == null)
            {
                target = (net.opengis.xls.AbstractRequestParametersType)get_store().add_element_user(REQUESTPARAMETERS$0);
            }
            target.set(requestParameters);
        }
    }
    
    /**
     * Appends and returns a new empty "_RequestParameters" element
     */
    public net.opengis.xls.AbstractRequestParametersType addNewRequestParameters()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AbstractRequestParametersType target = null;
            target = (net.opengis.xls.AbstractRequestParametersType)get_store().add_element_user(REQUESTPARAMETERS$0);
            return target;
        }
    }
}
