package api.model;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TimeInterval {
    public Date start;
    public Date end;
    public String duration;
}
