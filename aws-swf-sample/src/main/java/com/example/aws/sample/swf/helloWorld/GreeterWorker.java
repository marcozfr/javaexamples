package com.example.aws.sample.swf.helloWorld;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;
import com.amazonaws.services.simpleworkflow.flow.ActivityWorker;
import com.amazonaws.services.simpleworkflow.flow.WorkflowWorker;

public class GreeterWorker  {
	   public static void main(String[] args) throws Exception {
	     ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

//	     String swfAccessId = System.getenv("AWS_ACCESS_KEY_ID");
//	     String swfSecretKey = System.getenv("AWS_SECRET_KEY");
	     AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAYYLKJNACCKXOVNJ6",
	    		 "Hc04du0SKYis83ngqEIvozEWw6UjtnONMVULjMQp");
	     
	     AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(awsCredentials, config);
	     service.setEndpoint("https://swf.us-east-1.amazonaws.com");

	     String domain = "helloWorldWalkthrough";
	     String taskListToPoll = "HelloWorldList";

	     ActivityWorker aw = new ActivityWorker(service, domain, taskListToPoll);
	     aw.addActivitiesImplementation(new GreeterActivitiesImpl());
	     aw.start();

	     WorkflowWorker wfw = new WorkflowWorker(service, domain, taskListToPoll);
	     wfw.addWorkflowImplementationType(GreeterWorkflowImpl.class);
	     wfw.start();
	   }
	}