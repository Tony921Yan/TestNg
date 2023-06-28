package com.meiji.biz.request.http.lottery.address

import com.meiji.biz.request.http.lottery.LotPost
import com.miyuan.ifat.support.test.TestContext

/**
 *
 @author s1mple
 @create 2022/2/10-11:15
 */
class Page extends LotPost{
    {
        super.api = "/platform/oilsUseOrder/page"
        super.params = ["condition","page","rows"]
    }

    Page invoke(TestContext testContext) {
        super.invoke(testContext)
        return this
    }

    Page preInvoke(TestContext testContext){
        super.preInvoke(testContext)
        return this
    }

    Page baseAssert(TestContext testContext){
        super.baseAssert(testContext)
        return this
    }

}
