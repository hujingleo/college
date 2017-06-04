<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="exchange" id="current_nav">
<div id="exchangeApp" ng-app="exchangeApp">
	<div ng-controller="exchangeController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Exchange管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addExchange(exchange)">新增</span>
		    </span>
	
			<paging url="/web/a/exchange">
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
					<tr ng-repeat="exchange in data">				
									                    <td ng-bind="exchange.id" ></td>
			        				                    <td ng-bind="exchange.img" ></td>
			        				                    <td ng-bind="exchange.status" ></td>
			        				                    <td ng-bind="exchange.title" ></td>
			        				                    <td ng-bind="exchange.content" ></td>
			        				                    <td ng-bind="exchange.createBy" ></td>
			        				                    <td ng-bind="exchange.updateBy" ></td>
			        				                    <td ng-bind="exchange.createAt" ></td>
			        				                    <td ng-bind="exchange.updateAt" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateExchange(exchange.id)" /> 
							<input type="button" value="删除" ng-click="deleteExchange(exchange.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/college-home-service/exchange/exchangeList.js"></script>
