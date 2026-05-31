CREATE TABLE player(
    id uuid PRIMARY KEY,
    session_id uuid NOT NULL REFERENCES game_session(id) ON DELETE CASCADE,
    display_name varchar,
    color_hex varchar(6),
    is_game_master boolean NOT NULL DEFAULT false,
    turn_order integer
)