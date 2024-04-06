package co.edu.unipiloto.arquitectura.testws.resources;

import co.edu.unipiloto.arquitectura.testws.entity.Persona;
import co.edu.unipiloto.arquitectura.testws.entity.Salary;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author 
 */
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
    
    private static Map<Integer, Persona> people = new HashMap<>();
    
    static {
        for (int i = 0; i < 10; i++) {
            Persona persona = new Persona();
            int id = i+1;
            persona.setId(id);
            persona.setFullName("Mi Persona " + id);
            persona.setAge(new Random().nextInt(20+id));
            persona.setSalary(persona.getAge()*Persona.MIN_SALARY/3);
            people.put(id, persona);
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPeopleInJSON")
    public List<Persona> getAllPersonsInJSON() {
        return new ArrayList<Persona>(people.values());
    }   
    
    @POST
    @Path("addPerson/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Persona> addPerson(List<Persona> pr) {
        for(Persona persona : pr) {
            persona.setSalary(persona.getAge()*Persona.MIN_SALARY/3);
            people.put(persona.getId(), persona);
        }
        return new ArrayList<Persona>(people.values());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("getAverageSalaryInXML")
    public Salary getAverageSalary() {
        int average = 0;
        for(Persona persona : people.values()){
            average += persona.getSalary().getSalary();
        }
        Salary salary = new Salary();
        salary.setSalary(average/people.size());
        return salary;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAddSalariesInJSON")
    public int getAddSalary() {
        int sum = 0;
        for (Persona persona : people.values()){
            sum += persona.getSalary().getSalary();
        }
        return sum;
    }
}
