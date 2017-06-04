package com.ptteng.sca.college.home.client;

import java.util.List;
import java.util.Map;

import com.ptteng.college.home.model.Teacher;
import com.ptteng.college.home.service.TeacherService;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;

public class TeacherSCAClient implements TeacherService {

    private TeacherService teacherService;

	public TeacherService getTeacherService() {
		return teacherService;
	}
	
	
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService =teacherService;
	}
	
	
			   
		@Override
		public Long insert(Teacher teacher)throws ServiceException, ServiceDaoException{
		
		return teacherService.insert(teacher);
		          
		
		}	
		  
    	   
		@Override
		public List<Teacher> insertList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException{
		
		return teacherService.insertList(teacherList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return teacherService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Teacher teacher)throws ServiceException, ServiceDaoException{
		
		return teacherService.update(teacher);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Teacher> teacherList)throws ServiceException, ServiceDaoException{
		
		return teacherService.updateList(teacherList);
		          
		
		}	
		  
    	   
		@Override
		public Teacher getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return teacherService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Teacher> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return teacherService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getTeacherIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teacherService.getTeacherIds(start, limit);
	}

	@Override
	public Integer countTeacherIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teacherService.countTeacherIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teacherService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return teacherService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   teacherService.deleteList(clz, ids);
		
	}
	
	//@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		return null;
		//return this.teacherService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

