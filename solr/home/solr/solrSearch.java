package solr;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import solr.indexbuilder;
import solr.solrHandle;


public class solrSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public solrSearch() {
        super();
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String queryStr=request.getParameter("queryStr");
		 System.out.println(queryStr);
		 
		 try {
			indexbuilder.buildIndex();
			SolrDocumentList docs=solrHandle.solrHandleQuery(queryStr);
			int i=-1;  
			for (SolrDocument doc : docs) {  
		            for (String fieldName : doc.getFieldNames()) { 
		   	
		                System.out.println(fieldName + " : " + doc.getFieldValue(fieldName) + "  ");  
		            }  
		            i++;            
		            System.out.println("------------------------Next Document--------------------------------");  
		        }
			request.setAttribute("docList",docs);
			request.setAttribute("num",i);
			request.getRequestDispatcher("/result.jsp").forward(request, response);
			
		} catch (SQLException e1) {
			System.out.println("solrSearch has a sql problem.");
			e1.printStackTrace();
		} catch (SolrServerException e1) {
			System.out.println("solrSearch has a solr problem.");
			e1.printStackTrace();
		}
	
	}


}
