package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;

public interface TaskDetectorWithoutParam {

     default void makeTaskWithoutParam(List<Sentance> sentance) {

     }
}
