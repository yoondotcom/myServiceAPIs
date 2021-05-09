package kr.my.files.commons.utils;

public class CheckFileType {

    public static String isAllowedMIMEType(String mimeType) {

        if (mimeType == null || mimeType.equals("")) return "";

        String[] allowedMIMETypesEquals = {
                "application/zip",    // .zip
                "application/pdf",    // .pdf
                "application/msword", // .doc, .dot
                "application/x-hwp", "applicaion/haansofthwp", "application/x-tika-msoffice", // .hwp
                "application/x-tika-ooxml"  // .xlsx, .pptx, .docx
        };

        String[] allowedMIMETypesResult = {
                "application/zip",    // .zip
                "application/pdf",    // .pdf
                "application/msword", // .doc, .dot
                "application/haansoft-hwp", "haansoft-hwp", "haansoft-hwp", // .hwp
                "application/ms-pptx"  // .xlsx, .pptx, .docx
        };

        for (int i=0; i<allowedMIMETypesEquals.length; i++) {
            if (mimeType.equals(allowedMIMETypesEquals[i])) {
                return allowedMIMETypesResult[i];
            }
        }

        String[] allowedMIMETypesStartsWith = {
                "image",    // .png, .jpg, .jpeg, .gif, .bmp
                "text",     // .txt, .html 등
                "application/vnd.ms-word",          // .docx 등 워드 관련
                "application/vnd.ms-excel",         // .xls 등 엑셀 관련
                "application/vnd.ms-powerpoint",    // .ppt 등 파워포인트 관련
                "application/vnd.openxmlformats-officedocument",    // .docx, .dotx, .xlsx, .xltx, .pptx, .potx, .ppsx
                "applicaion/vnd.hancom"     // .hwp 관련
        };
        for (int i=0; i<allowedMIMETypesStartsWith.length; i++) {
            if (mimeType.startsWith(allowedMIMETypesStartsWith[i])) {
                return allowedMIMETypesEquals[i];
            }
        }

        return "NotFound";
    }
}
