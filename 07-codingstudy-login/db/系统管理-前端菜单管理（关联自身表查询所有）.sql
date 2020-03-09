SELECT
    b.frontend_menu_id,
    a.frontend_menu_name parentName,
    b.pid,
    b.frontend_menu_name,
    b.frontend_menu_sort,
    b.frontend_menu_url,
    b.description
FROM
    sys_frontend_menu_table a
        RIGHT JOIN
    sys_frontend_menu_table b ON b.pid = a.frontend_menu_id
ORDER BY b.frontend_menu_sort ASC