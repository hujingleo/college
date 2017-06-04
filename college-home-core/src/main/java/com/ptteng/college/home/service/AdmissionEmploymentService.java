package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.AdmissionEmployment;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface AdmissionEmploymentService extends BaseDaoService {

	



   		   
		
		public Long insert(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AdmissionEmployment> insertList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AdmissionEmployment admissionEmployment)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AdmissionEmployment> admissionEmploymentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AdmissionEmployment getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AdmissionEmployment> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAdmissionEmploymentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAdmissionEmploymentIds() throws ServiceException, ServiceDaoException;
	

}

