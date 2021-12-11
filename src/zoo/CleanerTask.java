package zoo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import zoo.employee.Cleaner;

public class CleanerTask implements Task {

	private Cleaner cleaner;
	private CleaningArea task;
	private LocalDateTime jobTime;
	
	public CleanerTask(CleaningArea tasks) {
		this.task = tasks;
		this.jobTime = LocalDateTime.now();
	}

	public Cleaner getCleaner() {
		return cleaner;
	}

	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}

	public CleaningArea getTasks() {
		return task;
	}

	public void setTasks(CleaningArea tasks) {
		this.task = tasks;
	}

	public LocalDateTime getJobTime() {
		return jobTime;
	}

	public void setJobTime(LocalDateTime jobTime) {
		this.jobTime = jobTime;
	}

	@Override
	public String toString() {
		return cleaner.getName() + " elvégezte a " + task + " takaritását " + jobTime + " kor";
	}

}
