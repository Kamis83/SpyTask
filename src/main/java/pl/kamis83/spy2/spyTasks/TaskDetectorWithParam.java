package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;

public interface TaskDetectorWithParam {
     void makeTaskWithParam(List <Sentance> sentance, List<String> param);


}