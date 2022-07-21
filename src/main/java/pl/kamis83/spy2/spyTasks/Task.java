package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public abstract class Task implements TaskDetectorWithoutParam,TaskDetectorWithParam{
    TaskDetectorWithoutParam taskDetectorWithoutParam;
    TaskDetectorWithParam taskDetectorWithParam;


    public void makeTaskWithoutParam(List<Sentence> sentence){
        taskDetectorWithoutParam.makeTaskWithoutParam(sentence);
    }
    public void makeTaskWithParam(List <Sentence> sentence, List<String> param){
        taskDetectorWithParam.makeTaskWithParam(sentence, param);
    }
    protected abstract String getCommandName();

    public boolean supportsTask(String name) {
        return name.equals(getCommandName());
    }


}
