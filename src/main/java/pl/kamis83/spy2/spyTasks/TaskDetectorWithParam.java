package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public interface TaskDetectorWithParam {
     void makeTaskWithParam(List <Sentence> sentence, List<String> param);


}