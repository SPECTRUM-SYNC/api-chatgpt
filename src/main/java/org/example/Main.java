package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    private static final String API_KEY = "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";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        // Define the user message
        String userMessage = "Hello ChatGPT!";

        // Create the request body
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("model", "gpt-3.5-turbo-0613");
        JsonArray messageArray = new JsonArray();
        messageArray.add(new Gson().toJsonTree(new Message("user", userMessage)));
        requestBody.add("messages", messageArray);

        // Create the request
        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .post(RequestBody.create(requestBody.toString(), JSON))
                .build();

        // Send the request
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        // Process the response
        if (response.isSuccessful()) {
            JsonObject responseBody = new Gson().fromJson(response.body().string(), JsonObject.class);
            String chatgptResponse = responseBody.getAsJsonArray("choices").get(0).getAsJsonObject().getAsJsonObject("message").get("content").getAsString();
            System.out.println("User: " + userMessage);
            System.out.println("ChatGPT: " + chatgptResponse);
        } else {
            System.out.println("Error: " + response.body().string());
        }
    }

    private static class Message {
        private String role;
        private String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}