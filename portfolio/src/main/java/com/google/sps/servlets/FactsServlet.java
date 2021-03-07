package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/facts")
public class FactsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> factsarray = new ArrayList<>();
    factsarray.add("I am an identical twin!");
    factsarray.add("I live in Southern California!");
    factsarray.add("I have been playing tennis for 12 years!");
    String json = convertToJsonUsingGson(factsarray);
    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

    private String convertToJsonUsingGson(ArrayList<String> factsarray) {
        Gson gson = new Gson();
        String json = gson.toJson(factsarray);
        return json;
    }

}
