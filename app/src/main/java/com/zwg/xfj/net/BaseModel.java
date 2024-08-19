package com.zwg.xfj.net;

/**
 * Created by shuidi on 2023/7/17.
 */

import com.google.gson.annotations.SerializedName;

/**
 * Created by long.zhang on 2017/6/1.
 */

public class BaseModel<T> {

    @SerializedName("code")
    public String result_code;
    @SerializedName("msg")
    public String message;
    @SerializedName("data")
    public T data;

    private BaseModel(Builder<T> builder) {
        this.result_code = builder.result_code;
        this.message = builder.message;
        this.data = builder.data;
    }


    public static <T> BaseModel<T> createFail() {
        return newBaseModel()
                .message("ResUtil.getString(R.string.base_server_exception)")
                .build();
    }

    public static <T> BaseModel createSuccess(T data) {
        return newBaseModel()
                .data(data)
                .build();
    }

    public static BaseModel createEmpty() {
        return newBaseModel()
                .data(null)
                .build();
    }

    public static Builder newBaseModel() {
        return new Builder();
    }


    public static final class Builder<T> {
        private String result_code;
        private String message;
        private T data;

        private Builder() {
        }

        public BaseModel build() {
            return new BaseModel(this);
        }

        public Builder result_code(String result_code) {
            this.result_code = result_code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "result_code='" + result_code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
