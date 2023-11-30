package api.model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class timeEntryResponse {

    public String id;
    public String description;
    public List<Object> tagIds;
    public String userId;
    public boolean billable;
    public Object taskId;
    public String projectId;
    public String workspaceId;
    public TimeInterval timeInterval;
    public List<Object> customFieldValues;
    public String type;
    public Object kioskId;
    public HourlyRate hourlyRate;
    public CostRate costRate;
    public boolean isLocked;

}
