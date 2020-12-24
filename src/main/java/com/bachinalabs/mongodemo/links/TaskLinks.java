package com.bachinalabs.mongodemo.links;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class TaskLinks {

    public static final String TASKS = "/tasks";
    public static final String TASK = "/task/{id}";
    public static final String CREATE_TASK = "/task";
    public static final String UPDATE_TASK = "/task";
    public static final String DELETE_TASK = "/task/{id}";

    /*public Link getCancelLink(Event event) {
        return entityLinks.linkForSingleResource(event).slash(CANCEL_EVENT).withRel(CANCEL_REL);
    }*/
}
