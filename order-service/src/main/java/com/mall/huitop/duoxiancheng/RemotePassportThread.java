package com.mall.huitop.duoxiancheng;

public class RemotePassportThread extends BaseCheckThread {

    public RemotePassportThread(int uid) {
        super(uid);
    }

    @Override
    public Boolean call() throws Exception {
        return new RemotePassportService().checkAuth(uid);
    }
}