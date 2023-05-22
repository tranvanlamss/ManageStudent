package com.javatechie.enumerate;

public enum ErrorCodesEnum {
    UNAUTHORIZED("UNAUTHORIZED"),
    ACCESS_DENIED("ACCESS_DENIED"),
    FORBIDDEN("FORBIDDEN"),
    PRODUCT_COMMENT_IS_VALID("PRODUCT_COMMENT_IS_VALID"),
    BODY_AND_CARTON_DID_NOT_MACTCH("DID_NOT_MATCH"),
    BAD_REQUEST("BAD_REQUEST"),
    EMAIL_NOT_VERIFIED("Email chưa được xác minh"),
    PASSWORD_CAN_NOT_EQUAL_NEWPASSWORD("password can't equal newPassword"),
    USER_DEACTIVATED("USER_DEACTIVATED"),
    ORG_DEACTIVATED("ORG_DEACTIVATED"),
    NOT_ALLOW_DOWNGRADE_LEVEL("NOT_ALLOW_DOWNGRADE_LEVEL"),
    INVALID_INPUT_PARAMETER("NOT valid input parameters"),
    INVALID_ID("ID Invalid"),
    INVALID_UID("NOT valid UID"),
    INVALID_USER_ID("NOT valid current User ID"),
    INVALID_USER_STATUS("INVALID_USER_STATUS"),
    SUCCESS("SUCCESS"),
    INVALID_CURRENT_PASSWORD("NOT valid current password, please try again"),
    INVALID_STATUS("INVALID_STATUS"),
    INVALID_TOKEN("NOT valid token"),
    TOKEN_EXPIRED("Token is expired"),
    INVALID_USER_NAME("invalid user name"),
    INVALID_QR_CODE("INVALID_QR_CODE"),
    EMAIL_ALREADY_REGISTED("Email already register"),
    FIND_NOT_FOUND("NOT valid user Email-ID, This email does NOT exist"),
    INVALID_QUALITY_LIMIT("INVALID_QUALITY_LIMIT"),
    USERNAME_ALREADY_REGISTED("Username already register"),
    INVALID_PRODUCTION_CODE_ORDER_ITEM("INVALID_PRODUCTION_CODE_ORDER_ITEM"),
    EMAIL_EMPTY("Email can NOT be empty"),
    USERNAME_EMPTY("USERNAME_EMPTY"),
    PASSWORD_EMPTY("Password can NOT be empty"),
    INVALID_DATE("ngày không hợp lệ"),
    PASSWORD_AND_RETYPE_PASSWORD_NOT_MATCH("Password is not equals Repassword"),
    BIZ_ROLE_EMPTY("Biz Role and Role is required fiels"),
    EMAIL_DOES_NOT_EXISTED("NOT valid user Email-ID, This email does NOT exist"),
    ID_NOT_EMPTY("ID_NOT_EMPTY"),
    PROVIDER_NOT_EMPTY("PROVIDER_NOT_EMPTY"),
    QR_CODE_IS_INUSED("QR_CODE_IS_INUSED"),
    INVALID_DELIVERY_ORDER_ID("INVALID_DELIVERY_ORDER_ID"),
    DELIVERY_ORDER_IS_CANCELLED("DELIVERY_ORDER_IS_CANCELLED"),
    INVALID_CUSTOMER_ID("INVALID_CUSTOMER_ID"),
    INVALID_QRCODE_TYPE("INVALID_QRCODE_TYPE"),
    INVALID_QRCODE_STATUS("INVALID_QRCODE_STATUS"),
    INVALID_PRODUCTION_CODE("INVALID_PRODUCTION_CODE"),
    INVALID_SOLD_TYPE("INVALID_SOLD_TYPE"),
    QRCODE1_DOES_NOT_EXIST("QRCODE1_DOES_NOT_EXIST"),
    QRCODE2_DOES_NOT_EXIST("QRCODE2_DOES_NOT_EXIST"),
    QRCODE1_IS_INUSED("QRCODE1_IS_INUSED"),
    QRCODE2_IS_INUSED("QRCODE2_IS_INUSED"),
    QRCODESET_DOES_NOT_EXIST("QRCODESET_DOES_NOT_EXIST"),
    QRCODESET_INVALID("QRCODESET_INVALID"),
    SALCODE_OF_PRODUCTION_AND_SALCODE_CARTON_NEW_DID_NOT_MACTCH("SALCODE_OF_PRODUCTION_AND_SALCODE_CARTON_NEW_DID_NOT_MACTCH"),
    QRCODE1_NOT_USED_YET("QRCODE1_NOT_USED_YET"),
    QRCODE_NOT_USED_YET("QRCODE_NOT_USED_YET"),
    QRCODE2_NOT_USED_YET("QRCODE2_NOT_USED_YET"),
    PRODUCTION_DOES_NOT_EXIST("PRODUCTION_DOES_NOT_EXIST"),
    PRODUCTION_REPLACE_DOES_NOT_EXIST("PRODUCTION_DOES_NOT_EXIST"),
    PRODUCTION_IS_REPLACED_DOES_NOT_TRANSFERED("PRODUCTION_IS_REPLACED_DOES_NOT_TRANSFERED"),
    INVALID_CATEGORIES("Not found category"),
    INVALID_PRODUCTION_ID("INVALID_PRODUCTION_ID"),
    INVALID_ORDER_ITEM_ID("INVALID_ORDER_ITEM_ID"),
    INVALID_LIST_ORDER_ITEM_ID("INVALID_LIST_ORDER_ITEM_ID"),
    INVALID_DATE_FORMAT("INVALID_DATE_FORMAT"),
    INVALID_TO_DATE_FORMAT("INVALID_TO_DATE_FORMAT"),
    INVALID_FROM_DATE_FORMAT("INVALID_FROM_DATE_FORMAT"),
    SALCODE_ALREADY_EXISTED("SALCODE_ALREADY_EXISTED"),
    CROP_JOB_ALREADY_EXISTED("CROP_JOB_ALREADY_EXISTED"),
    SALCODE_ALREADY_DOES_NOT_EXISTED("SALCODE_ALREADY_DOES_NOT_EXISTED"),
    INVALID_CUSTOMER_TYPE("INVALID_CUSTOMER_TYPE"),
    INVALID_WARRANTY_ID("INVALID_WARRANTY_ID"),
    CAN_NOT_SAVE_ORDER("can not save order"),
    INVALID_WARRANTY_ITEM_ID("INVALID_WARRANTY_ITEM_ID"),
    PARENT_ID_DOES_NOT_EXISTED("PARENT_ID_DOES_NOT_EXISTED"),
    PROD_IS_NOT_UNDER_WARRANTY("PROD_IS_NOT_UNDER_WARRANTY"),
    ORDER_IS_NOT_UNDER_WARRANTY("ORDER_IS_NOT_UNDER_WARRANTY"),
    CUSTOMER_PHONE_EXISTED("CUSTOMER_PHONE_EXISTED"),
    CUSTOMER_CODE_EXISTED("CUSTOMER_CODE_EXISTED"),
    DELIVERY_ITEM_EXISTED("CUSTOMER_CODE_EXISTED"),
    QRCODE_SET_IN_USED("QRCODE_SET_IN_USED"),
    QRCODE_SET_PRINTED("QRCODE_SET_PRINTED"),
    DELIVERY_CODE_EXISTED("DELIVERY_CODE_EXISTED"),
    INVALID_CUSTOMER_CODE("INVALID_CUSTOMER_CODE"),
    PRODUCTION_EXIST_IN_ANOTHER_ORDER("PRODUCTION_EXIST_IN_ANOTHER_ORDER"),
    PRODUCTION_NOT_MATCH_WITH_ORDER("PRODUCTION_NOT_MATCH_WITH_ORDER"),
    PRODUCTION_IS_SCANNED("PRODUCTION_IS_SCANNED"),
    START_DATE_MUST_BE_LESS_THAN_END_DATE("START_DATE_MUST_BE_LESS_THAN_END_DATE"),
    ORDER_IS_BEING_TAKEN("ORDER_IS_BEING_TAKEN"),
    ORDER_HAS_BEEN_DELIVERED("ORDER_HAS_BEEN_DELIVERED"),
    INVALID_ACTIVATED_TYPE("INVALID_ACTIVATED_TYPE"),
    PRODUCTION_NOT_READY_SCAN("PRODUCTION_NOT_READY_SCAN"),
    ANY_PRODUCTION_DOES_NOT_EXIST("ANY_PRODUCTION_DOES_NOT_EXIST"),
    DUPLICATE_PRODUCTION_ID("DUPLICATE_PRODUCTION_ID"),
    PRODUCTION_IN_ORDER_HAS_BEEN_CANCELLED("PRODUCTION_IN_ORDER_HAS_BEEN_CANCELLED"),
    PRODUCTION_IN_ORDER_HAS_NOT_BEEN_DELIVERED("PRODUCTION_IN_ORDER_HAS_NOT_BEEN_DELIVERED"),
    PRODUCTION_HAS_BEEN_WARRANTY("PRODUCTION_HAS_BEEN_WARRANTY"),
    SUFFICIENT_QUANTITY_OF_THE_PRODUCT_HAS_BEEN_TAKEN("SUFFICIENT_QUANTITY_OF_THE_PRODUCT_HAS_BEEN_TAKEN"),
    PRODUCTION_ALREADY_REGISTERED_BY_CUSTOMER("PRODUCTION_ALREADY_REGISTERED_BY_CUSTOMER"),
    SALE_PROGRAM_HAS_NO_EFFECT("SALE_PROGRAM_HAS_NO_EFFECT"),
    NO_PRODCODES("NO_PRODCODES"),
    INVALID_DISTRIBUTER("INVALID_DISTRIBUTER"),
    CUSTOMER_NOT_DISTRIBUTER("CUSTOMER_NOT_DISTRIBUTER"),
    CUSTOMER_NOT_EXIST("CUSTOMER_NOT_EXIST"),
    QR_CODE_NOT_EXIST("QR_CODE_NOT_EXIST"),
    CUSTOMER_PARENT_EXISTED("CUSTOMER_PARENT_EXISTED"),
    CANNOT_ADD_PARENT_TO_CHILD("CANNOT_ADD_PARENT_TO_CHILD"),
    PARENT_ROLE_NOT_MATCH("PARENT_ROLE_NOT_MATCH"),
    CAPTCHA_NOT_MATCH("CAPTCHA_NOT_MATCH"),
    CAPTCHA_EXPIRED("CAPTCHA_EXPIRED"),
    RECORD_EXISTED("RECORD_EXISTED"),
    PRODUCTION_ALREADY_TRANSFERED("PRODUCTION_ALREADY_TRANSFERED"),
    ANY_PRODUCTION_DOES_NOT_TRANSFERRED("ANY_PRODUCTION_DOES_NOT_TRANSFERRED"),
    PRODUCTION_DOES_NOT_TRANSFERRED("PRODUCTION_DOES_NOT_TRANSFERRED"),
    FILE_DO_INCORRECT_FORMAT("FILE_DO_INCORRECT_FORMAT"),
    THE_ORDER_IS_NOT_COMPLETED("THE_ORDER_IS_NOT_COMPLETED"),
    CUSTOMER_IS_CHILDREN_OTHER_CUSTOMER("CUSTOMER_IS_CHILDREN_OTHER_CUSTOMER"),
    FROM_DELIVERY_CODE_EXISTED("FROM_DELIVERY_CODE_EXISTED"),
    TO_DELIVERY_CODE_EXISTED("TO_DELIVERY_CODE_EXISTED"),
    FROM_DELIVERY_ORDER_IS_RETURNED("FROM_DELIVERY_ORDER_IS_RETURNED"),
    FROM_DELIVERY_ORDER_IS_NA("FROM_DELIVERY_ORDER_IS_NA"),
    FROM_DELIVERY_ORDER_IS_CANCELLED("FROM_DELIVERY_ORDER_IS_CANCELLED"),
    FROM_DELIVERY_ODER_IS_DELIVERIED("FROM_DELIVERY_ODER_IS_DELIVERIED"),
    TO_DELIVERY_ORDER_IS_IN_PROGRESS("TO_DELIVERY_ORDER_IS_IN_PROGRESS"),
    TO_DELIVERY_ORDER_IS_RETURNED("TO_DELIVERY_ORDER_IS_RETURNED"),
    TO_DELIVERY_ORDER_IS_DELIVERED("TO_DELIVERY_ORDER_IS_DELIVERED"),
    TO_DELIVERY_ORDER_IS_CANCELLED("TO_DELIVERY_ORDER_IS_CANCELLED"),
    INVALID_CUSTOMER_DELIVERY_TO_SUB_CUSTOMER("INVALID_CUSTOMER_DELIVERY_TO_SUB_CUSTOMER"),
    SURVEY_LINK_WITH_SALCODE_AT_PROVINCE_NOT_EXIST("SURVEY_LINK_WITH_SALCODE_AT_PROVINCE_NOT_EXIST"),
    SURVEY_LINK_AT_PROVINCE_NOT_EXIST("SURVEY_LINK_AT_PROVINCE_NOT_EXIST"),
    PRODUCTION_HAS_BEEN_TRANSFERRED_FOR_SUB_CUSTOMER_OR_RETURNED("PRODUCTION_HAS_BEEN_TRANSFERRED_FOR_SUB_CUSTOMER_OR_RETURNED"),
    ORDER_ITEM_ENOUGH_QUANTITY("ORDER_ITEM_ENOUGH_QUANTITY"),
    QR_CODE_NOT_IN_ORDER("QR_CODE_NOT_IN_ORDER"),
    QRCODESET_OF_QR_REPLACE_DOES_NOT_EXIST("QRCODESET_OF_QR_REPLACE_DOES_NOT_EXIST"),
    DOES_NOT_EXIST_QRCODE_NEED_REPLACE("DOES_NOT_EXIST_QRCODE_NEED_REPLACE"),
    CLIENT_IS_NOT_FOUND("CLIENT_IS_NOT_FOUND"),
    ID_IS_EMPTY("ID_IS_EMPTY"),
    ID_NOT_FOUND("ID_NOT_FOUND"),
    ID_INVALID("ID_INVALID"),
    PRODUCTION_ALREADY_TRANSFERRED_OR_RETURN("PRODUCTION_ALREADY_TRANSFERRED_OR_RETURN"),
    PRODUCTION_NOT_PACKED_OR_RETURNED("PRODUCTION_NOT_PACKED_OR_RETURNED"),
    PRODUCTION_NOT_PACKED("PRODUCTION_NOT_PACKED"),
    ORDER_ITEM_OVER_QUANTITY("ORDER_ITEM_OVER_QUANTITY"),
    MOVE_DELIVERY_DO_NOT_EXIST("MOVE_DELIVERY_DO_NOT_EXIST"),
    MOVE_DELIVERY_ITEM_NOT_EXIST("MOVE_DELIVERY_ITEM_NOT_EXIST"),
    MOVE_DELIVERY_ORDER_ITEM_NOT_EXIST("MOVE_DELIVERY_ORDER_ITEM_NOT_EXIST"),
    MOVE_DELIVERY_ORDER_ITEM_NOT_EXIST_OR_MATCH_QUANTITY("MOVE_DELIVERY_ORDER_ITEM_NOT_EXIST_OR_MATCH_QUANTITY"),

