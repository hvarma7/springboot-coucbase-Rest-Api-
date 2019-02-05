package com.employee.service;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.employee.dao.CouchbaseDao;

@Service
public class EmployeeService {
	
	@Autowired(required=true)
	private CouchbaseDao couchbaseDao;
	
	public JsonObject getDoc(String id) throws JSONException {
		JsonObject doc =  couchbaseDao.getDocument(id);
		return doc;
	}
	
	public void insertDoc(JsonDocument document) {
		couchbaseDao.insertDocument(document);
	}
	
	public void updatedDoc(JsonDocument document) {
		couchbaseDao.updateDocument(document);
	}
	
	public void deleteDoc(String id) {
		couchbaseDao.deleteDocument(id);
	}
	
}
