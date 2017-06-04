<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="graduate" id="current_nav">
<div id="graduateApp" ng-app="graduateApp">
	<div ng-controller="graduateController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Graduate管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addGraduate(graduate)">新增</span>
		    </span>
	
			<paging url="/web/a/graduate">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>id主键自增</td>
			        				                    <td>排序</td>
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
					<tr ng-repeat="graduate in data">				
									                    <td ng-bind="graduate.id" ></td>
			        				                    <td ng-bind="graduate.order" ></td>
			        				                    <td ng-bind="graduate.img" ></td>
			        				                    <td ng-bind="graduate.status" ></td>
			        				                    <td ng-bind="graduate.title" ></td>
			        				                    <td ng-bind="graduate.content" ></td>
			        				                    <td ng-bind="graduate.createBy" ></td>
			        				                    <td ng-bind="graduate.updateBy" ></td>
			        				                    <td ng-bind="graduate.createAt" ></td>
			        				                    <td ng-bind="graduate.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateGraduate(graduate.id)" /> 
							<input type="button" value="删除" ng-click="deleteGraduate(graduate.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/graduate/graduateList.js"></script>
