package com.andoliv.healthcare.healthcareservice.controller;

import com.andoliv.healthcare.healthcareservice.external.ExtHealthcareInstitution;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import static com.andoliv.healthcare.healthcareservice.constants.ApiDocs.*;
import static com.andoliv.healthcare.healthcareservice.constants.ApiLinks.INSTITUTIONS;

@Api(value = INSTITUTION_CONTROLLER_API, description = INSTITUTION_CONTROLLER_API_DESC,
        tags = {INSTITUTION_CONTROLLER_API})
@RequestMapping(INSTITUTIONS)
@Consumes(MediaType.APPLICATION_JSON_VALUE)
@Produces(MediaType.APPLICATION_JSON_VALUE)
public interface HealthcareController {

    @ApiOperation(value = GET_INSTITUTIONS_OPERATION, produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "GET " + INSTITUTIONS)
    @ApiImplicitParams({
            @ApiImplicitParam(name = PARAM_PAGE, dataType = DATA_TYPE_INTEGER, paramType = PARAM_TYPE_QUERY, value = DEFAULT_PAGINATION_PAGE),
            @ApiImplicitParam(name = PARAM_SIZE, dataType = DATA_TYPE_INTEGER, paramType = PARAM_TYPE_QUERY, value = DEFAULT_PAGINATION_SIZE),
            @ApiImplicitParam(name = PARAM_SORT, dataType = DATA_TYPE_STRING, paramType = PARAM_TYPE_QUERY, value = DEFAULT_SORTING_SORT, allowMultiple = true)})
    @ApiResponses({@ApiResponse(code = 200, message = GET_INSTITUTIONS_200_RESPONSE),
            @ApiResponse(code = 401, message = DEFAULT_401_RESPONSE),
            @ApiResponse(code = 403, message = DEFAULT_403_RESPONSE),
            @ApiResponse(code = 404, message = DEFAULT_404_RESPONSE),
            @ApiResponse(code = 500, message = DEFAULT_500_RESPONSE)})
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Page<ExtHealthcareInstitution> findAll(Pageable page);

    @ApiOperation(value = GET_INSTITUTION_BY_ID_OPERATION, produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "GET " + INSTITUTIONS + "/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = INSTITUTION_PARAM_ID, dataType = DATA_TYPE_INTEGER, paramType = PARAM_TYPE_PATH, value = GET_INSTITUTION_ID)})
    @ApiResponses({@ApiResponse(code = 200, message = GET_INSTITUTION_200_RESPONSE),
            @ApiResponse(code = 401, message = DEFAULT_401_RESPONSE),
            @ApiResponse(code = 403, message = DEFAULT_403_RESPONSE),
            @ApiResponse(code = 404, message = DEFAULT_404_RESPONSE),
            @ApiResponse(code = 500, message = DEFAULT_500_RESPONSE)})
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    ExtHealthcareInstitution getExtInstitutionById(@NotNull @PathVariable(INSTITUTION_PARAM_ID) long id);

    @ApiOperation(value = ADD_INSTITUTION_OPERATION, produces = MediaType.APPLICATION_JSON_VALUE,
            notes = "POST " + INSTITUTIONS)
    @ApiResponses({@ApiResponse(code = 201, message = ADD_INSTITUTION_201_RESPONSE),
            @ApiResponse(code = 401, message = DEFAULT_401_RESPONSE),
            @ApiResponse(code = 403, message = DEFAULT_403_RESPONSE),
            @ApiResponse(code = 404, message = DEFAULT_404_RESPONSE),
            @ApiResponse(code = 500, message = DEFAULT_500_RESPONSE)})
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ExtHealthcareInstitution createInstitution(@Valid @NotNull @RequestBody() ExtHealthcareInstitution extInstitution);
}
