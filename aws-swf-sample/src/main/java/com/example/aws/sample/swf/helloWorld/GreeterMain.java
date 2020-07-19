package com.example.aws.sample.swf.helloWorld;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflowClient;

public class GreeterMain {
	public static void main(String[] args) throws Exception {
	     ClientConfiguration config = new ClientConfiguration().withSocketTimeout(70*1000);

//	     String swfAccessId = System.getenv("AWS_ACCESS_KEY_ID");
//	     String swfSecretKey = System.getenv("AWS_SECRET_KEY");
	     AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAYYLKJNACCKXOVNJ6",
	    		 "Hc04du0SKYis83ngqEIvozEWw6UjtnONMVULjMQp");

	     AmazonSimpleWorkflow service = new AmazonSimpleWorkflowClient(awsCredentials, config);
	     service.setEndpoint("https://swf.us-east-1.amazonaws.com");

	     String domain = "helloWorldWalkthrough";

	     GreeterWorkflowClientExternalFactory factory = new GreeterWorkflowClientExternalFactoryImpl(service, domain);
	     GreeterWorkflowClientExternal greeter = factory.getClient("someID");
	     greeter.greet();
	   }
}