package com.craft.livingcraft.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.craft.livingcraft.dao.SubCategoryDao;
import com.craft.livingcraft.model.SubCategory;
import com.google.gson.Gson;


public class SubCategoryDAOImpl implements SubCategoryDao
{
	@Autowired
	SessionFactory sessionFactory;

	public SubCategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addSubCategory(SubCategory subCategory) {
		sessionFactory.getCurrentSession().saveOrUpdate(subCategory);
		
	}
	
	public List<SubCategory> getSubCategoryList() {
		Session session=sessionFactory.getCurrentSession();
		String hql="from SubCategory";
		@SuppressWarnings("unchecked")
		List<SubCategory> sclist=session.createQuery(hql).getResultList();
		return sclist;
	}
    

	public SubCategory getSubCategoryById(int subCategoryId) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from SubCategory where subCategoryId="+subCategoryId;
		@SuppressWarnings("unchecked")
		List<SubCategory> sclist=session.createQuery(hql).getResultList();
		return sclist.get(0);
	}

	public void deleteSubCategory(int subCategoryId) {
		SubCategory subCategorytodelete=new SubCategory();
		subCategorytodelete.setSubCategoryId(subCategoryId);
		sessionFactory.getCurrentSession().delete(subCategorytodelete);
				
	}



	public SubCategory getSubCategoryByName(String subCategoryName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from SubCategory where subCategoryName="+"'"+subCategoryName+"'";
		@SuppressWarnings("unchecked")
		List<SubCategory> sclist = session.createQuery(hql).getResultList();
		return sclist.get(0);
	}

	public String getJsonList() {
		
		Session session=sessionFactory.getCurrentSession();
		String hql="from SubCategory";
		@SuppressWarnings("unchecked")
		List<SubCategory> sclist=session.createQuery(hql).getResultList();
		
		Gson gson=new Gson();
		String jsonList=gson.toJson(sclist);
		
		return jsonList;
		
		
	}

	


	

}
