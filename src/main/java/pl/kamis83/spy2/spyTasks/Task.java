package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;

public abstract class Task implements TaskDetectorWithoutParam,TaskDetectorWithParam{
    TaskDetectorWithoutParam taskDetectorWithoutParam;
    TaskDetectorWithParam taskDetectorWithParam;


    public void makeTaskWithoutParam(List<Sentance> sentance){
        taskDetectorWithoutParam.makeTaskWithoutParam(sentance);
    }
    public void makeTaskWithParam(List <Sentance> sentance, List<String> param){
        taskDetectorWithParam.makeTaskWithParam(sentance, param);
    }
    protected abstract String getCommandName();

    public boolean supportsTask(String name) {
        return name.equals(getCommandName());
    }


}
