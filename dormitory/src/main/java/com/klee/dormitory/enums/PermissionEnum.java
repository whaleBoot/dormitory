package com.klee.dormitory.enums;

public enum PermissionEnum {
    SYS_ADMIN(0, "系统管理员"),
    DORM_ADMIN(1, "宿舍管理员");
    private int status;
    private String text;

    PermissionEnum(int status, String text) {
        this.status = status;
        this.text = text;

    }

    public static PermissionEnum get(int v) {

        for (PermissionEnum e : values()) {
            if (e.status == v) {
                System.out.println("v = [" + v + "]");
                return e;
            }
        }
        return null;
//        String str=String.valueOf(v);
//        return get(str);
    }

    public static PermissionEnum get(String str) {
        for (PermissionEnum e : values()) {
            System.out.println("e = [" + e + "]");

            if (e.toString().equals(str)) {
                return e;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

}


