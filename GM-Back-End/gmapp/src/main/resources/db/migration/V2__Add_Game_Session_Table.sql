CREATE TABLE game_session(
    id uuid PRIMARY KEY,
    template_id uuid REFERENCES game_template(id) ON DELETE SET NULL,
    name varchar(255),
    session_code varchar(8) UNIQUE,
    status varchar(20),
    active_session_token uuid UNIQUE,
    last_active_at timestamp,
    started_at timestamp,
    ended_at timestamp
)