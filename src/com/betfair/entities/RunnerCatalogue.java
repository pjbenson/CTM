package com.betfair.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Runner_Catalogue")
public class RunnerCatalogue implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SELECTION_ID")
	private Long selectionId;
	@Column(name="RUNNER_NAME")
	private String runnerName;
	@Transient
	private Double handicap;

	public Long getSelectionId() {
		return selectionId;
	}

	public void setSelectionId(Long selectionId) {
		this.selectionId = selectionId;
	}

	public String getRunnerName() {
		return runnerName;
	}

	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}

	public Double getHandicap() {
		return handicap;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	public String toString() {
		return "{" + "" + "selectionId=" + getSelectionId() + ","
				+ "runnerName=" + getRunnerName() + "," + "handicap="
				+ getHandicap() + "," + "}";
	}

}
