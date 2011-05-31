/*
 * An XML document type.
 * Localname: AOI
 * Namespace: http://www.opengis.net/xls
 * Java type: net.opengis.xls.AOIDocument
 *
 * Automatically generated - do not modify.
 */
package net.opengis.xls.impl;
/**
 * A document containing one AOI(@http://www.opengis.net/xls) element.
 *
 * This is a complex type.
 */
public class AOIDocumentImpl extends net.opengis.xls.impl.ADTDocumentImpl implements net.opengis.xls.AOIDocument
{
    
    public AOIDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName AOI$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/xls", "AOI");
    
    
    /**
     * Gets the "AOI" element
     */
    public net.opengis.xls.AreaOfInterestType getAOI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AreaOfInterestType target = null;
            target = (net.opengis.xls.AreaOfInterestType)get_store().find_element_user(AOI$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "AOI" element
     */
    public void setAOI(net.opengis.xls.AreaOfInterestType aoi)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AreaOfInterestType target = null;
            target = (net.opengis.xls.AreaOfInterestType)get_store().find_element_user(AOI$0, 0);
            if (target == null)
            {
                target = (net.opengis.xls.AreaOfInterestType)get_store().add_element_user(AOI$0);
            }
            target.set(aoi);
        }
    }
    
    /**
     * Appends and returns a new empty "AOI" element
     */
    public net.opengis.xls.AreaOfInterestType addNewAOI()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.xls.AreaOfInterestType target = null;
            target = (net.opengis.xls.AreaOfInterestType)get_store().add_element_user(AOI$0);
            return target;
        }
    }
}
