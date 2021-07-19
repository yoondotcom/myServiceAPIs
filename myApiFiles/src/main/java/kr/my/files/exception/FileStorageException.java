package kr.my.files.exception;

public class FileStorageException extends InvalidValueException {
    public FileStorageException(String message) {
        super(ErrorCode.INVALID_INPUT_VALUE);
    }
}