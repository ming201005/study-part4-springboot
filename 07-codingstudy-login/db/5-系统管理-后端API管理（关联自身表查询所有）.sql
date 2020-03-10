SELECT
    b.backend_api_id,
    a.backend_api_name parentName,
    b.pid,
    b.backend_api_name,
    b.backend_api_sort,
    b.backend_api_url,
    b.description
FROM
    sys_backend_api_table a
        RIGHT JOIN
    sys_backend_api_table b ON b.pid = a.backend_api_id
ORDER BY b.backend_api_sort ASC