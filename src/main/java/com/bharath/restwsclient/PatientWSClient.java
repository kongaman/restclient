package com.bharath.restwsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import com.bharath.restwsclient.model.Patient;

public class PatientWSClient {
	
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 123);
		
		Builder request = target.request();
		Patient patient = request.get(Patient.class);
		
		System.out.println(patient.getName());
		System.out.println(patient.getId());
	}
	
}
