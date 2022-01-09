package zoo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import zoo.employee.Cleaner;

public class CleanerTask implements Task {

	private Cleaner cleaner;
	private Cleaner.CleaningArea task;
	private LocalDateTime jobTime;
	
	public CleanerTask(Cleaner.CleaningArea tasks) {
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

	public Cleaner.CleaningArea getTask() {
		return task;
	}

	public void setTask(Cleaner.CleaningArea task) {
		this.task = task;
	}

	public LocalDateTime getJobTime() {
		return jobTime;
	}

	public void setJobTime(LocalDateTime jobTime) {
		this.jobTime = jobTime;
	}
}
