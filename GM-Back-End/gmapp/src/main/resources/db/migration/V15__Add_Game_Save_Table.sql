CREATE TABLE game_save(
    id UUID PRIMARY KEY,
    session_id UUID NOT NULL REFERENCES game_session(id) ON DELETE CASCADE,
    save_type varchar(10),
    state_blob JSONB,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
)