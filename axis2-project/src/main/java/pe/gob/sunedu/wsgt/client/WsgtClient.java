package pe.gob.sunedu.wsgt.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import pe.gob.sunedu.wsgt.gradosws.OpConsultarRNGT;
import pe.gob.sunedu.wsgt.gradosws.OpConsultarRNGTResponse;
import pe.gob.sunedu.wsgt.gradosws.OperacionType;
import pe.gob.sunedu.wsgt.gradosws.WSGradosStub;

public class WsgtClient {
	
	public static void main(String[] args) throws RemoteException {
		
		WSGradosStub stub = new WSGradosStub();
		OpConsultarRNGT c = new OpConsultarRNGT();
		c.setNroDocIdentidad("70427823");
		OperacionType opType = new OperacionType();
		opType.setFecha("1988-10-11");
		opType.setHora("13:32:32");
		opType.setIp_wsServer("192.168.1.1");
		opType.setIp_wsUser("ctype");
		opType.setMac_wsServer("00-14-22-01-23-45");
		c.setOperacion(opType);
//		UsuarioType u = new UsuarioType();
//		u.set
//		c.setUsuario(param);
		OpConsultarRNGTResponse response = stub.opConsultarRNGT(c);
		System.out.println(response);
	}

}
