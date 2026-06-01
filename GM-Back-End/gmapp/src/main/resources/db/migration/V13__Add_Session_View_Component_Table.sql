CREATE TABLE session_view_component(
    view_id UUID NOT NULL REFERENCES session_view(id) ON DELETE CASCADE,
    component_id UUID NOT NULL REFERENCES component_instance(id) ON DELETE CASCADE,
    position integer,
    PRIMARY KEY (view_id, component_id)
)