package com.meiji.test.http.lottery.address
import com.meiji.biz.request.http.lottery.address.Page
import com.miyuan.ifat.support.test.BaseTest
import com.miyuan.ifat.support.test.TestContext
import com.miyuan.ifat.support.test.TestData
import org.testng.annotations.Test
/**
 *
 @author s1mple
 @create 2022/2/10-11:16
 */
class PageTest extends BaseTest {
    Page page = new Page()
    @Test(description = "订单查询 page", groups = ["prod", "uat"], testName = "page",
            dataProvider = "dataProvider", dataProviderClass = TestData.class)
    public void page(TestContext testContext) {
        testContext.put("condition","{}")
        testContext.put("page",1)
        testContext.put("rows",20)
        page.invoke(testContext).baseAssert(testContext).specialAssert(testContext)
    }
}
