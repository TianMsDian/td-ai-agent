package com.td.tdaiagent.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;

// langchain4j 框架调用 AI 大模型
public class LangChainAiInvoke {
    public static void main(String[] args) {
        ChatLanguageModel qwenChatModel = QwenChatModel.builder()
                .apiKey(TestApiKey.API_KEY)
                .modelName("qwen-max")
                .build();
        String answer  = qwenChatModel.chat("我是牛马打工人,这是我做的Ai大模型调用平台 名称为: AI超级智能体项目");
        System.out.println(answer);

    }
}
