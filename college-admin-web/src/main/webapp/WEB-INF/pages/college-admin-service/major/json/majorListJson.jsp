<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${majorList}" var="major">
			<json:object>
					
               
                    <json:property name="id" value="${major.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="img" value="${major.img}"></json:property>
           
           
	   
        			
               
                    <json:property name="title" value="${major.title}"></json:property>
           
           
	   
        			
               
                    <json:property name="content" value="${major.content}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${major.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${major.updateBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${major.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${major.updateAt}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


