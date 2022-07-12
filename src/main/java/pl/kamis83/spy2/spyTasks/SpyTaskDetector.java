package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.Optional;

public interface SpyTaskDetector {

     void makeTask(Optional<Sentance> sentance);
     boolean supportsTask(String name);


}
