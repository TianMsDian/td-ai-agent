package com.td.tdaiagent.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI 框架调用 AI 大模型 Ollama
 * @Component在项目启动的时候会扫描这个类转换成Bean 它会发现 有继承 CommandLineRunner 实现了这个接口就会执行
 * 这个Run方法 就能在项目启动时注入Bean 调用大模型
 */
@Component
public class OllamaAiInvoke implements CommandLineRunner {


    @Resource
    private ChatModel ollamaChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = ollamaChatModel.call(new Prompt("你好,Ollama"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}
