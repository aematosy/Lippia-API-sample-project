package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {
    public static final ThreadLocal<String> API_KEY = new ThreadLocal<>();
    public static final ThreadLocal<String> WORKSPACE_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> USER_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> DESCRIPTION = new ThreadLocal<>();
    public static final ThreadLocal<String> END_TIME = new ThreadLocal<>();
    public static final ThreadLocal<String> START_TIME = new ThreadLocal<>();
    public static final ThreadLocal<String> PROYECT_ID = new ThreadLocal<>();
    public static final ThreadLocal<String> ID_ENTRY = new ThreadLocal<>();
}