    ORG_ID_REQUIRED("ORG_ID_REQUIRED"),
    PHONE_ALREADY_REGISTED("PHONE_ALREADY_REGISTED"),
    ORG_ID_ALREADY_REGISTED("ORG_ID_ALREADY_REGISTED"),
    USER_NAME_REQUIRED("USER_NAME_REQUIRED"),
    COUNTRY_ID_REQUIRED("COUNTRY_ID_REQUIRED"),
    PHONE_OR_EMAIL_REQUIRED("PHONE_OR_EMAIL_REQUIRED"),
    NAME_OR_SHORTNAME_REQUIRED("NAME_OR_SHORTNAME_REQUIRED"),

    PLANT_CODE_ALREADY_REGISTED("PLANT_CODE_ALREADY_REGISTED"),
    PLANT_NAME_ALREADY_REGISTED("PLANT_NAME_ALREADY_REGISTED"),

    REPORTNAME_ALREADY_REGISTED("REPORTNAME_ALREADY_REGISTED"),
    REPORTNAMEKEY_ALREADY_REGISTED("REPORTNAMEKEY_ALREADY_REGISTED"),
    JOB_DOES_NOT_EXIST("JOB_DOES_NOT_EXIST"),
    QRCODE_NOT_EXIST("QRCODE_NOT_EXIST"),
    PAGE_SIZE_INVALID("PAGE_SIZE_INVALID"),
    TEXT_POSITION_INVALID("TEXT_POSITION_INVALID"),
    IMAGE_WIDTH_INVALID("IMAGE_WIDTH_INVALID"),
    FORMAT_NOT_SUPPORT("FORMAT_NOT_SUPPORT"),
    SUPPLIES_ID_REQUIRED("SUPPLIES_ID_REQUIRED"),
    SUPPLIES_ID_INVALID("SUPPLIES_ID_INVALID"),
    SUPPLIES_TYPE_REQUIRED("SUPPLIES_TYPE_REQUIRED"),
    SUPPLIES_TYPE_INVALID("SUPPLIES_TYPE_INVALID"),
    USER_LOG_ID_REQUIRED("USER_LOG_ID_REQUIRED"),
    USER_LOG_ID_INVALID("USER_LOG_ID_INVALID"),
    LOG_DATE_REQUIRED("LOG_DATE_REQUIRED"),
    LOG_DATE_INVALID("LOG_DATE_INVALID"),
    EXPIRED_DATE_REQUIRED("EXPIRED_DATE_REQUIRED"),
    EXPIRED_DATE_INVALID("EXPIRED_DATE_INVALID"),
    PRODUCE_DATE_REQUIRED("PRODUCE_DATE_REQUIRED"),
    PRODUCE_DATE_INVALID("PRODUCE_DATE_INVALID"),
    PACK_TYPE_REQUIRED("PACK_TYPE_REQUIRED"),
    PACK_TYPE_INVALID("PACK_TYPE_INVALID"),
    UNIT_REQUIRED("UNIT_REQUIRED"),
    UNIT_INVALID("UNIT_INVALID"),
    CROP_ID_NOT_FOUND("CROP_ID_NOT_FOUND"),
    CROP_ASSIGN_YET("Mùa vụ chưa được gán mã body"),
    PROVIDER_ID_INVALID("PROVIDER_ID_INVALID"),
    PRODUCT_ID_INVALID("Product Id Invalid"),
    PRICE_TYPE_REQUIRED("PRICE_TYPE_REQUIRED"),
    PRICE_TYPE_INVALID("PRICE_TYPE_INVALID"),
    BAD_DATA("Dữ liệu không đồng nhất"),
    AUTHENTICATION_REQUEST_EXCEEDED("Yêu cầu xác thực vượt quá số lần cho phép"),
    INVALID_CREDENTIALS("Tên đăng nhập hoặc Mật khẩu không đúng"),
    INVALID_PRODUCT("Invalid product"),
    INVALID_PRODUCTCOMMENT("Invalid productcomment"),
    INVALID_IMAGE("Invalid image"),
    INVALID_STORE("Invalid store"),
    BLANK_IMAGE_PRODUCT("Not blank Image"),
    RECORD_EXISTS("Bản ghi đã tồn tại"),
    INTERNAL_SERVER_ERROR("Có lỗi đã xảy ra")
    ;

    private final String desc;

    ErrorCodesEnum(final String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }

}
