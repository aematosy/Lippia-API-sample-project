package ar.steps;

import api.config.EntityConfiguration;
import api.model.addTimeEntryResponse;
import api.model.timeEntryResponse;
import ar.validator.TimeEntryValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import com.google.api.client.repackaged.com.google.common.base.Splitter;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang.StringUtils;
import services.BaseService;
import services.deleteTimeEntryService;
import services.updateTimeEntryService;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ClockifyTimeEntrySteps extends PageSteps {

    @Given("^Teniendo un '(.*)' valido generado$")
    public void miApikeyAsociada(String apiKey) {
        BaseService.API_KEY.set(apiKey);
    }

    @And("^Un '(.*)' asociado a la cuenta$")
    public void miWorkspaceAsociado(String workspace_Id) {
        BaseService.WORKSPACE_ID.set(workspace_Id);
    }
    @And("^Un '(.*)' creado en el workspace$")
    public void miProjectIDasociado(String project_id) {
        BaseService.PROYECT_ID.set(project_id);
    }

    @And("^Ingreso una descripcion '(.*)', hora de entrada '(.*)' y hora de salida '(.*)'$")
    public void ingresarDatosNuevaEntrada(String descripcion, String horaInicio, String horaFin) {
        BaseService.DESCRIPTION.set(descripcion);
        BaseService.START_TIME.set(horaInicio);
        BaseService.END_TIME.set(horaFin);
    }

    @And("^Ingreso la nueva hora de entrada '(.*)' y hora de salida '(.*)'$")
    public void ingresarNuevoDatosEntrada(String horaInicio, String horaFin) {
        BaseService.START_TIME.set(horaInicio);
        BaseService.END_TIME.set(horaFin);
    }

    @And("^Y un userID '(.*)' valido$")
    public void miUserIDAsociado(String userID) {
        BaseService.USER_ID.set(userID);
    }

    @When("^I perform a '(.*)' to '(.*)' endpoint with the '(.*)' and '(.*)'$")
    public void doRequest(String methodName, String entity, String jsonName, String jsonReplacementValues) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class entityService = EntityConfiguration.valueOf(entity).getEntityService();
        Map<String, String> parameters = getParameters(jsonReplacementValues);
        String jsonPath = "request/".concat(jsonName);
        if (parameters == null) {
            entityService.getMethod(methodName.toLowerCase(), String.class).invoke("", jsonPath);
        } else {
            entityService.getMethod(methodName.toLowerCase(), String.class, Map.class).invoke("", jsonPath, parameters);
        }
    }

    @Then("^Obtengo la lista de horas agregadas al proyecto$")
    public void obtenerListaHorasAgregadas() {
        TimeEntryValidator.validate();
    }

    @Then("Obtengo la nueva entrada de datos agregado al proyecto")
    public void obtengoNuevaEntradaAgregada() {
        TimeEntryValidator.validateAddNewEntry();
    }

    @Then("Obtengo la entrada de datos actualizado en el proyecto")
    public void obtengoEntradaActualizada() {
        TimeEntryValidator.validateUpdateEntry();
    }

    @And("Obtengo un userID de la respuesta")
    public void unUserIDDeLaRespuesta() {
        timeEntryResponse[] idArray = (timeEntryResponse[]) APIManager.getLastResponse().getResponse();
        String userID = idArray[0].getId();
        updateTimeEntryService.ID_ENTRY.set(userID);
    }

    @And("Obtengo un userID de la respuesta del post")
    public void unUserIDDeLaRespuestaPost() {
        addTimeEntryResponse timeEntryResponse = (addTimeEntryResponse) APIManager.getLastResponse().getResponse();
        String userID = timeEntryResponse.getId();
        deleteTimeEntryService.ID_ENTRY.set(userID);
    }

    private Map<String, String> getParameters(String jsonReplacementValues) {
        Map<String, String> parameters = null;
        if (!StringUtils.isEmpty(jsonReplacementValues)) {
            parameters = Splitter.on(",").withKeyValueSeparator(":").split(jsonReplacementValues);
        }
        return parameters;
    }
}
