CREATE TABLE rules_document_state(
    id UUID PRIMARY KEY,
    component_id UUID UNIQUE NOT NULL REFERENCES component_instance(id) ON DELETE CASCADE,
    title varchar(255),
    content_markdown text,
    version integer
)