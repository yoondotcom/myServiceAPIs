package kr.my.files.enums;


/**
 * File Permission 속성 정의
 */
public enum UserFilePermissions {
    OWNER_READ("owner:read"),
    OWNER_WRITE("owner:write"),
    GROUP_READ("group:read"),
    GROUP_WRITE("group:write"),
    PUBLIC_READ("public:read"),
    PUBLIC_WRITE("public:write");

    private final String permission;

    UserFilePermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
