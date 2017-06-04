<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="internship" id="current_nav">
<div id="internshipApp" ng-app="internshipApp">
	<div ng-controller="internshipController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Internship管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addInternship(internship)">新增</span>
		    </span>
	
			<paging url="/web/a/internship">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id主键自增</td>
			        				                    <td>图片</td>
			        				                    <td>标题</td>
			        				                    <td>内容</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="internship in data">				
									                    <td ng-bind="internship.id" ></td>
			        				                    <td ng-bind="internship.img" ></td>
			        				                    <td ng-bind="internship.title" ></td>
			        				                    <td ng-bind="internship.content" ></td>
			        				                    <td ng-bind="internship.createBy" ></td>
			        				                    <td ng-bind="internship.updateBy" ></td>
			        				                    <td ng-bind="internship.createAt" ></td>
			        				                    <td ng-bind="internship.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateInternship(internship.id)" /> 
							<input type="button" value="删除" ng-click="deleteInternship(internship.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/internship/internshipList.js"></script>
