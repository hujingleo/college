<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${internship.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="img" value="${internship.img}"></json:property>
           
           
	   
                    			
               
                    <json:property name="title" value="${internship.title}"></json:property>
           
           
	   
                    			
               
                    <json:property name="content" value="${internship.content}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${internship.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${internship.updateBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${internship.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${internship.updateAt}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


