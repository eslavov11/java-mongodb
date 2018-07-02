package com.javamongodb.webapp.resource;

import com.javamongodb.dataaccess.model.bindingmodel.CarModel;
import com.javamongodb.dataaccess.model.viewmodel.CarViewModel;
import com.javamongodb.dataaccess.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Produces(APPLICATION_JSON_UTF8_VALUE)
@Path("/api/cars")
@Component
public class CarResource {
    private CarService service;

    @Autowired
    public CarResource(CarService service) {
        this.service = service;
    }

    @POST
    //@PreAuthorize("hasRole('ADMIN')")
    public Response add(CarModel carModel) {
        this.service.create(carModel);

        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Response edit(@PathParam("id") String id, CarModel carModel) {
        carModel.setId(id);

        this.service.save(carModel);

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id) {
        CarViewModel carViewModel = this.service.get(id);

        if (carViewModel == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(carViewModel, MediaType.APPLICATION_JSON).build();
    }

    @GET
    public List<CarViewModel> getAllByDate(@QueryParam("year") String year) {
        if (year == null) {
            return this.service.getAll();
        }

        return this.service.getAllByYear(Integer.valueOf(year));
    }
}
