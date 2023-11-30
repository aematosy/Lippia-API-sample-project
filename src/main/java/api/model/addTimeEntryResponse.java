package api.model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class addTimeEntryResponse {

    public String id;
    public String description;
    public Object tagIds;
    public String userId;
    public boolean billable;
    public String taskId;
    public String projectId;
    public TimeInterval timeInterval;
    public String workspaceId;
    public boolean isLocked;
    public List<Object> customFieldValues;
    public String type;
    public String kioskId;
}
