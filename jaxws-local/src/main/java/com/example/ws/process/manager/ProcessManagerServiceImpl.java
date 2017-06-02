package com.example.ws.process.manager;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jws.WebService;

@WebService(name = "ProcessManagerService", targetNamespace = "http://www.example.com/ProcessManagerService/",
	endpointInterface="com.example.ws.process.manager.ProcessManagerService")
public class ProcessManagerServiceImpl implements ProcessManagerService {
	
	private AtomicInteger instances = new AtomicInteger(0);

	@Override
	public StartProcessResponse startProcess(StartProcessRequest parameters) {
		String processType = parameters.getProcessType();
		System.out.println(processType);
		StartProcessResponse response = new StartProcessResponse();
		response.setExecutionResult("OK");
		response.setProcessId(instances.incrementAndGet());
		response.setProcessStatus("RUNNING");
		return response;
	}

	@Override
	public CheckProcessStatusResponse checkProcessStatus(CheckProcessStatusRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinishProcessResponse finishProcess(FinishProcessRequest parameters) {
		// TODO Auto-generated method stub
		return null;
	}

}
