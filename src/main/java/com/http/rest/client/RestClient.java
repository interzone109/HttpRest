package com.http.rest.client;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.http.rest.entity.DataModel;
import com.http.rest.entity.service.DocumentServiceImpl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Component
public class RestClient {

	private DocumentServiceImpl documentServiceImpl;

	@Autowired
	public RestClient(DocumentServiceImpl documentServiceImpl) {
		this.documentServiceImpl = documentServiceImpl;
	}

	public DataModel getObjectByUrl(String url) {
		
		
		if(url == null || url.isEmpty()) {
			throw new NullPointerException();
		}
		
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(url).build();
		Response response = null;
		DataModel dataModel = null;

		ObjectMapper mapper = new ObjectMapper();
		try {
			response = client.newCall(request).execute();

			dataModel = mapper.readValue( response.body().string(), DataModel.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dataModel.getData().stream().forEach(obj->{
			documentServiceImpl.saveDocument(obj);
		});
		
		
		return dataModel;
	}
}
