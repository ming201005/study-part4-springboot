select distinct
     a.frontend_menu_id,
     a.frontend_menu_name,
     a.pid,
	 a.frontend_menu_url,
     a.frontend_menu_sort
from sys_frontend_menu_table a,
     sys_role_table b,
     sys_role_frontend_menu_table c,
     sys_user_table d,
     sys_role_user_table e
where ( a.frontend_menu_id = c.frontend_menu_id or c.frontend_menu_id='*')
	 and b.role_id = c.role_id
     and d.user_id = e.user_id
     and e.role_id = c.role_id
     and d.user_name='ming206'
order by a.frontend_menu_sort asc