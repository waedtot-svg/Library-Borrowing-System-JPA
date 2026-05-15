
package dao;


import config.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import models.Book;

public class BookDAO {
   
    
	public List<Integer> getAllbooksids() {
	    EntityManager em = null;

	    try {
	        em = JPAUtil.getEntityManager();

	        return em.createQuery(
	                "select b.bookId from Book b",
	                Integer.class
	        ).getResultList();

	    } catch (Exception e) {
	        e.printStackTrace();
	        return java.util.Collections.emptyList();

	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}
    
    
    public Book findById(int book_id){
        EntityManager em=null;
        try{
            em = JPAUtil.getEntityManager();
            Book b = em.find(Book.class, book_id);
            return b;
        }finally{
            em.close();
        }
    }
    
    
   
    
}
