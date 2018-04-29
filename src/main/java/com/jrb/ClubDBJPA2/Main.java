package com.jrb.ClubDBJPA2;

import java.util.List;

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
		
		List<Member> members = dao.getMembers();
		
		System.out.println("\n Members");
		for (Member x : members) {
			System.out.println(x.toString());
		}
		
		Member m = members.get(0);
		System.out.println("\n Changing status of " + m.getMemid() + " " + m.getStatus());
		m.setStatus("T");
		dao.update(m);
		System.out.println("change complete");
		

    }
}
