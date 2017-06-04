<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="teacher" id="current_nav">
<div id="teacherApp" ng-app="teacherApp">
	<div ng-controller="teacherController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Teacher管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addTeacher(teacher)">新增</span>
		    </span>
	
			<paging url="/web/a/teacher">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id主键自增</td>
			        				                    <td>排序</td>
			        				                    <td>图片</td>
			        				                    <td>类别</td>
			        				                    <td>状态</td>
			        				                    <td>标题</td>
			        				                    <td>内容</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="teacher in data">				
									                    <td ng-bind="teacher.id" ></td>
			        				                    <td ng-bind="teacher.order" ></td>
			        				                    <td ng-bind="teacher.img" ></td>
			        				                    <td ng-bind="teacher.category" ></td>
			        				                    <td ng-bind="teacher.status" ></td>
			        				                    <td ng-bind="teacher.title" ></td>
			        				                    <td ng-bind="teacher.content" ></td>
			        				                    <td ng-bind="teacher.createBy" ></td>
			        				                    <td ng-bind="teacher.updateBy" ></td>
			        				                    <td ng-bind="teacher.createAt" ></td>
			        				                    <td ng-bind="teacher.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateTeacher(teacher.id)" /> 
							<input type="button" value="删除" ng-click="deleteTeacher(teacher.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/teacher/teacherList.js"></script>
