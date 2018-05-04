package com.jrb.ClubDBJPA2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jrb.ClubDBJPA2.ClubJPAConfig;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ClubJPAConfig.class);

		MemberDaoImpl dao = applicationContext.getBean(MemberDaoImpl.class);
		
		PurchaseDaoImpl purchaseDao = applicationContext.getBean(PurchaseDaoImpl.class);
		
		List<Member> members = dao.getMembers();
		
		System.out.println("\n Members");
		for (Member x : members) {
			System.out.println(x.toString());
			System.out.println("\n Purchases for '"+ x.getMemid() +"'");
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
		
		Purchase newPurchase = new Purchase();
		newPurchase.setAmt(25.00);
		newPurchase.seteMemid("A123");
		newPurchase.setPurchdt(new Date());
		newPurchase.setTranstype("D");
		newPurchase.setTranscd("TK");
		purchaseDao.save(newPurchase);
		System.out.println("New Purchase Recorded");
		
		Purchase secondPurchase = new Purchase();
		secondPurchase.setAmt(55.00);
		secondPurchase.seteMemid("A123");
		secondPurchase.setPurchdt(new Date());
		secondPurchase.setTranstype("D");
		newPurchase.setTranscd("TK");
		purchaseDao.save(secondPurchase);
		System.out.println("A Secibd Purchase Recorded");

		Member m = members.get(0);
		System.out.println("\n Changing status of " + m.getMemid() + " " + m.getStatus());
		m.setStatus("T");
		dao.update(m);
		System.out.println("change complete");
		

    }
}
