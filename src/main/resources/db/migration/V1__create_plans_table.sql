CREATE TYPE streaming_quality_enum AS ENUM (
  'NONE',
  'HD',
  'FHD',
  'UHD'
);

CREATE TABLE IF NOT EXISTS plans
(
    id
    BIGSERIAL
    PRIMARY
    KEY,
    name
    VARCHAR
(
    255
) UNIQUE NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    streaming_quality streaming_quality_enum NOT NULL,
    description TEXT
    );
