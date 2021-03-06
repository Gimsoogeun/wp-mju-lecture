package kr.ac.mju.dislab.user2;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 2193897931951340673L;
	
	private static final String[] cuntryNames = {"한국", "미국", "영국", "일본", "중국"};
	private static final String[] idols = {"아이유", "카라", "소녀시대", "2NE1", "씨스타"};
	private static final String[][] genders = {{"M", "남성"}, {"F", "여성"}};

	private int id;
	private String userid;
	private String name;
	private String pwd;
	private String email;
	private String country;
	private String gender;
	private String favorites;
		
	// No-arg constructor 가 있어야 한다.
	public User() {
	}

	public User(int id, String userid, String name, String pwd, String email,
			String country, String gender, String favorites) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.country = country;
		this.gender = gender;
		this.favorites = favorites;
	}

	// getter & setter 가 있어야 한다. (Eclipse 에서 자동 생성 가능)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFavorites() {
		return favorites;
	}

	public void setFavorites(String favorites) {
		this.favorites = favorites;
	}
	
	public String getGenderStr() {
		if (gender.equals("M")) {
			return "남성";
		} else {
			return "여성";
		}
	}
	
	public String[] getCountryNames() {
		return cuntryNames;
	}
	
	public String checkCountry(String countryName) {
		return (countryName.equals(country)) ? "selected" : "";
	}
	
	public String[] getIdols() {
		return idols;
	}

	public List<String> getFavoriteList() {
		List<String> favoriteList = null;
		if (favorites != null && favorites.length() > 0) {
			favoriteList = Arrays.asList(StringUtils.split(favorites, ","));
		}
		return favoriteList;
	}
	
	public String checkIdol(String idolName) {
		List<String> favoriteList = getFavoriteList();
		return (favoriteList != null && favoriteList.contains(idolName))? "checked" : "";
	}
		
	public String[][] getGenders() {
		return genders;
	}
	
	public String checkGender(String genderName) {
		return (genderName.equals(gender)) ? "checked" : "";
	}
}
