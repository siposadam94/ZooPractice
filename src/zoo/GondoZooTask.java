package zoo;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

	@Override
	public String toString() {
		return gondoZoo.getName() + " elvégezte a " + task + " gondozását " + jobTime + " kor";
	}
	
}
