package com.sbx.app.work;

import com.alibaba.fastjson.JSONObject;
import com.sbx.app.user.params.UserInfoParam;
import com.sbx.core.redis.helper.RedissonHelper;
import com.sbx.core.test.SbxBaseTest;
import com.sbx.core.test.SbxBootTest;
import com.sbx.core.test.SbxSpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <p>说明：</p>
 *
 * @author Z.jc
 * @version 1.0.0
 * @since 2021/11/13
 */
@SbxBootTest(enableLoader = true,appName = "sbx-work")
public class RedisTest extends SbxBaseTest {

    @Resource
    private RedissonHelper redissonHelper;

    @Test
    public void test() throws InterruptedException {
        redissonHelper.hIncr("test:ddd","user_id_1",3L);
        Map<String, Long> stringLongMap = redissonHelper.hGetIncr("test:ddd");
        System.out.println(stringLongMap.get("user_id_1"));

    }

    @Test
    public void mapPutTest(){
        UserInfoParam req = new UserInfoParam();
        req.setId(1L);
        req.setEmail("444@qq.com");
        req.setMobile("13111333311");
        req.setUsername("heihei");
        redissonHelper.put("test_map_key","user_id_1",req,10L, TimeUnit.MINUTES);
        //获取单个值
        UserInfoParam result1 = redissonHelper.getMapValue("test_map_key","user_id_1");
        System.out.println(JSONObject.toJSONString(result1));

        //获取整个map
        Map<String, UserInfoParam> maoResykt = redissonHelper.getAllMap("test_map_key");
        System.out.println(JSONObject.toJSONString(maoResykt));
    }

}
