package dao;


import config.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import models.Borrow;

public class BorrowDAO {

    @SuppressWarnings("unchecked")
	public List<Borrow> findAll(){
        EntityManager em = null;
        try{
            em = JPAUtil.getEntityManager();
            return em.createQuery("select b from Borrow b").getResultList();
        }finally{
            em.close();
        }
    }
    
    public boolean insertOne(Borrow b){// NEW
         EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             em.persist(b);// NEW STATE -> MANAGED STATE
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close(); // MANAGED STATE -> DETACHED STATE
         }
    }
    
    
    public boolean updateOne(Borrow b){  // DETACHED
        
        EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             em.merge(b);// DETACHED STATE -> MANAGED STATE
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close();// MANAGED STATE -> DETACHED STATE
         }
    }
    
    
    public boolean deleteOne(Borrow b){ // DETACHED
        
         EntityManager em = null;
         try{
             em = JPAUtil.getEntityManager();
             em.getTransaction().begin();
             Borrow managedBorrow = em.merge(b);
             em.remove(managedBorrow);
             em.getTransaction().commit();
             return true;
         }catch(Exception c){
             return false;
         }
         finally{
             em.close();
         }
    }
    @SuppressWarnings("unchecked")
	public List<Borrow> findBorrowedBooks() {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManager();
            return em.createQuery(
                "SELECT b FROM Borrow b WHERE b.status = false"
                
            ).getResultList();
        } finally {
            em.close();
        }
    }
    @SuppressWarnings("unchecked")
    public List<Borrow> searchByBookIdAndStudentId(int bookId, int studentId) {

        EntityManager em = null;

        try {
            em = JPAUtil.getEntityManager();

            String jpql =
                "SELECT b FROM Borrow b WHERE b.book.bookId = "
                + bookId +
                " AND b.student.studentId = "
                + studentId;

            return em.createQuery(jpql).getResultList();

        } finally {
            em.close();
        }
    }
  }