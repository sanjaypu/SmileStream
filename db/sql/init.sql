-- Healenium backend expects a dedicated schema in the healenium database.
-- This runs once on first DB initialization (when the volume is empty).

CREATE SCHEMA IF NOT EXISTS healenium AUTHORIZATION healenium_user;

ALTER ROLE healenium_user IN DATABASE healenium SET search_path TO healenium, public;

GRANT ALL ON SCHEMA healenium TO healenium_user;
