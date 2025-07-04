package com.td.tdaiagent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * Http 方式调用AI
 */
public class HttpAiInvoke {
        public static void main(String[] args) {
            // 替换为你的实际 API Key
            String apiKey = TestApiKey.API_KEY;

            String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

            // 构建请求头
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", "Bearer " + apiKey);
            headers.put("Content-Type", "application/json");

            // 构建 messages 列表
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "You are a helpful assistant.");

            Map<String, String> userMessage = new HashMap<>();
            userMessage.put("role", "user");
            userMessage.put("content", "你是谁？");

            // 构建 input 部分
            Map<String, Object> input = new HashMap<>();
            input.put("messages", Arrays.asList(systemMessage, userMessage));

            // 构建 parameters 部分
            Map<String, String> parameters = new HashMap<>();
            parameters.put("result_format", "message");

            // 构建请求体
            Map<String, Object> body = new HashMap<>();
            body.put("model", "qwen-plus");
            body.put("input", input);
            body.put("parameters", parameters);

            // 将请求体转换为 JSON 字符串
            String jsonBody = JSONUtil.toJsonStr(body);

            // 发送 POST 请求
            String result = HttpRequest.post(url)
                    .addHeaders(headers)
                    .body(jsonBody)
                    .execute()
                    .body();

            System.out.println(result);
    }

}
