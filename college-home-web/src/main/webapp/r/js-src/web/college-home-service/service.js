'use strict';
angular.module('college_home')

    .factory('pathProject', function (commonUtil) {
        return {
                	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                                   ,  
                        
          
         
         	     internship: function (id) {
                if (!id) {
                    return "ajax/u/internship";
                } else {
                    return "ajax/u/internship/" + id;
                }
            },
          internship_list: "ajax/u/internship/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('teacherService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.teacher(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.teacher(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.teacher_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.teacher(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.teacher(id));
            }
           
        }
    })
                
	    .factory('graduateService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.graduate(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.graduate(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.graduate_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.graduate(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.graduate(id));
            }
           
        }
    })
                
	    .factory('exchangeService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.exchange(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.exchange(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.exchange_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.exchange(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.exchange(id));
            }
           
        }
    })
                
	    .factory('activityService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.activity(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.activity(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.activity_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.activity(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.activity(id));
            }
           
        }
    })
                
	    .factory('admissionEmploymentService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.admissionEmployment(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.admissionEmployment(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.admissionEmployment_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.admissionEmployment(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.admissionEmployment(id));
            }
           
        }
    })
                
	    .factory('articleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.article(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.article(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.article_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.article(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.article(id));
            }
           
        }
    })
                
	    .factory('majorService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.major(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.major(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.major_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.major(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.major(id));
            }
           
        }
    })
                
	    .factory('internshipService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.internship(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.internship(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.internship_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.internship(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.internship(id));
            }
           
        }
    })
             
   
    ;






