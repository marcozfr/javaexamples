/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:50 BST)
 */
package pe.gob.sunedu.wsgt.gradosws;


/**
 *  ExtensionMapper class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class ExtensionMapper {
    public static java.lang.Object getTypeObject(
        java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
        if ("http://wsgt.sunedu.gob.pe/gradosws".equals(namespaceURI) &&
                "listaGTPersonaType".equals(typeName)) {
            return pe.gob.sunedu.wsgt.gradosws.ListaGTPersonaType.Factory.parse(reader);
        }

        if ("http://wsgt.sunedu.gob.pe/gradosws".equals(namespaceURI) &&
                "gtPersonaType".equals(typeName)) {
            return pe.gob.sunedu.wsgt.gradosws.GtPersonaType.Factory.parse(reader);
        }

        if ("http://wsgt.sunedu.gob.pe/gradosws".equals(namespaceURI) &&
                "usuarioType".equals(typeName)) {
            return pe.gob.sunedu.wsgt.gradosws.UsuarioType.Factory.parse(reader);
        }

        if ("http://wsgt.sunedu.gob.pe/gradosws".equals(namespaceURI) &&
                "operacionType".equals(typeName)) {
            return pe.gob.sunedu.wsgt.gradosws.OperacionType.Factory.parse(reader);
        }

        if ("http://wsgt.sunedu.gob.pe/gradosws".equals(namespaceURI) &&
                "respuestaType".equals(typeName)) {
            return pe.gob.sunedu.wsgt.gradosws.RespuestaType.Factory.parse(reader);
        }

        throw new org.apache.axis2.databinding.ADBException("Unsupported type " +
            namespaceURI + " " + typeName);
    }
}
