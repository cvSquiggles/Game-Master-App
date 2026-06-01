CREATE TABLE template_component (
    id UUID PRIMARY KEY,
    template_id UUID NOT NULL REFERENCES game_template(id) ON DELETE CASCADE,
    component_type VARCHAR(255),
    label VARCHAR(255),
    default_config JSONB,
    display_order integer
);