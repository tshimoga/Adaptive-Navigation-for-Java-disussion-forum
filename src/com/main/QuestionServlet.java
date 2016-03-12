package com.main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

public class QuestionServlet extends HttpServlet {
	
	private static String questionURL = "https://api.stackexchange.com//2.2/questions?";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			List<Tag> tags= new ArrayList<Tag>();
			tags.add(Tag.java);
			tags.add(Tag.inheritence);
			List<Question> questions = sendRequest(tags);
			request.setAttribute("questions", questions);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/questions.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Question> sendRequest(List<Tag> tags) throws Exception {
		List<Question> questions = new ArrayList<Question>();
		StringBuilder url = new StringBuilder(questionURL);
		url.append("order=desc");
		url.append("&sort=activity");
		url.append("&tagged=");
		for(Tag tag: tags) {
			url.append(tag.toString()+";");
		}
		url.append("&site=stackoverflow");
		url.append("&filter=!9YdnSIN*R");
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url.toString());
		HttpResponse response = client.execute(request);
		JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
		JSONArray array = json.getJSONArray("items");
		for(int i=0;i<array.length();i++) {
			JSONObject jsonPost = (JSONObject)array.get(i);
			Question question = extractQuestionInformation(jsonPost);
			questions.add(question);
		}
		return questions;
	}
	
	private Question extractQuestionInformation(JSONObject jsonPost) {
		Question question = new Question();
		question.setId(jsonPost.getInt("question_id"));
		question.setTitle(jsonPost.getString("title"));
		question.setAnswered(jsonPost.getBoolean("is_answered"));
		question.setAnswers(extractAnswers(jsonPost.getJSONArray("answers")));
		question.setBody(jsonPost.getString("body"));
		return question;
	}
	
	
	private List<Answer> extractAnswers(JSONArray jsonArray) {
		List<Answer> answers = new ArrayList<Answer>();
		
		return answers;
	}
}
