package org.seasar.sastruts.example.task;

import java.util.Date;

import org.apache.log4j.Logger;

public class TaskLogger {

	private static final Logger logger = Logger.getLogger(TaskLogger.class);

	private StringBuilder sb = new StringBuilder();

	public void log(String message){
		logger.info(message);

		sb.append("[");
		sb.append(new Date().toString());
		sb.append("]");
		sb.append(message);
		sb.append("\n");
	}

	public String getMessages(){
		return sb.toString();
	}

}
