package com.meiji.biz.request.http.lottery
import com.miyuan.ifat.support.test.TestContext
import com.miyuan.ifat.support.util.HttpUtil
import com.miyuan.ifat.support.util.JsonUtil
import com.miyuan.ifat.support.util.ResourceUtil
import com.miyuan.ifat.support.vo.Record
import org.apache.commons.lang3.ObjectUtils

import java.lang.reflect.Method

abstract class LotPost {
    public String api
    public List params
    public String preInvoke

    LotPost invoke(TestContext testContext){
        String scrmUrl = ResourceUtil.getBeanData("http").get("lottery")
        String url = scrmUrl + api
        String cookie = "token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJhZG1pbiIsImxvZ2luSWQiOjc2LCJyblN0ciI6IkZsYTEyODdhczJCS204SVpCbkszZGEwWFF4ekp1NFFUIiwidXNlcm5hbWUiOiJ5YW5saWFuZyJ9.FzDas9WCnv2ovRQU5M5oT3JWFiz5nvITZo54bW5IH9g"
        Map heads = new HashMap()
        heads.put("authority", "wasp.xboil.cn")
        heads.put("sec-ch-ua",'[{"Google Chrome";v="113", "Chromium";v="113", "Not-A.Brand";v="24"}]')
        heads.put("sec-ch-ua-mobile", "?0")
        heads.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
        heads.put("request-origion", "SwaggerBootstrapUi")
        heads.put("accept", "*/*")
        heads.put("userid", "1")
        heads.put("Cookie", cookie)
        heads.put("x-requested-with", "XMLHttpRequest")
        heads.put("content-type","application/json")
        heads.put("companyId", "1")
        heads.put("sec-ch-ua-platform", '"macOS"')
        heads.put("origin", "https://wasp.xboil.cn")
        heads.put("sec-fetch-site", "same-origin")
        heads.put("sec-fetch-mode", "cors")
        heads.put("sec-fetch-dest", "empty")
        heads.put("referer", "https://wasp.xboil.cn/")
        heads.put("accept-language", "zh-CN,zh;q=0.9,en;q=0.8")
        /*if(TestEnv.getIsGray()=="true"){
            heads.put("isGrayRelease",true)
        }*/
        Map req = new HashMap()
        for(String str:params){
            if(ObjectUtils.isNotEmpty(testContext.get(str))){
                req.put(str,JsonUtil.objectParse(testContext.get(str)))
            }
        }
        testContext.appendLog(new Record("接口地址",url))
        testContext.appendLog(new Record("请求头",heads))
        testContext.appendLog(new Record("请求参数",req))
        String res = HttpUtil.post(url,heads, req)
        testContext.setResponse(res)
        testContext.appendLog(new Record("返回结果",res))
        return this
    }

    LotPost preInvoke(TestContext testContext){
        if(preInvoke!=null){
            Class clazz = Class.forName(preInvoke)
            Method method1 = clazz.getMethod("invoke", TestContext.class)
            method1.invoke(clazz.newInstance(),testContext)
            Method method2 = clazz.getMethod("afterInvoke", TestContext.class)
            method2.invoke(clazz.newInstance(),testContext)
        }
        return this
    }

    LotPost afterInvoke(TestContext testContext){
        return this

    }

    LotPost baseAssert(TestContext testContext){
//        Result result = testContext.getResult() as Result
//        assert result.getHttpStatusCode() == 200
        assert testContext.getResponse().code == "0"

        return this
    }

    LotPost specialAssert(TestContext testContext){
        return this
    }

}
