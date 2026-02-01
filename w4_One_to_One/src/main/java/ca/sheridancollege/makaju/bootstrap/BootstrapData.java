package ca.sheridancollege.makaju.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Account;
import ca.sheridancollege.makaju.beans.AccountStatus;
import ca.sheridancollege.makaju.beans.Student;
import ca.sheridancollege.makaju.repositories.AccountRepository;
import ca.sheridancollege.makaju.repositories.StudentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {

	
	private StudentRepository stuRepo;
	private AccountRepository accRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student s1= new Student(0l,"Ron",null);//one way of making student	
		//another
//		Student s2= new Student();
//		s2.setName("Ish");
//		
		Student s2= Student.builder().id(0l).name("Pri").build();
//		one way of making student	
		
		Account a1=Account.builder()
					      .accountNumber(123)
						  .balance(new BigDecimal(12345.56))
						  .status(AccountStatus.UNDER_REVIEW)
						  .build();
		Account a2=new Account(0l,124,new BigDecimal(9999.56),AccountStatus.APPROVED,null,null);
		//Account a3=new Account(0l,127,new BigDecimal(888.56));
		
		//stuRepo.save(s1);
//		stuRepo.save(s2);
		accRepo.save(a1);
		accRepo.save(a2);
		stuRepo.save(s1);
		stuRepo.save(s2);
		s1.setAccount(a1);
		s2.setAccount(a2);
		stuRepo.save(s1);
		stuRepo.save(s2);
		
		
		
//		accRepo.save(a2);
//		accRepo.save(a3);
	}

}
