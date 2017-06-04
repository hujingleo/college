<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:object name="data">


        <json:property name="id" value="${exchange.id}"></json:property>


        <json:property name="author" value="${exchange.author}"></json:property>


        <json:property name="img" value="${exchange.img}"></json:property>


        <json:property name="status" value="${exchange.status}"></json:property>


        <json:property name="title" value="${exchange.title}"></json:property>


        <json:property name="content" value="${exchange.content}"></json:property>


        <json:property name="createBy" value="${exchange.createBy}"></json:property>


        <json:property name="updateBy" value="${exchange.updateBy}"></json:property>


        <json:property name="createAt" value="${exchange.createAt}"></json:property>


        <json:property name="updateAt" value="${exchange.updateAt}"></json:property>


    </json:object>

</json:object>


