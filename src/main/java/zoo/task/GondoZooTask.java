package zoo.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import zoo.animal.AnimalType;
import zoo.employee.GondoZoo;

public class GondoZooTask implements Task {
	
	private GondoZoo gondoZoo;
	private AnimalType task;
	private LocalDateTime jobTime;
	
	public GondoZooTask(AnimalType tasks) {
		this.task = tasks;
		this.jobTime = LocalDateTime.now();
	}
	@Override
	public String showTaskDetail() {
		return gondoZoo.getName() + " elvégezte a " + task + " gondozását " + jobTime.format(DateTimeFormatter.ISO_DATE) + " kor";
	}

	public GondoZoo getGondoZoo() {
		return gondoZoo;
	}

	public void setGondoZoo(GondoZoo gondoZoo) {
		this.gondoZoo = gondoZoo;
	}

	public AnimalType getTasks() {
		return task;
	}

	public void setTasks(AnimalType tasks) {
		this.task = tasks;
	}

	public LocalDateTime getJobTime() {
		return jobTime;
	}

	public void setJobTime(LocalDateTime jobTime) {
		this.jobTime = jobTime;
	}

}
