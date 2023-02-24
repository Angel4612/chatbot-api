package cn.bugstack.chatbot.api.domain.zsxq.model.req;

/**
 * 请求问答接口信息
 *
 * @author ：ez
 * @since ：2023/2/22 10:05
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }

}