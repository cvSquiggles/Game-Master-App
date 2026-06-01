CREATE TABLE template_view (
    id UUID PRIMARY KEY,
    template_id UUID NOT NULL REFERENCES game_template(id) ON DELETE CASCADE,
    name VARCHAR(255),
    icon VARCHAR(255),
    display_order integer
);