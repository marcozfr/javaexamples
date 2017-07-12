/**
 * WSGrados.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package pe.gob.sunedu.wsgt.gradosws;


/*
 *  WSGrados java interface
 */
public interface WSGrados {
    /**
     * Auto generated method signature
     * Permite a las entidades externas consultar el Registro Nacional de Grados y Títulos.
     * @param opConsultarRNGT0
     */
    public pe.gob.sunedu.wsgt.gradosws.OpConsultarRNGTResponse opConsultarRNGT(
        pe.gob.sunedu.wsgt.gradosws.OpConsultarRNGT opConsultarRNGT0)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature for Asynchronous Invocations
     * Permite a las entidades externas consultar el Registro Nacional de Grados y Títulos.
     * @param opConsultarRNGT0
     */
    public void startopConsultarRNGT(
        pe.gob.sunedu.wsgt.gradosws.OpConsultarRNGT opConsultarRNGT0,
        final pe.gob.sunedu.wsgt.gradosws.WSGradosCallbackHandler callback)
        throws java.rmi.RemoteException;

    //
}
