//package com.web.util;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.NoResultException;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//
//import com.web.dao.CommentDao;
//import com.web.dao.PostDao;
//import com.web.dao.UserDao;
//import com.web.model.Comment;
//import com.web.model.Post;
//import com.web.model.User;
//
//public class TestSystem {
//	
////	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("Project2");
//	
//
//	public static void main(String[] args) {
//		UserDao ud = new UserDao();
//		User u = new User("batman", "justice", "batman@jleague.com", "bruce", "wayne", "1234567899", 
//			"superhero", "I love justice", "123 Wayne Manor", LocalDate.of(1966, 06, 23), null);
//		Post p = new Post(0, "batman", "Hello World", "I'm batman");
//		Comment c = new Comment(0, 0, "batman", "Hey Everybody, I'm Batman");
//		PostDao pd = new PostDao();
//		CommentDao cd = new CommentDao();
//		ud.save(u);
//		pd.save(p);
//		cd.save(c);
//		System.out.println(ud.findById("bruce"));
//		
//		
//	}
		
		
//		addUser("batman", "justice", "batman@jleague.com", "bruce", "wayne", "1234567899", 
//				"superhero", "I love justice", "123 Wayne Manor", LocalDate.of(1966, 06, 23));
//		addUser("superman", "password", "superman@jleague.com", "clark", "kent", "0987654321", 
//				"crime fighting", "I love flying", "543 Oklahoma Ave", LocalDate.of(1970, 10, 15));
//		addUser("aquaman", "fish", "aquaman@jleague.com", "arthur", "curry", "1029384756", 
//				"hero", "swimming is great", "atlantis", LocalDate.of(1972, 02, 14));
//		getUser("batman");
//		getUsers();
		
		
//		ENTITY_MANAGER_FACTORY.close();
	//}
	
//	public static void addUser(String username, String password, String email, String firstname,
//									String lastname, String phoneNumber, String occupation, String bio,
//									String address, LocalDate dob) {
//		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//		EntityTransaction et = null;
//		try {
//			et = em.getTransaction();
//			et.begin();
//			User user = new User();
//			user.setUsername(username);
//			user.setPassword(password);
//			user.setEmail(email);
//			user.setFirstname(firstname);
//			user.setLastname(lastname);
//			user.setPhoneNumber(phoneNumber);
//			user.setOccupation(occupation);
//			user.setBio(bio);
//			user.setAddress(address);
//			user.setDob(dob);
//			em.persist(user);
//			et.commit();
//		} catch(Exception ex) {
//			if(et != null) {
//				et.rollback();
//			} ex.printStackTrace();
//		} finally {
//			em.close();
//		}
//		
//	}
//	
//	public static void getUser(String username) {
//		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();  
//		String query = "SELECT u FROM User u WHERE u.username = :username";
//		
//		TypedQuery<User> tq = em.createQuery(query, User.class);
//		tq.setParameter("username", username);
//		User user = null;
//		try {
//			user = tq.getSingleResult();
//			System.out.println(user.getFirstname() + " " + user.getFirstname());
//		} catch(NoResultException ex) {
//			ex.printStackTrace();
//		} finally {
//			em.close();
//		}
//	}
//	
//	public static void getUsers() {
//		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();  
//		String query1 = "SELECT u FROM User u WHERE u.username IS NOT NULL";
//		TypedQuery<User> tq = em.createQuery(query1, User.class);
//		List<User> users;
//		try {
//			users = tq.getResultList();
//			users.forEach(user->System.out.println(user.getFirstname() + " " + user.getLastname()));
//		} catch(NoResultException ex) {
//			ex.printStackTrace();
//		} finally {
//			em.close();
//		}
//	}
//		
//		public static void deleteUser(String username) {
//			EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
//			EntityTransaction et = null;
//			User user = null;
//			try {
//				et = em.getTransaction();
//				et.begin();
//				user = em.find(User.class, username);
//				em.remove(user);
//				em.persist(user);
//				et.commit();
//			} catch(Exception ex) {
//				if(et != null) {
//					et.rollback();
//			} ex.printStackTrace();
//				} finally {
//					em.close();
//			}
//	}
//}
