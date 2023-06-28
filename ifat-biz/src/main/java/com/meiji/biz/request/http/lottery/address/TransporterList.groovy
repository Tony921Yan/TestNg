package com.meiji.biz.request.http.lottery.address
import com.meiji.biz.request.http.lottery.LotPost
import com.miyuan.ifat.support.test.TestContext

/**
 *
 @author s1mple
 @create 2022/2/10-11:15
 */
class TransporterList extends LotPost{
    {
        super.api = "/platform/system/transporter/list"
        super.params = ["condition","page","rows"]
    }

    TransporterList invoke(TestContext testContext) {
        super.invoke(testContext)
        return this
    }

    TransporterList preInvoke(TestContext testContext){
        super.preInvoke(testContext)
        return this
    }

    TransporterList baseAssert(TestContext testContext){
        super.baseAssert(testContext)
        return this
    }

}
