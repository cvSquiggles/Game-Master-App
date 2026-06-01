CREATE TABLE template_view_component(
    view_id UUID NOT NULL REFERENCES template_view(id) ON DELETE CASCADE,
    template_component_id UUID NOT NULL REFERENCES template_component(id) ON DELETE CASCADE,
    position integer,
    PRIMARY KEY (view_id, template_component_id)
)