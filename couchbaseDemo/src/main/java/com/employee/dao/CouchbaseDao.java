package com.employee.dao;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

@Component
public class CouchbaseDao {

	@Autowired(required = true)
	private Bucket bucket;

	public JsonObject getDocument(String id) throws JSONException {
		JsonDocument doc = bucket.get("employee_"+id);
		JsonObject content = doc.content();
		System.out.println("raw--->" + content);
		return content;
	}

	public void insertDocument(JsonDocument document) {
		bucket.insert(document);
	}
	
	public void updateDocument(JsonDocument document) {
		bucket.replace(document);
	}
	
	public void deleteDocument(String id) {
		bucket.remove(id);
	}
}
