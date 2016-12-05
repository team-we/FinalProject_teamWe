package com.gmail.whwan09.entities;

import org.springframework.stereotype.Component;

@Component
public class QnaBoard {
	private int q_seq;
	private String q_email;
	private String q_password;
	private String q_name;
	private String q_attach;
	private String q_title;
	private String q_content;
	private String q_reply;
	private int q_like;
	private int q_hit;
	private int q_ref;
	private int q_step;
	private int q_ip;
	private String q_date;
	
	
	public int getQ_seq() {
		return q_seq;
	}
	public void setQ_seq(int q_seq) {
		this.q_seq = q_seq;
	}
	public String getQ_email() {
		return q_email;
	}
	public void setQ_email(String q_email) {
		this.q_email = q_email;
	}
	public String getQ_password() {
		return q_password;
	}
	public void setQ_password(String q_password) {
		this.q_password = q_password;
	}
	public String getQ_name() {
		return q_name;
	}
	public void setQ_name(String q_name) {
		this.q_name = q_name;
	}
	public String getQ_attach() {
		return q_attach;
	}
	public void setQ_attach(String q_attach) {
		this.q_attach = q_attach;
	}
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_reply() {
		return q_reply;
	}
	public void setQ_reply(String q_reply) {
		this.q_reply = q_reply;
	}
	public int getQ_like() {
		return q_like;
	}
	public void setQ_like(int q_like) {
		this.q_like = q_like;
	}
	public int getQ_hit() {
		return q_hit;
	}
	public void setQ_hit(int q_hit) {
		this.q_hit = q_hit;
	}
	public int getQ_ref() {
		return q_ref;
	}
	public void setQ_ref(int q_ref) {
		this.q_ref = q_ref;
	}
	public int getQ_step() {
		return q_step;
	}
	public void setQ_step(int q_step) {
		this.q_step = q_step;
	}
	public int getQ_ip() {
		return q_ip;
	}
	public void setQ_ip(int q_ip) {
		this.q_ip = q_ip;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
}
