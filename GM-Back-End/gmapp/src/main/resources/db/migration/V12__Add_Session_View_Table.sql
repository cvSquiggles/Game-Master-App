CREATE TABLE session_view (
    id UUID PRIMARY KEY,
    session_id UUID NOT NULL REFERENCES game_session(id) ON DELETE CASCADE,
    name VARCHAR(255),
    icon VARCHAR(255),
    display_order integer
);