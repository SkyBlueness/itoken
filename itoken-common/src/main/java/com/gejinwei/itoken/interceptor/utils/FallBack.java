package com.gejinwei.itoken.interceptor.utils;

import com.google.common.collect.Lists;

/**
 * 回归类
 */
public class FallBack {
    /**
     * 502错误回滚回滚
     * @return
     */
    public static String fallBack(){
        String json  = null;
        BaseResult baseResult = BaseResult.notOk(Lists.newArrayList(
                new BaseResult.Error("520","上层服务器没响应")));
        try {
            json = MapperUtils.obj2json(baseResult);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
