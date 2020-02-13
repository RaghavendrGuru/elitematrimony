package com.strikers.elitematrimony.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.strikers.elitematrimony.dto.ProfileRequestDto;
import com.strikers.elitematrimony.dto.ProfileResponseDto;
import com.strikers.elitematrimony.entity.City;
import com.strikers.elitematrimony.entity.Language;
import com.strikers.elitematrimony.entity.Profile;
import com.strikers.elitematrimony.exception.AgeNotMatchedException;
import com.strikers.elitematrimony.repository.CityRepository;
import com.strikers.elitematrimony.repository.LanguageRepository;
import com.strikers.elitematrimony.repository.ProfileRepository;
import com.strikers.elitematrimony.util.StringConstant;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileServiceImplTest {
	@InjectMocks
	ProfileServiceImpl profileService;

	@Mock
	ProfileRepository profileRepository;

	@Mock
	CityRepository cityRepository;
	@Mock
	LanguageRepository languaRepository;

	Profile profile = new Profile();
	ProfileResponseDto profileResponseDto = new ProfileResponseDto();
	ProfileRequestDto profileRequestDto = new ProfileRequestDto();
	City city = new City();
	Language language = new Language();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		profile.setProfession("mca");
		profile.setProfileId(1);
		profile.setMobileNumber("9538156731");
		profile.setPassword("vasavi@123");
		profileResponseDto.setMessage("profile created successfully");
		profileResponseDto.setProfileId(1);
		profileResponseDto.setStatusCode(200);
		profileRequestDto.setAddress("bangalore");
		profileRequestDto.setAge(25);
		profileRequestDto.setCity("bangalore");
		profileRequestDto.setCreatedDate(LocalDate.of(2019, 12, 12));
		profileRequestDto.setDescription("abc");
		profileRequestDto.setDob(LocalDate.of(2012, 12, 12));
		profileRequestDto.setEmail("vasavi@gmail.com");
		profileRequestDto.setFirstName("vasavi");
		profileRequestDto.setGender("female");
		profileRequestDto.setHobby("reading books");
		profileRequestDto.setLanguage("telugu");
		profileRequestDto.setLastName("p");
		profileRequestDto.setMaritalStatus("unmarried");
		profileRequestDto.setMobileNumber("9538156731");
		profileRequestDto.setPassword("vasavi@123");
		profileRequestDto.setMonthlyIncome(10000.00);
		profileRequestDto.setQualification("mca");
		profileRequestDto.setStatus("active");
		profileRequestDto.setUserName("vasavi");
		profileResponseDto.setMessage("profile created successfully");
		profileResponseDto.setProfileId(1);
		profileResponseDto.setStatusCode(200);
		profileRequestDto.setAge(17);
	}

	@Test
	public void testSearchProfile() {
		List<Profile> profileList = new ArrayList<>();
		when(profileRepository.searchProfile("mca","")).thenReturn(profileList);
		List<Profile> profile = profileService.searchProfile("mca","");
		assertNotNull(profile);

	}

	@Test(expected = AgeNotMatchedException.class)
	public void testCreateProfilePositive() throws AgeNotMatchedException {
		profile.setProfileId(1);
		profileRequestDto.getDob();
		when(cityRepository.findById(1)).thenReturn(Optional.of(city));
		when(languaRepository.findById(1)).thenReturn(Optional.of(language));
		when(profileRepository.save(profile)).thenReturn(profile);
		profileResponseDto.setProfileId(profile.getProfileId());
		profileResponseDto.setMessage(StringConstant.SUCCESS);
		profileResponseDto.setStatusCode(200);
		ProfileResponseDto profileResponseDtos = profileService.createProfile(profileRequestDto);
		assertEquals(StringConstant.SUCCESS, profileResponseDtos.getMessage());
		

	}
	@Test(expected = AgeNotMatchedException.class)
	public void testCreateProfileNegative() throws AgeNotMatchedException {
		when(profileRepository.save(profile)).thenReturn(profile);
		profileResponseDto.setMessage(StringConstant.FAILED);
		profileResponseDto.setStatusCode(400);
		ProfileResponseDto profileResponseDtos = profileService.createProfile(profileRequestDto);
		assertEquals(StringConstant.FAILED, profileResponseDtos.getMessage());
		
	}
	

	

}