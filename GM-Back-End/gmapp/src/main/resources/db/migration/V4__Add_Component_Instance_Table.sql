CREATE TABLE component_instance (
    id UUID PRIMARY KEY,
    session_id UUID NOT NULL REFERENCES game_session(id) ON DELETE CASCADE,
    owner_player_id UUID REFERENCES player(id) ON DELETE SET NULL,
    template_component_id UUID,
    component_type varchar(255),
    label varchar(50),
    config JSONB,
    display_order integer
);