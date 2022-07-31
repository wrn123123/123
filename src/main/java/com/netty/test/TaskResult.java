package com.netty.test;

import lombok.Data;

import java.io.Serializable;
@Data
public class TaskResult implements Serializable {
    private static final long serialVersionUID = 8678277072402730062L;
    /**
     * 任务状态
     */
    private Integer taskStatus;
    private String taskMessage;
    private String taskResult;
    @Override public String toString() {
        return "TaskResult{" + "taskStatus=" + taskStatus + ", taskMessage='" + taskMessage + '\'' + ", taskResult='" + taskResult + '\'' + '}'; }
}
