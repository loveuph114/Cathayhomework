package dev.reece.cathayhomework.data.api;

/**
 * Created by reececheng on 2019/1/24.
 */

public class LoadException extends Exception {
    public enum ErrorCode {
        EMPTY,
        UNKNOWN
    }

    public final ErrorCode errorCode;

    public LoadException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
