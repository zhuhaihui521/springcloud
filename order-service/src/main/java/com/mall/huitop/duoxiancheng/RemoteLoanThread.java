package com.mall.huitop.duoxiancheng;

public class RemoteLoanThread extends BaseCheckThread {
    public RemoteLoanThread(int uid) {
        super(uid);
    }

    @Override
    public Boolean call() throws Exception {
        return new RemoteLoanService().checkAuth(uid);
    }
}
