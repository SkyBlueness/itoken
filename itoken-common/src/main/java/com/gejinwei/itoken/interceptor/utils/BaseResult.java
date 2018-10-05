package com.gejinwei.itoken.interceptor.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BaseResult implements Serializable {

    private static final String RESULT_OK = "OK";
    private static final String RESULT_NOT_OK = "not_ok";
    private static final String SUCCESS = "SUCCESS";

    private String result;
    private Object data;
    private String success;
    private Cursor cursor;
    private List<Error> errors;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static BaseResult ok(){
        return createBaseResult(RESULT_OK,null,SUCCESS,null,null);
    }

    public static BaseResult ok(Object data){
        return createBaseResult(RESULT_OK,data,SUCCESS,null,null);
    }

    public static BaseResult notOk(List<Error> errors){
        return createBaseResult(RESULT_NOT_OK,null,"",null,errors);
    }

    private static BaseResult createBaseResult(String result, Object data, String success, Cursor cursor, List<Error> errors) {
        BaseResult baseResult = new BaseResult();
        baseResult.setResult(result);
        baseResult.setCursor(cursor);
        baseResult.setData(data);
        baseResult.setErrors(errors);
        baseResult.setSuccess(success);
        return baseResult;
    }

    @Data
    public static class Cursor{
        private int totle;
        private int offset;
        private int limit;

        public int getTotle() {
            return totle;
        }

        public void setTotle(int totle) {
            this.totle = totle;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    @Data
    public static class Error{
        private String feild;
        private String message;

        public String getFeild() {
            return feild;
        }

        public void setFeild(String feild) {
            this.feild = feild;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Error(String feild, String message) {
            this.feild = feild;
            this.message = message;
        }

        public Error() {
            super();
        }
    }
}
