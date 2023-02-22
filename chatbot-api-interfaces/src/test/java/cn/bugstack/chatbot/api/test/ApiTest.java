package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * 测试
 *
 * @author ：ez
 * @since ：2023/2/21 21:57
 */
public class ApiTest {
    
    @Test
    public void query_unanswered_questions() throws IOException {
        // https://api.zsxq.com/v2/groups/51112124845114/topics?scope=unanswered_questions&count=20
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112124845114/topics?scope=unanswered_questions&count=20");
        
        get.addHeader("cookie", "zsxq_access_token=2943317A-0B1B-9CDB-A77C-7FF6F1A9BD38_D3ECDD20E6D92B25; zsxqsessionid=cc5d515619009acfba4fbd66aa1382bf; abtest_env=product; sensorsdata2015jssdkcross={\"distinct_id\":\"244145584441811\",\"first_id\":\"182abeb7574d85-08b401f76e7a108-26021d51-1327104-182abeb7575937\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgyYWJlYjc1NzRkODUtMDhiNDAxZjc2ZTdhMTA4LTI2MDIxZDUxLTEzMjcxMDQtMTgyYWJlYjc1NzU5MzciLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyNDQxNDU1ODQ0NDE4MTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"244145584441811\"},\"$device_id\":\"182abeb7574d85-08b401f76e7a108-26021d51-1327104-182abeb7575937\"}; UM_distinctid=1867456ca6bad1-097368c829e829-26031951-2a3000-1867456ca6cdd8");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    
    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/814845225441582/answer");
        post.addHeader("cookie", "zsxq_access_token=2943317A-0B1B-9CDB-A77C-7FF6F1A9BD38_D3ECDD20E6D92B25; zsxqsessionid=cc5d515619009acfba4fbd66aa1382bf; abtest_env=product; sensorsdata2015jssdkcross={\"distinct_id\":\"244145584441811\",\"first_id\":\"182abeb7574d85-08b401f76e7a108-26021d51-1327104-182abeb7575937\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgyYWJlYjc1NzRkODUtMDhiNDAxZjc2ZTdhMTA4LTI2MDIxZDUxLTEzMjcxMDQtMTgyYWJlYjc1NzU5MzciLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyNDQxNDU1ODQ0NDE4MTEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"244145584441811\"},\"$device_id\":\"182abeb7574d85-08b401f76e7a108-26021d51-1327104-182abeb7575937\"}; UM_distinctid=1867456ca6bad1-097368c829e829-26031951-2a3000-1867456ca6cdd8");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": true\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
    
    
}