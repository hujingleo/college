package com.ptteng.college.home.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.college.home.model.Exchange;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ExchangeService extends BaseDaoService {

	



   		   
		
		public Long insert(Exchange exchange)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Exchange> insertList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Exchange exchange)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Exchange getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Exchange> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getExchangeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countExchangeIds() throws ServiceException, ServiceDaoException;
	

}

