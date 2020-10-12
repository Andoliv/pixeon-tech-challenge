package com.andoliv.healthcare.healthcareservice.constants;

public class ApiDocs {

    /**
     * Default
     */
    public static final String DATA_TYPE_INTEGER = "integer";
    public static final String DATA_TYPE_STRING = "string";

    public static final String PARAM_TYPE_PATH = "path";
    public static final String PARAM_TYPE_QUERY = "query";

    public static final String PARAM_SIZE = "size";
    public static final String PARAM_PAGE = "page";
    public static final String PARAM_SORT = "sort";

    public static final String DEFAULT_PAGINATION_PAGE = "Results page you want to retrieve (0..N)";
    public static final String DEFAULT_PAGINATION_SIZE = "Number of records per page.";
    public static final String DEFAULT_SORTING_SORT = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.";

    public static final String DEFAULT_200_RESPONSE = "Successfully retrieved resource";
    public static final String DEFAULT_401_RESPONSE = "You are not authorized to view the resource";
    public static final String DEFAULT_403_RESPONSE = "Accessing the resource you were trying to reach is forbidden";
    public static final String DEFAULT_404_RESPONSE = "The resource you were trying to reach is not found";
    public static final String DEFAULT_500_RESPONSE = "Something was wrong";

    /**
     * Institution
     */
    public static final String INSTITUTION_CONTROLLER_API = "Institution Controller";
    public static final String INSTITUTION_CONTROLLER_API_DESC = "Create and manage exams of institutions";
    public static final String ADD_INSTITUTION_201_RESPONSE = "Institution successfully added to database";
    public static final String GET_INSTITUTION_ID = "The institution id to match";

    public static final String GET_INSTITUTIONS_200_RESPONSE = "Institution list successfully retrieved";
    public static final String GET_INSTITUTION_200_RESPONSE = "Institution by id successfully retrieved";
    public static final String GET_EXAMS_200_RESPONSE = "Exam bound with Institution list successfully retrieved";
    public static final String GET_EXAM_ID = "The exam id to match";
    public static final String INSTITUTION_PARAM_NAME = "name";
    public static final String INSTITUTION_PARAM_CNPJ = "cnpj";
    public static final String INSTITUTION_PARAM_ID = "id";
    public static final String EXAM_PARAM_ID = "exam_id";
    public static final String GET_INSTITUTIONS_OPERATION = "Get Institution list persisted on database";
    public static final String GET_INSTITUTION_BY_ID_OPERATION = "Get Institution by id persisted on database";
    public static final String ADD_INSTITUTION_OPERATION = "Add Institution to database";
}
