package com.example.ws.process;

import javax.jws.WebService;

@WebService(targetNamespace = "http://www.example.com/ProcessManagerService/", name = "ProcessManagerService", endpointInterface="com.example.ws.process.ProcessManagerService")
public class ProcessManagerServiceBean implements ProcessManagerService {

	public CheckProcessStatusResponse checkProcessStatus(CheckProcessStatusRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public FinishProcessResponse finishProcess(FinishProcessRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public StartProcessResponse startProcess(StartProcessRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
