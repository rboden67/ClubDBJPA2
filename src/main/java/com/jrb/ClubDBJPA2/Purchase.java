package com.jrb.ClubDBJPA2;


	import java.text.NumberFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;
	import javax.persistence.Temporal;
	import javax.persistence.TemporalType;
	import javax.persistence.Transient;

	/**
	 *
	 * @author 
	 */
	@Entity
	@Table(name="tblpurchases")
	public class Purchase {
	      
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="ID")
	    private long pid;
	    
	    @Column(name="MemId")
	    private String memid;
	    
	    @Column(name="PurchaseDt")
	    @Temporal(TemporalType.DATE)    
	    private Date purchdt;
	    
	    @Column(name="TransType")    
	    private String transtype;

	    @Column(name="TransCd")    
	    private String tcd;
	    
	    @Column(name="Amount")
	    private double amt;
	    
	    @OneToOne (fetch=FetchType.EAGER)
	    @JoinColumn(name="TransCd", insertable=false, updatable=false)
	    private TransCd transcd;
	    
	    @Transient
	    NumberFormat curr = NumberFormat.getCurrencyInstance();
	    
	    public Purchase() {
	        this.memid = "";
	        this.purchdt = null;
	        this.transtype = "";
	        this.tcd="";
	        this.amt = 0;
	        this.pid = 0;
	    }
	    
	    public Purchase(String mid, Date pdt, String ttype, String tcd, 
	                    String tdesc, double a) {
	        this.memid = mid;
	        this.purchdt = pdt;
	        this.transtype = ttype;
	        this.tcd = tcd;
	        this.amt = a;
	    }
	    
	    public long getPid() {
	        return this.pid;
	    }
	    public void setPid(long pid) {
	        this.pid = pid;
	    }
	    
	    public String getMemid() {
	        return this.memid;        
	    }
	    public void seteMemid(String mid) {
	        this.memid = mid;
	    }
	    
	    public Date getPurchdt() {
	        return purchdt;
	    }
	    public void setPurchdt(Date purchdt) {
	        this.purchdt = purchdt;
	    }
	    public String getPurchdtS() {
	        return new SimpleDateFormat("MM-dd-yyyy").format(this.purchdt);
	    }

	    public String getTranstype() {
	        return transtype;
	    }
	    public void setTranstype(String ttype) {
	        this.transtype = ttype;
	    }

	    public String getTranscd() {
	        return tcd;
	    }
	    public void setTranscd(String transcd) {
	        this.tcd = transcd;
	    }
	        
	    public String getTransdesc() {
	        return transcd.getTransdesc();
	    }

	    public String getAmt() {
	        NumberFormat curr = NumberFormat.getCurrencyInstance();
	        return curr.format(amt);
	    }
	    public void setAmt(double amt) {
	        this.amt = amt;
	    }
	    public String toString() {
	    	return this.purchdt.toString() + "," + this.tcd  + "," + this.transcd.getTransdesc() + "," + this.transtype + this.amt;
	    }
	}

	
