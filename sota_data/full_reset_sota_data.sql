\c postgres;

DO
$$
BEGIN
    PERFORM pg_terminate_backend(pid)
    FROM pg_stat_activity
    WHERE datname = 'sota_data'
      AND pid <> pg_backend_pid();
END
$$;

DROP DATABASE IF EXISTS sota_data;
CREATE DATABASE sota_data;

\c sota_data;
