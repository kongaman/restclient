package com.bharath.restwsclient;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bharath.restwsclient.model.Patient;

public class PatientWSClient {
	
	private static final String PATIENTS = "/patients";
	private static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		//---------------Get Patient (GET)---------------
		
		WebTarget target = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 123);
		
		Builder request = target.request();
		Patient patient = request.get(Patient.class);
		
		System.out.println(patient.getName());
		System.out.println(patient.getId());
		
		//---------------Update Patient (PUT)---------------
		
		patient.setName("Chris");
		
		WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		
		System.out.println(updateResponse.getStatus());
		
		updateResponse.close();
		
		//---------------Create Patient (POST)---------------
		
		Patient newPatient = new Patient();
		newPatient.setName("Bob");
		
		WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
		Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient.class);
		
		System.out.println("Created Patient ID: " + createdPatient.getId());
		
		
		
		//---------------Delete Patient (DELETE)---------------
		
		WebTarget deleteTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 123);
		Builder delRequest = deleteTarget.request();
		Response deleteResp = delRequest.delete();
		
		System.out.println(deleteResp.getStatus());
		
		deleteResp.close();
		
		client.close();
	}
	
}
