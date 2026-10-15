package org.keycloak.models.workflow.events;

import org.keycloak.events.Event;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.admin.OperationType;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.workflow.AbstractWorkflowEventProvider;
import org.keycloak.models.workflow.ResourceType;

public class UserUpdateProfileWorkflowEventProvider extends AbstractWorkflowEventProvider {

    public UserUpdateProfileWorkflowEventProvider(KeycloakSession session, String configParameter, String providerId) {
        super(session, configParameter, providerId);
    }

    @Override
    public ResourceType getSupportedResourceType() {
        return ResourceType.USERS;
    }

    @Override
    public boolean supports(Event event) {
        return EventType.UPDATE_PROFILE.equals(event.getType());
    }

    @Override
    public boolean supports(AdminEvent adminEvent) {
        return org.keycloak.events.admin.ResourceType.USER.equals(adminEvent.getResourceType())
                && OperationType.UPDATE.equals(adminEvent.getOperationType());
    }
}
