/*
 * XML Type:  AreaOfInterestType
 * Namespace: http://www.opengis.net/xls
 * Java type: net.opengis.xls.AreaOfInterestType
 *
 * Automatically generated - do not modify.
 */
package net.opengis.xls.impl;
/**
 * An XML AreaOfInterestType(@http://www.opengis.net/xls).
 *
 * This is a complex type.
 */
public class AreaOfInterestTypeImpl extends net.opengis.xls.impl.AbstractDataTypeImpl implements net.opengis.xls.AreaOfInterestType
{
    
    public AreaOfInterestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CIRCLEBYCENTERPOINT$0 = 
        new javax.xml.namespace.QName("http://www.opengis.net/gml", "CircleByCenterPoint");
    private static final javax.xml.namespace.QName POLYGON$2 = 
        new javax.xml.namespace.QName("http://www.opengis.net/gml", "Polygon");
    private static final javax.xml.namespace.QName ENVELOPE$4 = 
        new javax.xml.namespace.QName("http://www.opengis.net/gml", "Envelope");
    
    
    /**
     * Gets the "CircleByCenterPoint" element
     */
    public net.opengis.gml.CircleByCenterPointType getCircleByCenterPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.CircleByCenterPointType target = null;
            target = (net.opengis.gml.CircleByCenterPointType)get_store().find_element_user(CIRCLEBYCENTERPOINT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "CircleByCenterPoint" element
     */
    public boolean isSetCircleByCenterPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(CIRCLEBYCENTERPOINT$0) != 0;
        }
    }
    
    /**
     * Sets the "CircleByCenterPoint" element
     */
    public void setCircleByCenterPoint(net.opengis.gml.CircleByCenterPointType circleByCenterPoint)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.CircleByCenterPointType target = null;
            target = (net.opengis.gml.CircleByCenterPointType)get_store().find_element_user(CIRCLEBYCENTERPOINT$0, 0);
            if (target == null)
            {
                target = (net.opengis.gml.CircleByCenterPointType)get_store().add_element_user(CIRCLEBYCENTERPOINT$0);
            }
            target.set(circleByCenterPoint);
        }
    }
    
    /**
     * Appends and returns a new empty "CircleByCenterPoint" element
     */
    public net.opengis.gml.CircleByCenterPointType addNewCircleByCenterPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.CircleByCenterPointType target = null;
            target = (net.opengis.gml.CircleByCenterPointType)get_store().add_element_user(CIRCLEBYCENTERPOINT$0);
            return target;
        }
    }
    
    /**
     * Unsets the "CircleByCenterPoint" element
     */
    public void unsetCircleByCenterPoint()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(CIRCLEBYCENTERPOINT$0, 0);
        }
    }
    
    /**
     * Gets the "Polygon" element
     */
    public net.opengis.gml.PolygonType getPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.PolygonType target = null;
            target = (net.opengis.gml.PolygonType)get_store().find_element_user(POLYGON$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Polygon" element
     */
    public boolean isSetPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(POLYGON$2) != 0;
        }
    }
    
    /**
     * Sets the "Polygon" element
     */
    public void setPolygon(net.opengis.gml.PolygonType polygon)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.PolygonType target = null;
            target = (net.opengis.gml.PolygonType)get_store().find_element_user(POLYGON$2, 0);
            if (target == null)
            {
                target = (net.opengis.gml.PolygonType)get_store().add_element_user(POLYGON$2);
            }
            target.set(polygon);
        }
    }
    
    /**
     * Appends and returns a new empty "Polygon" element
     */
    public net.opengis.gml.PolygonType addNewPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.PolygonType target = null;
            target = (net.opengis.gml.PolygonType)get_store().add_element_user(POLYGON$2);
            return target;
        }
    }
    
    /**
     * Unsets the "Polygon" element
     */
    public void unsetPolygon()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(POLYGON$2, 0);
        }
    }
    
    /**
     * Gets the "Envelope" element
     */
    public net.opengis.gml.EnvelopeType getEnvelope()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.EnvelopeType target = null;
            target = (net.opengis.gml.EnvelopeType)get_store().find_element_user(ENVELOPE$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "Envelope" element
     */
    public boolean isSetEnvelope()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ENVELOPE$4) != 0;
        }
    }
    
    /**
     * Sets the "Envelope" element
     */
    public void setEnvelope(net.opengis.gml.EnvelopeType envelope)
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.EnvelopeType target = null;
            target = (net.opengis.gml.EnvelopeType)get_store().find_element_user(ENVELOPE$4, 0);
            if (target == null)
            {
                target = (net.opengis.gml.EnvelopeType)get_store().add_element_user(ENVELOPE$4);
            }
            target.set(envelope);
        }
    }
    
    /**
     * Appends and returns a new empty "Envelope" element
     */
    public net.opengis.gml.EnvelopeType addNewEnvelope()
    {
        synchronized (monitor())
        {
            check_orphaned();
            net.opengis.gml.EnvelopeType target = null;
            target = (net.opengis.gml.EnvelopeType)get_store().add_element_user(ENVELOPE$4);
            return target;
        }
    }
    
    /**
     * Unsets the "Envelope" element
     */
    public void unsetEnvelope()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ENVELOPE$4, 0);
        }
    }
}
