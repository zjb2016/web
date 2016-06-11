package solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class solrHandle {
	public static  SolrDocumentList solrHandleQuery(String query) throws SolrServerException {
		//连接solr
	     String serverUrl = "http://localhost:8983/solr/jane";
	     SolrServer solrServer = new HttpSolrServer(serverUrl);  
	  
	   // 读取输入参数作为查询关键字，若无关键字，则查询全部内容。  
	       SolrQuery solrQuery = new SolrQuery();
	       if(query==null){solrQuery.setQuery("*:*");  }
	       else{
	               String str="pinpai:"+query;
	               solrQuery.setQuery(str);  }
	       solrQuery.setHighlight(true);
	      
	        QueryResponse resp = solrServer.query(solrQuery);
	        SolrDocumentList docs = resp.getResults(); 
	        	        
	      
			return docs;
	}
}
