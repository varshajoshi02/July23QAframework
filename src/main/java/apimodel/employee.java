package apimodel; 

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.opentelemetry.sdk.metrics.data.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"employee_name",
"employee_salary",
"employee_age",
"profile_image"
})
//@Generated("jsonschema2pojo")
public class employee {

@JsonProperty("id")
private Integer id;
@JsonProperty("employee_name")
private String employeeName;
@JsonProperty("employee_salary")
private Integer employeeSalary;
@JsonProperty("employee_age")
private Integer employeeAge;
@JsonProperty("profile_image")
private String profileImage;

private String status;
private Data data;
private String message;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

public String getStatus() {
    return status;
}

public Data getData() {
    return data;
}

public String getMessage() {
    return message;
}
@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("employee_name")
public String getEmployeeName() {
return employeeName;
}

@JsonProperty("employee_name")
public void setEmployeeName(String employeeName) {
this.employeeName = employeeName;
}

@JsonProperty("employee_salary")
public Integer getEmployeSalary() {
return employeeSalary;
}

@JsonProperty("employee_salary")
public void setEmployeeSalary(Integer employeeSalary) {
this.employeeSalary = employeeSalary;
}

@JsonProperty("employee_age")
public Integer getEmployeeAge() {
return employeeAge;
}

@JsonProperty("employee_age")
public void setEmployeeAge(Integer employeeAge) {
this.employeeAge = employeeAge;
}

@JsonProperty("profile_image")
public String getProfileImage() {
return profileImage;
}

@JsonProperty("profile_image")
public void setProfileImage(String profileImage) {
this.profileImage = profileImage;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
/*
public static class ResponseBody {
    private String status;
    private Data data;

    
}

public static class Data {
    private String name;
    private String salary;
    private int age;

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }

    public int getId() {
        return id;
    }
}

*/






}