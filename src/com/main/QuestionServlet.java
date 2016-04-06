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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionServlet extends HttpServlet {

	private static String questionURL = "https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&tagged=tags&site=stackoverflow&filter=filters";
	private static String filter = "!9YdnSIN18";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			User user = (User) request.getSession().getAttribute("user");
			List<Question> questions = getQuestions(user.getInterests());
			request.setAttribute("questions", questions);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/questions.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<Question> getQuestions(List<Tag> tags) throws Exception {
		List<Question> questions = new ArrayList<Question>();
		String url = questionURL;
		url = url.replace("tags", Tag.getTags(tags));
		url = url.replace("filters", filter);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		JSONObject json = new JSONObject(EntityUtils.toString(response
				.getEntity()));
		JSONArray array = json.getJSONArray("items");
		for (int i = 0; i < array.length(); i++) {
			JSONObject jsonPost = (JSONObject) array.get(i);
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
		question.setBody(jsonPost.getString("body"));
		question.setVotes(jsonPost.getInt("score"));
		return question;
	}
}
