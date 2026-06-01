CREATE TABLE timer_state (
    id UUID PRIMARY KEY,
    component_id UUID UNIQUE NOT NULL REFERENCES component_instance(id) ON DELETE CASCADE,
    mode varchar(50),
    current_value_ms integer,
    buffer_ms integer,
    min_ms integer,
    max_ms integer,
    randomize_start boolean,
    status varchar(50),
    last_tick_at timestamp
);