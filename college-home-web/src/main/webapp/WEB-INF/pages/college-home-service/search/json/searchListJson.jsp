<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../includes/includes.jsp" %>
<%@page contentType="text/html;charset=utf-8" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="size" value="${size}"></json:property>
    <json:property name="total" value="${total}"></json:property>
    <json:array name="teacher">
        <c:forEach items="${teacherList}" var="teacher">
            <json:object>
                <json:property name="id" value="${teacher.id}"></json:property>
                <json:property name="title" value="${teacher.title}"></json:property>
                <json:property name="content" value="${teacher.content}"></json:property>
                <json:property name="updateAt" value="${teacher.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="exchange">
        <c:forEach items="${exchangeList}" var="exchange">
            <json:object>
                <json:property name="id" value="${exchange.id}"></json:property>
                <json:property name="title" value="${exchange.title}"></json:property>
                <json:property name="content" value="${exchange.content}"></json:property>
                <json:property name="updateAt" value="${exchange.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="graduate">
        <c:forEach items="${graduateList}" var="graduate">
            <json:object>
                <json:property name="id" value="${graduate.id}"></json:property>
                <json:property name="title" value="${graduate.title}"></json:property>
                <json:property name="content" value="${graduate.content}"></json:property>
                <json:property name="updateAt" value="${graduate.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="internship">
        <c:forEach items="${internshipList}" var="internship">
            <json:object>
                <json:property name="id" value="${internship.id}"></json:property>
                <json:property name="title" value="${internship.title}"></json:property>
                <json:property name="content" value="${internship.content}"></json:property>
                <json:property name="updateAt" value="${internship.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="major">
        <c:forEach items="${majorList}" var="major">
            <json:object>
                <json:property name="id" value="${major.id}"></json:property>
                <json:property name="title" value="${major.title}"></json:property>
                <json:property name="content" value="${major.content}"></json:property>
                <json:property name="updateAt" value="${major.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="admissionEmployment">
        <c:forEach items="${admissionEmploymentList}" var="admissionEmployment">
            <json:object>
                <json:property name="id" value="${admissionEmployment.id}"></json:property>
                <json:property name="title" value="${admissionEmployment.title}"></json:property>
                <json:property name="content" value="${admissionEmployment.content}"></json:property>
                <json:property name="updateAt" value="${admissionEmployment.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <json:array name="activity">
        <c:forEach items="${activityList}" var="activity">
            <json:object>
                <json:property name="id" value="${activity.id}"></json:property>
                <json:property name="title" value="${activity.title}"></json:property>
                <json:property name="content" value="${activity.content}"></json:property>
                <json:property name="updateAt" value="${activity.updateAt}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>


