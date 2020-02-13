package com.strikers.elitematrimony.dto;


<<<<<<< HEAD
import java.io.Serializable;
import java.time.LocalDate;

=======
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

>>>>>>> 18d3f6fae31d5561d86235b0f6a6c6034ff72299
import com.strikers.elitematrimony.entity.Profile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
<<<<<<< HEAD
public class ProfileRequestDto  implements Serializable  {
	 
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String gender;
	private String language;
	private String qualification;
	private LocalDate dob;
	private Double monthlyIncome;
	private String mobileNumber;
	private String city;
	private String hobby;
	private String maritalStatus;
	private String userName;
	private String password;
	private String description;
	private String profession;
	private String email;
	private String address;
	private Integer age;


=======
public class ProfileRequestDto {
>>>>>>> 18d3f6fae31d5561d86235b0f6a6c6034ff72299

	private String firstName;
	private String lastName;
	private String gender;
	private String language;
	private String qualification;
	private LocalDate dob;
	private Double monthlyIncome;
	private String mobileNumber;
	private String city;
	private String hobby;
	private String maritalStatus;
	private String userName;
	private String password;
	private LocalDate createdDate;
	private String status;
	private String description;
	private String profession;
	private String email;
	private String address;
	private Integer age;

}
