package com.bharath.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class PatientWSClient {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restws/services/patientservice/patients/123");
		Builder request = target.request();
		Response response = request.get();
		
		System.out.println(response.getStatus());
	}
	
}
