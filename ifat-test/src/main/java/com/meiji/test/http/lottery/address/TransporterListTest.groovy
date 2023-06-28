package com.meiji.test.http.lottery.address

import com.meiji.biz.request.http.lottery.address.TransporterList
import com.miyuan.ifat.support.test.BaseTest
import com.miyuan.ifat.support.test.TestContext
import com.miyuan.ifat.support.test.TestData
import org.testng.annotations.Test
/**
 *
 @author s1mple
 @create 2022/2/10-11:16
 */
class TransporterListTest extends BaseTest {
    TransporterList transporterList = new TransporterList()
    @Test(description = "测试运输服务商 transporterList", groups = ["prod", "uat"], testName = "transporterList",
            dataProvider = "dataProvider", dataProviderClass = TestData.class)
    public void transporterList(TestContext testContext) {
        testContext.put("condition","{}")
        testContext.put("page",1)
        testContext.put("rows",20)
        transporterList.invoke(testContext).baseAssert(testContext).specialAssert(testContext)
    }
}
