package com.feitian.study.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public enum ResponseCode {

    // 1-1000 成功
    SUCCESS("成功",200),
    // SUCCESS("成功", 1),
    SUCCESS_REMOVE_ONE_TUSER_BY_ID("删除用户成功", 1),
    SUCCESS_REMOVE_BATCH_TUSER_BY_IDS("批量删除用户成功", 1),
    SUCCESS_SAVE_ONE_TUSER("保存成功", 1),
    SUCCESS_SELECT_ALL_TUSER("查询成功", 1),
    SUCCESS_SELECT_ALL_TEACHER("查询教师列表成功", 1),
    SUCCESS_SELECT_ONE_TEACHER("查询教师成功", 1),
    SUCCESS_UPDATE_TEACHER_BY_ID("更新成功", 1),
    SUCCESS_REMOVE_BATCH_TEACHER_BY_IDS("批量删除教师成功", 1),
    SUCCESS_SAVE_ONE_TEACHER("保存教师成功", 1),
    SUCCESS_REMOVE_ONE_TTEACHER_BY_ID("删除教师成功", 1),
    SUCCESS_SELECT_ALL_TDEPT("查询部门成功", 1),
    SUCCESS_SELECT_ALL_SUBJECT("查询学科成功", 1),
    SUCCESS_REMOVE_ONE_TSUBJECT_BY_ID("删除学科成功", 1),
    SUCCESS_SELECT_ONE_SUBJECT("条件查询学科列表成功", 1),
    SUCCESS_SAVE_ONE_TSUBJECT("保存学科成功", 1),

    // 1001-2000 失败
    FAILED("请求失败", 1001),
    FAILED_NOT_FOUND_URL("请求资源不存在", 1002),
    FAILED_NOT_FOUND_ALLTUSER("查不到所有的用户", 1003),
    FAILED_NOT_FOUND_ENTITY("查不到实体", 1004),
    FAILED_NOT_FOUND_ENTITY_LIST("查不到实体列表", 1004),
    FAILED_REMOVE_BATCH_TUSER_BY_ID("根据ID批量删除TUser表中的用户失败", 1005),
    FAILED_NOT_FOUND_TUSER("查不到此用户", 1006),
    FAILED_NOT_FOUND_ALLTTEACHER("查不到所有的老师", 1007),
    FAILED_UPDATE_TEACHER_BY_ID("根据ID更新老师失败", 1008),
    FAILED_REMOVE_BATCH_TEACHER_BY_ID("根据ID批量删除TTeacher表中的用户失败", 1009),
    FAILED_NOT_FOUND_ALLTDEPT("查找不到所有的部门", 1010),
    FAILED_NOT_FOUND_TTEACHER_BY_NAME("查无此人", 1011),
    FAILED_NOT_FOUND_ALLTSUBJECT("查找不到所有的学科", 1012),
    FAILED_NOT_FOUND_TSUBJECT_BY_NAME("查无此学科", 1013),
    FOUND_SAVE_ONE_TSUBJECT("保存学科失败", 1014),
    FAILED_NOT_FOUND_ALLTTHESIS("查找不到所有的课题", 1015),
    FAILED_NOT_DELETE_ONE_NOTICE("删除单个公告失败", 1016), FAILED_NOT_UPDATE_ONE_NOTICE("更新失败", 1017),
    // 2001-3000 错误
    ERROR("请求错误", 2001),
    ERROR_SQLFeatureNotSupportedException_NULL("实体类映射错误", 2002),
    ERROR_TUSER_ID_IS_NULL("用户ID为空", 2003),
    ERROR_TUSER_PASSWORD_NULL("用户密码为空", 2004),
    ERROR_TUSER_USERNAME_NULL("用户名为空", 2005),
    ERROR_TUSER_ROLE_NULL("用户角色为空", 2006),
    ERROR_REMOVE_ONE_TUSER_BY_ID("根据ID删除TUser表中的用户失败", 2007),
    ERROR_TUSERVO_IS_NULL("TUserVO为空", 2008),
    ERROR_SAVE_ONE_TUSER("保存用户失败", 2009),
    ERROR_TUSERVO_ID_LIST_IS_NULL("TUserVO ID列表为空", 2010),
    ERROR_TTEACHER_ID_IS_NULL("教师ID为空", 2011),
    ERROR_TTEACHER_IS_NULL("教师为空", 2012),
    ERROR_TEACHERVO_IS_NULL("教师VO为空", 2013),
    ERROR_TEACHERVO_ID_LIST_IS_NULL("教师VO ID列表为空", 2014),
    ERROR_SAVE_ONE_TTEACHER("保存教师失败", 2015),
    ERROR_REMOVE_ONE_TTEACHER_BY_ID("根据ID删除教师失败", 2016),
    ERROR_TTEACHER_NAME_IS_NULL("教师姓名为空", 2017),
    ERROR_FILEUPLOAD_IS_NULL("文件上传为空", 2018),
    ERROR_FILEUPLOAD_IS_NOT_EXIST("文件上传不存在", 2019),
    ERROR_FILEUPLOAD_EXCEPTION("文件上传失败", 2020),
    ERROR_FILEDOWNLOAD_IS_NULL("文件导出为空", 2021),
    ERROR_FILEDOWNLOAD_EXCEPTION("文件下载失败", 2022),
    ERROR_TSUBJECT_ID_IS_NULL("学科ID为空", 2023),
    ERROR_REMOVE_ONE_TSUBJECT_BY_ID("根据ID删除学科失败", 2024),
    ERROR_TSUBJECT_NAME_IS_NULL("学科名称为空", 2025),
    ERROR_TSUBJECTVO_IS_NULL("学科VO为空", 2026),
    ERROR_DEPT_NAME_IS_NULL("部门名称为空", 2027),
    ERROR_TDEPT_ID_NULL("部门编号为空", 2028),
    ERROR_TDEPTVO_IS_NULL("部门信息为空", 2029),
    ERROR_THESOSVO_IS_NULL("课题VO为空", 2030),
    ERROR_THESIS_IS_NULL("课题信息为空", 2031),
    ERROR_TUSER_PASSWORD("用户密码错误", 2032),
    ERROR_USERNAME_IS_NULL("用户名为空", 2033),
    ERROR_PASSWORD_IS_NULL("用户密码为空", 2034),
    ERROR_LOGIN_AUTH_ERROR("登陆失败", 2035),
    ERROR_TOKEN_IS_NULL("Token为空", 2036),
    ERROR_TNOTICE_NAME_IS_NULL("公告名称为空", 2036),
    ERROR_TNOTICE_ID_IS_NULL("公告ID为空", 2037),
    ERROR_TNOTICEVO_IS_NULL("公告信息为空", 2038);


    private String message;
    private Integer code;


}
