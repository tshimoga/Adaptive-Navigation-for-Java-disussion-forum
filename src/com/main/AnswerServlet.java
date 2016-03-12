package com.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class AnswerServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		int question_id = Integer.parseInt(request.getParameter("id"));
		
		
		
	}

	private List<Answer> extractAnswers(JSONArray jsonArray) {
		List<Answer> answers = new ArrayList<Answer>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject ans = jsonArray.getJSONObject(i);
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
