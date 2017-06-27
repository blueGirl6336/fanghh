// default package
package hitwh.fanghh.manage.pojo.building;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Building entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Activity", schema = "dbo")
public class Activity implements java.io.Serializable {
	
	// Fields

		private Integer activityId;
		private String activityName;
		private String picture;
		private String url;
		private Integer buildingId;
		private Double totalCash;
		private Integer totalTimes;
		private Integer limitTimes;
		private String startDate;
		private String endDate;
		private Integer currentTimes;
		private Double leftCash;
		private String state;

		// Constructors

		/** default constructor */
		public Activity() {
		}

		/** minimal constructor */
		public Activity(Integer buildingId) {
			this.buildingId = buildingId;
		}

		/** full constructor */
		public Activity(String activityName, String picture, String url,
				Integer buildingId, Double totalCash, Integer totalTimes,
				Integer limitTimes, String startDate, String endDate,
				Integer currentTimes, Double leftCash, String state,
				Set shareRecords) {
			this.activityName = activityName;
			this.picture = picture;
			this.url = url;
			this.buildingId = buildingId;
			this.totalCash = totalCash;
			this.totalTimes = totalTimes;
			this.limitTimes = limitTimes;
			this.startDate = startDate;
			this.endDate = endDate;
			this.currentTimes = currentTimes;
			this.leftCash = leftCash;
			this.state = state;
		}

		// Property accessors
		@Id
		@GeneratedValue
		@Column(name = "activity_id", unique = true, nullable = false)
		public Integer getActivityId() {
			return this.activityId;
		}

		public void setActivityId(Integer activityId) {
			this.activityId = activityId;
		}
		@Column(name = "activity_name")
		public String getActivityName() {
			return this.activityName;
		}

		public void setActivityName(String activityName) {
			this.activityName = activityName;
		}
		@Column(name = "picture")
		public String getPicture() {
			return this.picture;
		}

		public void setPicture(String picture) {
			this.picture = picture;
		}
		@Column(name = "url")
		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
		@Column(name = "building_id")
		public Integer getBuildingId() {
			return this.buildingId;
		}

		public void setBuildingId(Integer buildingId) {
			this.buildingId = buildingId;
		}
		@Column(name = "total_cash")
		public Double getTotalCash() {
			return this.totalCash;
		}

		public void setTotalCash(Double totalCash) {
			this.totalCash = totalCash;
		}
		@Column(name = "total_times")
		public Integer getTotalTimes() {
			return this.totalTimes;
		}

		public void setTotalTimes(Integer totalTimes) {
			this.totalTimes = totalTimes;
		}
		@Column(name = "limit_times")
		public Integer getLimitTimes() {
			return this.limitTimes;
		}

		public void setLimitTimes(Integer limitTimes) {
			this.limitTimes = limitTimes;
		}
		@Column(name = "start_date")
		public String getStartDate() {
			return this.startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		@Column(name = "end_date")
		public String getEndDate() {
			return this.endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		@Column(name = "current_times")
		public Integer getCurrentTimes() {
			return this.currentTimes;
		}

		public void setCurrentTimes(Integer currentTimes) {
			this.currentTimes = currentTimes;
		}
		@Column(name = "left_cash")
		public Double getLeftCash() {
			return this.leftCash;
		}

		public void setLeftCash(Double leftCash) {
			this.leftCash = leftCash;
		}
		@Column(name = "state")
		public String getState() {
			return this.state;
		}

		public void setState(String state) {
			this.state = state;
		}
}