package com.jrb;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClubJPAConfig.class);

		MemberDaoImpl dao = applicationContext.getBean(MemberDaoImpl.class);

		PurchaseDaoImpl purchaseDao = applicationContext.getBean(PurchaseDaoImpl.class);

		List<Member> members = dao.getMembers();

		System.out.println("\n Members");
		for (Member x : members) {
			System.out.println(x.toString());
			System.out.println("\n Purchases for '" + x.getMemid() + "'");
			for (Purchase p : x.getPurchases()) {
				System.out.println(p.toString());
			}
		}

		Member newMember = new Member();
		newMember.setMemid("A123");
		newMember.setFirstname("Steve");
		newMember.setLastname("Stevenson");
		newMember.setMiddlename("S");
		newMember.setMemdt(new Date());
		dao.save(newMember);
		System.out.println("New Member Saved");
		
		 Purchase p = new Purchase();
		 p.seteMemid("A123");
		 p.setPurchdt(new Date());
		 p.setTranstype("D");
		 p.setTranscd("01");
		 p.setAmt(100.00);
		 purchaseDao.save(p);
		 System.out.println("Member Dues Recorded");
		
		 Purchase p2 = new Purchase();
		 p2.seteMemid("A123");
		 p2.setPurchdt(new Date());
		 p2.setTranstype("D");
		 p2.setTranscd("21");
		 p2.setAmt(55.00);
		 purchaseDao.save(p2);
		 System.out.println("Food Purchase Recorded");
		
		 Purchase p3 = new Purchase();
		 p3.seteMemid("A123");
		 p3.setPurchdt(new Date());
		 p3.setTranstype("D");
		 p3.setTranscd("22");
		 p3.setAmt(25.00);
		 purchaseDao.save(p3);
		 System.out.println("Drink Purchase Recorded");

		Member m = members.get(0);
		System.out.println("\nChanging status of " + m.getMemid() + " " + m.getStatus());
		m.setStatus("T");
		dao.update(m);
		System.out.println("change complete");
	}
}
