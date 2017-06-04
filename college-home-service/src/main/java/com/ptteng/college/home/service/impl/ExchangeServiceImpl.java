package com.ptteng.college.home.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.college.home.model.Exchange;
import com.ptteng.college.home.service.ExchangeService;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ExchangeServiceImpl extends BaseDaoServiceImpl implements ExchangeService {

 

	private static final Log log = LogFactory.getLog(ExchangeServiceImpl.class);



		   
		@Override
		public Long insert(Exchange exchange)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + exchange);

		if (exchange == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		exchange.setCreateAt(currentTimeMillis);
		exchange.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(exchange);
		} catch (DaoException e) {
			log.error(" insert wrong : " + exchange);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Exchange> insertList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (exchangeList == null ? "null" : exchangeList.size()));
      
		List<Exchange> resultList = null;

		if (CollectionUtils.isEmpty(exchangeList)) {
			return new ArrayList<Exchange>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Exchange exchange : exchangeList) {
			exchange.setCreateAt(currentTimeMillis);
			exchange.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Exchange>) dao.batchSave(exchangeList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + exchangeList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(Exchange.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(Exchange exchange)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (exchange == null ? "null" : exchange.getId()));

		boolean result = false;

		if (exchange == null) {
			return true;
		}

		exchange.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(exchange);
		} catch (DaoException e) {
			log.error(" update wrong : " + exchange);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + exchange);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Exchange> exchangeList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (exchangeList == null ? "null" : exchangeList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(exchangeList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Exchange exchange : exchangeList) {
			exchange.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(exchangeList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + exchangeList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + exchangeList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Exchange getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Exchange exchange = null;

		if (id == null) {
			return exchange;
		}

		try {
			exchange = (Exchange) dao.get(Exchange.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return exchange;		
		}	
		  
    	   
		@Override
		public List<Exchange> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Exchange> exchange = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Exchange>();
		}

		try {
			exchange = (List<Exchange>) dao.getList(Exchange.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (exchange == null ? "null" : exchange.size()));
    
		return exchange;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getExchangeIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getExchangeIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countExchangeIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getExchangeIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getExchangeIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

