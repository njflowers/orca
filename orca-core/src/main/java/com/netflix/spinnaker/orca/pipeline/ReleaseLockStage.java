package com.netflix.spinnaker.orca.pipeline;

import com.netflix.spinnaker.orca.pipeline.model.Stage;
import com.netflix.spinnaker.orca.pipeline.tasks.DetermineLockTask;
import com.netflix.spinnaker.orca.pipeline.tasks.ReleaseLockTask;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

@Component
public class ReleaseLockStage implements StageDefinitionBuilder {
  public static final String PIPELINE_TYPE = "releaseLock";

  @Nonnull
  @Override
  public String getType() {
    return PIPELINE_TYPE;
  }

  @Override
  public void taskGraph(@Nonnull Stage stage, @Nonnull TaskNode.Builder builder) {
    builder
      .withTask("determineLock", DetermineLockTask.class)
      .withTask("releaseLock", ReleaseLockTask.class);
  }
}
