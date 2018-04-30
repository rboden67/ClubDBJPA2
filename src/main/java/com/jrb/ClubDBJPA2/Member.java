package com.jrb.ClubDBJPA2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author
 */
@Entity
@Table(name = "tblMembers")
public class Member {
	@Id
	@Column(name = "MemId")
	private String memid;

	@Column(name = "LastName")
	private String lastname;

	@Column(name = "FirstName")
	private String firstname;

	@Column(name = "MiddleName")
	private String middlename;

	@Column(name = "Status")
	private String status;

	@Column(name = "MemDt")
	@Temporal(TemporalType.DATE)
	private Date memdt;

	@Column(name = "YTD_Total_Dt")
	@Temporal(TemporalType.DATE)
	private Date ytdtotdt;

	@Column(name = "YTD_Total")
	private double ytdtot;

	@Column(name = "Password")
	private long password;

	@Transient
	private long passwordatt;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "memid")
	@Cascade(CascadeType.ALL)
	private List<Purchase> purchases;

	public Member() {
		this.memid = "";
		this.lastname = "";
		this.firstname = "";
		this.middlename = "";
		this.status = "";
		this.memdt = null;
		this.ytdtotdt = null;
		this.ytdtot = 0;
		this.password = -1;
		this.passwordatt = 0;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getMemdt() {
		return memdt;
	}

	public void setMemdt(Date memdt) {
		this.memdt = memdt;
	}

	public String getMemdtS() {
		return new SimpleDateFormat("MM-dd-yyyy").format(this.memdt);
	}

	public Date getYtdtotdt() {
		return ytdtotdt;
	}

	public void setYtdtotdt(Date ytdtotdt) {
		this.ytdtotdt = ytdtotdt;
	}

	public String getYtdtotdtS() {
		return ytdtotdt.toString();
	}

	public Double getYtdtot() {
		return ytdtot;
	}

	public void setYtdtot(Double ytdtot) {
		this.ytdtot = ytdtot;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}

	public void setPasswordatt(long pwd) {
		this.passwordatt = pwd;
	}

	public boolean isAuthenticated() {
		if (this.password > 0) {
			if (this.password == this.passwordatt) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.memid + ", " + this.lastname + ", " + this.firstname + ", " + this.memdt + ", " + this.status;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}
}
