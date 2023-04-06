package com.example.chatgptapidemo;

import okhttp3.*;

/**
 * @author zhang.tianming
 */
public class ApiDemo {
    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"prompt\": \"Hello, how are you?\", \"temperature\": 0.5, \"max_tokens\": 50}");
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/engines/davinci-codex/completions")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer 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")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
