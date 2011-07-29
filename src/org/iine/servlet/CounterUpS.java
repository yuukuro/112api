package org.iine.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class CounterUpS  extends HttpServlet{
	private static final long serialVersionUID = -8719147329307442677L;
	private static DatastoreService ds = 
		DatastoreServiceFactory.getDatastoreService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long id = 1;
		
		String i = req.getParameter("i");
		
		try {
			id = Long.parseLong(i);
		} catch (Exception e) {
			return;
		}
		Entity entity = new Entity("PUSH" + id);
		ds.put(entity);
	}

	
	
}
