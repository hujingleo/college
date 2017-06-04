<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="major" id="current_nav">
<div id="majorApp" ng-app="majorApp">
	<div ng-controller="majorController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Major管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addMajor(major)">新增</span>
		    </span>
	
			<paging url="/web/a/major">
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
					<tr ng-repeat="major in data">				
									                    <td ng-bind="major.id" ></td>
			        				                    <td ng-bind="major.img" ></td>
			        				                    <td ng-bind="major.title" ></td>
			        				                    <td ng-bind="major.content" ></td>
			        				                    <td ng-bind="major.createBy" ></td>
			        				                    <td ng-bind="major.updateBy" ></td>
			        				                    <td ng-bind="major.createAt" ></td>
			        				                    <td ng-bind="major.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateMajor(major.id)" /> 
							<input type="button" value="删除" ng-click="deleteMajor(major.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/major/majorList.js"></script>
