select
  t1.frontend_menu_id as id,
  t1.frontend_menu_name as name ,
  t1.pid as pid,
  t2.role_id as role_id
from sys_frontend_menu_table t1
left join
(
   select
     a.frontend_menu_id,
     a.frontend_menu_name,
     a.pid,
     a.frontend_menu_sort,
     b.role_id
   from sys_frontend_menu_table a,
     sys_role_table b,
     sys_role_frontend_menu_table c
   where  ( a.frontend_menu_id = c.frontend_menu_id or c.frontend_menu_id='*')
	 and b.role_id = c.role_id
     and b.role_id = '1'
) t2 on t2.frontend_menu_id = t1.frontend_menu_id
   order by t1.frontend_menu_sort asc