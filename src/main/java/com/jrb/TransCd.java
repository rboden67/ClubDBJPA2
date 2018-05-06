package com.jrb;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	/**
	 * @author pdaniel
	 */
	@Entity
	@Table(name = "tblcodes")
	public class TransCd {
	    private String transcd, transtype, transdesc;
	    public TransCd() {
	        transcd = "";
	        transtype="";
	        transdesc=""; }
	    @Id
	    @Column (name = "TransCd")
	    public String getTranscd() {
	        return transcd;
	    }
	    public void setTranscd(String transcd) {
	        this.transcd = transcd;
	    }
	    
	    @Column (name = "TransType")
	    public String getTranstype() {
	        return transtype;
	    }
	    public void setTranstype(String transtype) {
	        this.transtype = transtype;
	    }
	    
	    @Column (name = "TransDesc")
	    public String getTransdesc() {
	        return transdesc;
	    }
	    public void setTransdesc(String transdesc) {
	        this.transdesc = transdesc;
	    }
	}

