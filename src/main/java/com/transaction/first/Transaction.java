package com.transaction.first;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reposting")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	Integer id;

	@Column(name="txn_id")
	String txn_id;

	@Column(name="external_ref_number")
	String external_ref_number;

	@Column(name="posting_status")
	String posting_status;

	@Column(name="posting_count")
	String posting_count;

	@Column(name="txn")
	String txn;

	@Column(name="posting_request")
	String posting_request;

	@Column(name="posting_response")
	String posting_response;

	@Column(name="org_code")
	String org_code;

	@Column(name="created_date")
	String created_date;

	@Column(name="updated_date")
	String updated_date;

	@Column(name="status")
	String status;

	@Column(name="payment_mode")
	String payment_mode;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public String getExternal_ref_number() {
		return external_ref_number;
	}

	public void setExternal_ref_number(String external_ref_number) {
		this.external_ref_number = external_ref_number;
	}

	public String getPosting_status() {
		return posting_status;
	}

	public void setPosting_status(String posting_status) {
		this.posting_status = posting_status;
	}

	public String getPosting_count() {
		return posting_count;
	}

	public void setPosting_count(String posting_count) {
		this.posting_count = posting_count;
	}

	public String getTxn() {
		return txn;
	}

	public void setTxn(String txn) {
		this.txn = txn;
	}

	public String getPosting_request() {
		return posting_request;
	}

	public void setPosting_request(String posting_request) {
		this.posting_request = posting_request;
	}

	public String getPosting_response() {
		return posting_response;
	}

	public void setPosting_response(String posting_response) {
		this.posting_response = posting_response;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}


}


