package masterSpringMvc.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import date.PastLocalDate;

public class ProfileModel {
	@Size(min = 2)
	private String twitterHandle;
	
	@Email
	@NotEmpty
	private String email;
	
	@PastLocalDate
	@NotNull
	private LocalDate birthDate;
	
	@NotEmpty
	private List<String> tastes = new ArrayList<String>();
	
	//getters and setters
	public String getTwitterHandle() {
		return twitterHandle;
	}
	
	public String getEmail() {
		return email;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public List<String> getTastes() {
		return tastes;
	}
	
	public void setTwitterHandle(String th) {
		this.twitterHandle = th;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setBirthDate(LocalDate date) {
		this.birthDate = date;
	}
	
	public void setTastes(List<String> tastes) {
		this.tastes = tastes;
	}
	
	public synchronized void addTastes(String taste) {
		this.tastes.add(taste);
	}
}


