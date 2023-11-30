package services;

import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;
import java.util.HashMap;
import java.util.Map;

public class deleteTimeEntryService extends BaseService {

    public static Response delete(String jsonName) { return delete(jsonName, deleteTimeEntryService.class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", API_KEY.get());
        params.put("workspaceId", WORKSPACE_ID.get());
        params.put("idEntry", ID_ENTRY.get());
        return params;
    }
}