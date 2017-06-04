<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${graduate.id}"></json:property>


        <json:property name="author" value="${graduate.author}"></json:property>

        <json:property name="rank" value="${graduate.rank}"></json:property>


        <json:property name="img" value="${graduate.img}"></json:property>


        <json:property name="status" value="${graduate.status}"></json:property>


        <json:property name="title" value="${graduate.title}"></json:property>


        <json:property name="content" value="${graduate.content}"></json:property>


        <json:property name="createBy" value="${graduate.createBy}"></json:property>


        <json:property name="updateBy" value="${graduate.updateBy}"></json:property>


        <json:property name="createAt" value="${graduate.createAt}"></json:property>


        <json:property name="updateAt" value="${graduate.updateAt}"></json:property>


    </json:object>

</json:object>


