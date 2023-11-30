package services;

import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;
import java.util.HashMap;
import java.util.Map;

public class updateTimeEntryService extends BaseService {

    public static Response put(String jsonName) {
        return put(jsonName, updateTimeEntryService.class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<>();
        params.put("baseUrl", PropertyManager.getProperty("base.api.url"));
        params.put("apiKey", API_KEY.get());
        params.put("workspaceId", WORKSPACE_ID.get());
        params.put("idEntry", ID_ENTRY.get());
        params.put("END_TIME", END_TIME.get());
        params.put("START_TIME", START_TIME.get());
        return params;
    }
}