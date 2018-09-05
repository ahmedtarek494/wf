package com.wf.entities;


import java.io.Serializable;

import javax.annotation.concurrent.Immutable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name="v_topstudentgrade")
public class GradesStudentView implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	private User userid;
	
	@Column(name="totalusergrade")
	private float totalusergrade;

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public float getTotalusergrade() {
		return totalusergrade;
	}

	public void setTotalusergrade(float totalusergrade) {
		this.totalusergrade = totalusergrade;
	}

	

}
