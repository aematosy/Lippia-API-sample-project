package ar.validator;

import api.model.addTimeEntryResponse;
import api.model.timeEntryResponse;
import api.model.updateTimeEntryResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class TimeEntryValidator {
    public static void validate() {
        timeEntryResponse[] response = (timeEntryResponse[]) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response[0].getId(), "El campo ID es nulo");
    }

    public static void validateAddNewEntry() {
        addTimeEntryResponse response = (addTimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId(), "El campo ID es nulo");
    }

    public static void validateUpdateEntry() {
        updateTimeEntryResponse response = (updateTimeEntryResponse) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response.getId(), "El campo ID es nulo");
    }
}
