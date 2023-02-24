package cn.bugstack.chatbot.api.domain.zsxq;

import cn.bugstack.chatbot.api.domain.zsxq.model.agregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * 知识星球API接口
 *
 * @author ：ez
 * @since ：2023/2/22 10:10
 */
public interface IZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;
    
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}