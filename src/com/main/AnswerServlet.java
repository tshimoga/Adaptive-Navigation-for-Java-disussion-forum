package com.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnswerServlet extends HttpServlet {

	private static String answerURL = "https://api.stackexchange.com/questions/id/answers?order=desc&sort=activity&site=stackoverflow&filter=filters";
	private static String filter = "!-*f(6rzfcVz5";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ClientProtocolException, IOException, ServletException {
		int question_id = Integer.parseInt(request.getParameter("id"));
		List<Answer> answers = extractAnswers(question_id);
		request.setAttribute("answers", answers);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/answers.jsp");
		dispatcher.forward(request, response);
	}

	private List<Answer> extractAnswers(int question_id) throws ClientProtocolException, IOException {
		List<Answer> answers = new ArrayList<Answer>();
		String url = answerURL;
		url = url.replace("id", String.valueOf(question_id));
		url = url.replace("filters", filter);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		
		JSONObject json = new JSONObject(EntityUtils.toString(response
				.getEntity()));
		JSONArray array = json.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			JSONObject ans = array.getJSONObject(i);
			Answer answer = new Answer();
			answer.setAccepted(ans.getBoolean("is_accepted"));
			answer.setBody(ans.getString("body"));
			answer.setId(ans.getInt("answer_id"));
			answer.setVotes(ans.getInt("score"));
			answers.add(answer);
		}
		return answers;
	}

}
