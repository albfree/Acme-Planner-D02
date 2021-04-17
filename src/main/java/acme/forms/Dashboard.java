package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {
	
	private static final long	serialVersionUID	= 1L;

	Double						totalNumberOfPublicTasks;
	Double						totalNumberOfPrivateTasks;
	Double						totalNumberOfFinishedTasks;
	Double						totalNumberOfNonFinishedTasks;
	
	Double						averageTaskExecutionPeriods;
	Double						deviationTaskExecutionPeriods;
	Double						minimumTaskExecutionPeriod;
	Double						maximumTaskExecutionPeriod;
	
	Double						averageTaskWorkloads;
	Double						deviationTaskWorkloads;
	Double						minimumTaskWorkload;
	Double						maximumTaskWorkload;

}
