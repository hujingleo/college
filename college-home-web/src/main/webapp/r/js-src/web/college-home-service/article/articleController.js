'use strict';
angular.module('college_home')
    .controller('articleCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, articleService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     order: $state.params.order
	                              ,  
                     	     img: $state.params.img
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     title: $state.params.title
	                              ,  
                     	     content: $state.params.content
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                         };


    articleService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.articleList", vm.params,{reload:true});
    };
    });
