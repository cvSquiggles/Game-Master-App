CREATE TABLE score_tracker_state(
    id UUID PRIMARY KEY,
    component_id UUID UNIQUE NOT NULL REFERENCES component_instance(id) ON DELETE CASCADE,
    current_score  numeric,
    increment_presets JSONB,
    allow_negative boolean
)