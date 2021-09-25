create table table_name
(
    value1 text primary key,
    value2 text
);

CREATE PROCEDURE insert_data(a text, b text)
    LANGUAGE SQL
AS $$
INSERT INTO table_name VALUES (a, b);
$$;

CREATE OR REPLACE function get_students()
   returns setof table_name
   LANGUAGE SQL
AS $$

  select *
  from table_name;
$$;

SELECT get_students()
-- test
-- call insert_data('val1', 'val2');
-- call select_data();
-- select * from table_name