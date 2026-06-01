CREATE TABLE resource_tracker_state (
    id UUID PRIMARY KEY,
    component_id UUID UNIQUE NOT NULL REFERENCES component_instance(id) ON DELETE CASCADE,
    resource_name varchar(255),
    unit_label varchar(50),
    current_value numeric,
    max_value numeric,
    min_value numeric,
    step_size numeric
)