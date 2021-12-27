package zoo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import zoo.CleaningArea;
import zoo.employee.Cleaner;

public class CleanerTask implements Task {

	private Cleaner cleaner;
	private CleaningArea task;
	private LocalDateTime jobTime;
	
	public CleanerTask(CleaningArea tasks) {
		this.task = tasks;
		this.jobTime = LocalDateTime.now();
	}

	@Override
	public String showTaskDetail() {
		return cleaner.getName() + " elvégezte a " + task + " takaritását " + jobTime.format(DateTimeFormatter.ISO_DATE) + " kor";
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

}
