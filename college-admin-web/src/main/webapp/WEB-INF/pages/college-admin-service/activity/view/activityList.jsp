<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="activity" id="current_nav">
<div id="activityApp" ng-app="activityApp">
	<div ng-controller="activityController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Activity管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addActivity(activity)">新增</span>
		    </span>
	
			<paging url="/web/a/activity">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id主键自增</td>
			        				                    <td>图片</td>
			        				                    <td>状态</td>
			        				                    <td>标题</td>
			        				                    <td>内容</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="activity in data">				
									                    <td ng-bind="activity.id" ></td>
			        				                    <td ng-bind="activity.img" ></td>
			        				                    <td ng-bind="activity.status" ></td>
			        				                    <td ng-bind="activity.title" ></td>
			        				                    <td ng-bind="activity.content" ></td>
			        				                    <td ng-bind="activity.createBy" ></td>
			        				                    <td ng-bind="activity.updateBy" ></td>
			        				                    <td ng-bind="activity.createAt" ></td>
			        				                    <td ng-bind="activity.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateActivity(activity.id)" /> 
							<input type="button" value="删除" ng-click="deleteActivity(activity.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/activity/activityList.js"></script>
