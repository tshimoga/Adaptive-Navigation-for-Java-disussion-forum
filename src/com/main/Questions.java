package com.main;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Questions extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			sendRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendRequest() throws Exception {
		String url = "https://api.stackexchange.com//2.2/questions?order=desc&sort=activity&tagged=inheritence;java&site=stackoverflow";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
		JSONArray array = json.getJSONArray("items");
		JSONObject j = (JSONObject)array.get(0);
		String abc = "abc";
		
		
		
	}
}
