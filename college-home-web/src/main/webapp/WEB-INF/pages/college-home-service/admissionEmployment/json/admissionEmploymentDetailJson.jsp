<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${admissionEmployment.id}"></json:property>

        <json:property name="author" value="${admissionEmployment.author}"></json:property>


        <json:property name="category" value="${admissionEmployment.category}"></json:property>


        <json:property name="status" value="${admissionEmployment.status}"></json:property>


        <json:property name="title" value="${admissionEmployment.title}"></json:property>


        <json:property name="content" value="${admissionEmployment.content}"></json:property>


        <json:property name="createBy" value="${admissionEmployment.createBy}"></json:property>


        <json:property name="updateBy" value="${admissionEmployment.updateBy}"></json:property>


        <json:property name="createAt" value="${admissionEmployment.createAt}"></json:property>


        <json:property name="updateAt" value="${admissionEmployment.updateAt}"></json:property>


    </json:object>

</json:object>


