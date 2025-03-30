package org.seasar.sastruts.example.task;

import javax.annotation.Resource;

import org.seasar.chronos.core.TaskTrigger;
import org.seasar.chronos.core.annotation.task.Task;

/**
 * <code>CronTrigger</code>を使ったタスクのサンプルです。
 */
@Task
//@CronTrigger(expression = "0 */1 * * * ?")  // 1分ごとに実行
public class CronTask {

	@Resource
	protected TaskTrigger trigger;

	@Resource
	protected TaskLogger taskLogger;

	public TaskTrigger getTrigger(){
		return this.trigger;
	}

	public void initialize(){
		taskLogger.log("CronTask#initialize()が実行されました。");
	}

	public void start(){
		taskLogger.log("CronTask#start()が実行されました。");
	}

	public void doExecute(){
		taskLogger.log("CronTask#doExecute()が実行されました。");
	}

	public void end(){
		taskLogger.log("CronTask#end()が実行されました。");
	}

	public void destroy(){
		taskLogger.log("CronTask#destroy()が実行されました。");
	}

}
