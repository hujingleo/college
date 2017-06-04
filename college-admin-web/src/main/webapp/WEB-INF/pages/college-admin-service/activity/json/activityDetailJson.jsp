<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${activity.id}"></json:property>


        <json:property name="author" value="${activity.author}"></json:property>


        <json:property name="img" value="${activity.img}"></json:property>


        <json:property name="status" value="${activity.status}"></json:property>


        <json:property name="title" value="${activity.title}"></json:property>


        <json:property name="content" value="${activity.content}"></json:property>


        <json:property name="createBy" value="${activity.createBy}"></json:property>


        <json:property name="updateBy" value="${activity.updateBy}"></json:property>


        <json:property name="createAt" value="${activity.createAt}"></json:property>


        <json:property name="updateAt" value="${activity.updateAt}"></json:property>


    </json:object>

</json:object>


