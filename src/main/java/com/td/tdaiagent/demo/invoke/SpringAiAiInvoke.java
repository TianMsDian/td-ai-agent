package com.td.tdaiagent.demo.invoke;

import com.alibaba.cloud.ai.dashscope.api.DashScopeApi;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring AI 框架调用 AI 大模型 阿里
 * @Component在项目启动的时候会扫描这个类转换成Bean 它会发现 有继承 CommandLineRunner 实现了这个接口就会执行
 * 这个Run方法 就能在项目启动时注入Bean 调用大模型
 */
@Component
public class SpringAiAiInvoke implements CommandLineRunner {

    //  SpringAI 可以注入多种ChatModel 类型
    //  dashscopeChatModel 一定要使用阿里云联机的 这个名称    //  因为@Resource 是优先根据名称注入的 所以要使用这个名称

    @Resource
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage assistantMessage = dashscopeChatModel.call(new Prompt("你好,我是牛马打工人"))
                .getResult()
                .getOutput();
        System.out.println(assistantMessage.getText());
    }
}
